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
 * a. synchronized关键字
 * b. synchronized代码块
 *
 * 问题3： 私有变量为什么不是final的
 *
 * 因为定义为final就意味着定义的时候必须被赋值，且不能改变值。那么就变成了饿汉式
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
}
