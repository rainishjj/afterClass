package com.rainish.othersSample;

import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import static org.apache.zookeeper.CreateMode.PERSISTENT;

/**
 * @Author jiajiao
 * @Date 2019/7/22 13:24
 */
public class DistributedLock implements Lock, Watcher {
    static String CONNECTION_STR = "localhost:2181";

    // zk客户端
    private ZooKeeper zk;
    //当前节点
    private String CURRENT_LOCk;
    //等待的当前节点前一个节点
    private String WAIT_LOCK;

    private CountDownLatch countDownLatch;
    //根节点
    private String ROOT_LOCK = "/lock";

    public DistributedLock() {

        try {
            zk = new ZooKeeper(CONNECTION_STR, 5000, this);
            //判断根节点是否存在
            Stat stat = zk.exists(ROOT_LOCK, false);
            if (null == stat) {
                //创建根节点为持久化节点
                zk.create(ROOT_LOCK, "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, PERSISTENT);
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void lock() {
        if (this.tryLock()) {
            //表示获取锁成功
            System.out.println(Thread.currentThread().getName() + "->" + CURRENT_LOCk + "获取锁成功");
            return;
        }
        //等待获取锁
        if (StringUtils.isNotEmpty(WAIT_LOCK)) {
            try {
                waitForLock(WAIT_LOCK);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //监听比自己小的上一个节点状态，如果上一个节点删除关闭会话了，则触发监控当前节点获取锁
    private void waitForLock(String waitLock) throws KeeperException, InterruptedException {
        Stat stat = zk.exists(waitLock, true);
        if (stat != null) {
            System.out.println(Thread.currentThread().getName() + "->" + "等待" + waitLock + "释放锁");
            //当前节点的上一个节点还存在
            countDownLatch = new CountDownLatch(1);
            //等待
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + "->" + "获取锁成功");
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        //创建临时有序节点
        try {
            CURRENT_LOCk = zk.create(ROOT_LOCK + "/", "0".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            //获取所有节点
            List<String> children = zk.getChildren(ROOT_LOCK, false);
            //创建一个有序的set
            SortedSet<String> sortedSet = new TreeSet<>();
            for (String child : children) {
                sortedSet.add(ROOT_LOCK + "/" + child);
            }
            //获取最小的节点
            String firstNode = sortedSet.first();
            //如果最小的节点等于当前节点，表示获取到了锁,并且不需要监控上一个节点
            if (CURRENT_LOCk.equals(firstNode)) {
                return true;
            }
            //获取比当前节点小的节点的数据，不包含当前节点
            SortedSet<String> lessThenMe = sortedSet.headSet(CURRENT_LOCk);
            if (!lessThenMe.isEmpty()) {
                //获取比当前节点更小的节点的最后一个节点
                WAIT_LOCK = lessThenMe.last();
            }
        } catch (KeeperException e) {

        } catch (InterruptedException e) {

        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        System.out.println(Thread.currentThread().getName() + "->释放锁");
        try {
            zk.delete(CURRENT_LOCk, -1);
            CURRENT_LOCk = null;
            zk.close();
        } catch (InterruptedException e) {

        } catch (KeeperException e) {

        }
        CURRENT_LOCk = null;

    }

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        //如果上一个节点删除，触发watch
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {

                try {
                    countDownLatch.await();
                    DistributedLock distributedLock = new DistributedLock();
                    distributedLock.lock();

                } catch (InterruptedException e) {

                }

            }, "Thread-" + i).start();
        }
        System.out.println("Game Start");
        countDownLatch.countDown();
        System.in.read();
    }
}
