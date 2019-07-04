package lazySingleton;

import registerSingleton.EnumSingleton;

/**
 * @Author jiajiao
 * @Date 2019/6/28 11:43
 */
public class LazySingletonTest {
    public static void main(String[] args) {
        new Thread(() -> {
            EnumSingleton singleton = EnumSingleton.getInstance();
            System.out.println(Thread.currentThread().getName()+" ---实体对象：" + singleton);
        }).start();

        new Thread(() -> {
            EnumSingleton singleton = EnumSingleton.getInstance();
            System.out.println(Thread.currentThread().getName()+" ---实体对象：" + singleton);
        }).start();
//        new Thread(new LazyRunnable()).start();
//        new Thread(new LazyRunnable()).start();
//        new Thread(new LazyRunnable()).start();
//        new Thread(new LazyRunnable()).start();
//        new Thread(new LazyRunnable()).start();
    }
}
