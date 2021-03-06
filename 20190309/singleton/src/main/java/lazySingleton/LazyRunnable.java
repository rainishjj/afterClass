package lazySingleton;

/**
 * @Author jiajiao
 * @Date 2019/6/28 11:35
 * HugerRunnable实现runnable，必须重载run方法
 */
public class LazyRunnable implements Runnable {
    //    @Override
//    public void run() {
//        LazySingleton singleton = LazySingleton.getInstance2();
//        System.out.println(Thread.currentThread().getName()+" ---实体对象：" + singleton);
//    }
    @Override
    public void run() {
        InnerClassSingleton singleton = InnerClassSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + " ---实体对象：" + singleton);
    }
}
