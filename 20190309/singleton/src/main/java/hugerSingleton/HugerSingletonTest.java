package hugerSingleton;

/**
 *问题1： 如何新起线程.
 * 如下是Java1.8的写法。
 * 注释掉的是传统的新起线程的两种方式
 *
 */
public class HugerSingletonTest
{
    public static void main( String[] args )
    {
        new Thread(() -> {
            HungerSingleton singleton = HungerSingleton.getInstance();
            System.out.println(Thread.currentThread().getName()+" ---实体对象：" + singleton);
        }).start();

        new Thread(() -> {
            HungerSingleton singleton = HungerSingleton.getInstance();
            System.out.println(Thread.currentThread().getName()+" ---实体对象：" + singleton);
        }).start();


        /**
         * 使用runnable新起线程，必须实现run方法
         * 备注： 不管用哪种方式，启动线程都是start方法
         */
        new Thread(new HugerRunnable()).start();
        new Thread(new HugerRunnable()).start();

        /**
         * 使用thread新起线程
         * HugerThread须根据需要覆盖run方法，非必须
         */
        new HugerThread().start();
        new HugerThread().start();
    }
}
