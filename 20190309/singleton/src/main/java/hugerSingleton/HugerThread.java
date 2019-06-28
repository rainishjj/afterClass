package hugerSingleton;

/**
 * @Author jiajiao
 * @Date 2019/6/28 11:05
 */
public class HugerThread extends Thread {

    @Override
    public void run() {
        HungerSingleton singleton = HungerSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+" ---实体对象：" + singleton);
    }
}
