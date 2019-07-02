package lazySingleton;

/**
 * @Author jiajiao
 * @Date 2019/6/28 11:43
 *
 * 问题1： 懒汉式为什么不是线程安全的
 *
 * 因为getInstance方法不是原子操作，在多线程环境下，有可能有如下情况：
 * 线程1执行到line25行时，已经进行了判断，但是还没有new对象；此时线程2也执行到line24了，判断还是空，也会进入line 25.那么线程1和2都会创建对象
 *
 * 问题2： 如何保证线程安全,几种方法的区别
 *
 * a. synchronized 关键字
 *    synchronized定义在方法上，是锁整个类，而且当类是同一个实例的时候才是同一把锁，如果是不同的实例，则获得的是不同的锁
 * b. synchronized代码块
 *    锁方法，不锁类，其他方法依然可以访问，锁的范围小些，性能相对好些
 *
 * 问题3： 私有变量为什么不是final的
 *
 * 因为定义为final就意味着定义的时候必须被赋值，且不能改变值。那么就变成了饿汉式
 *
 * 问题4： 下面的方法getInstance2有没有线程安全问题？
 */
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton(){}

    public synchronized static LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

    public  static LazySingleton getInstance1(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

    public static LazySingleton getInstance2(){
        synchronized (LazySingleton.class) {
            if (instance == null) {
                instance = new LazySingleton();
            }
            return instance;
        }
    }
}
