package com.rainish;

import com.netflix.curator.framework.CuratorFramework;
import com.netflix.curator.framework.CuratorFrameworkFactory;
import com.netflix.curator.framework.recipes.locks.InterProcessMutex;
import com.netflix.curator.retry.RetryNTimes;
import org.apache.zookeeper.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author jiajiao
 * @Date 2019/7/15 17:37
 */
public class RainishLock implements Lock {
//    String CONNECT_ADDR = "192.168.192.128:2181";
    String CONNECT_ADDR = "localhost:2181";

    private String path = "/lock";
    String previousPath = null;


    @Override
    public void lock() {
        try {
            ZooKeeper zooKeeper = new ZooKeeper(CONNECT_ADDR, 20000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    this.notifyAll();
                }
            });
//            CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(CONNECT_ADDR, new RetryNTimes(10,1000));
//            curatorFramework.start();
//            InterProcessMutex lock = new InterProcessMutex(curatorFramework, "/locks");
//            lock.acquire();
//        lock.release();
//            String parent = zooKeeper.create(path, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            String node = zooKeeper.create(path+"/", "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println("create node name:" + node);
            getLock(node, zooKeeper);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getLock(String node, ZooKeeper zookeeper) throws KeeperException, InterruptedException {
        boolean hasTheLock = false;
        while (!hasTheLock){ //TODO 为什么这里要循环获得锁？
            synchronized (this){
                boolean isMin = false;
                isMin = judgeMin(node, isMin, zookeeper);
                // 如果不是最小的，就阻塞
                if (!isMin) {
                    try {
//                        zookeeper.exists(previousPath, true);
                        zookeeper.exists(previousPath, new Watcher() {
                            @Override
                            public void process(WatchedEvent watchedEvent) {
                                this.notifyAll();
                            }
                        });
                        this.wait();
                    } catch (Exception e) {
                        throw e;
                    }
                }else {
                    System.out.println(Thread.currentThread().getName()+"-child:" + node + "获得锁");
                    hasTheLock = true;
                }

            }
        }

    }

    private boolean judgeMin(String node, boolean isMin, ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        List<String> childs = zooKeeper.getChildren(path, false);       // 节点里(/lock)所有的子节点
        Collections.sort(childs, (o1, o2) -> {
            Integer o1Number = Integer.valueOf(o1);
            Integer o2Number = Integer.valueOf(o2);
            if (o1Number > o2Number) {
                return 1;
            }
            if (Objects.equals(o1Number, o2Number)) {
                return 0;
            }
            return -1;
        });
        // 由于list已经由小到大排好序了，所以只需要跟最小的比就OK了
        isMin = isMin(node, childs.get(0));
        node = node.replace("/lock/","");
        setPreviousPath(node,childs);

        return isMin;
    }

    private synchronized void setPreviousPath(String node, List<String> childs) {
        int index = childs.indexOf(node);
        if(index != -1 && index!=0) {
            String previousPath = childs.get(index - 1);
            this.previousPath = path + "/"+previousPath;
        }
    }

    private boolean isMin(String node, String child) {
        Integer nodeNumber = Integer.valueOf(node.replace(path+"/",""));
        Integer childNumber = Integer.valueOf(child.replace(path+"/",""));
        if (nodeNumber <= childNumber) {
            return true;
        } else {
            return false;
        }
    }



    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
//        .notifyAll();
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
