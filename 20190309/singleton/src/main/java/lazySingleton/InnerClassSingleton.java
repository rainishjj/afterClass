package lazySingleton;

/**
 * @Author jiajiao
 * @Date 2019/7/3 11:39
 * 这种写法跟饿汉式很像，但是它确实一种懒汉式单例
 * 问题1. 问什么是懒汉式单例
 * 内部类的加载原理：
 * 内部类分为对象级别（非静态内部类）和类级别（静态内部类），类级内部类指的是，有static修饰的成员变量的内部类。如果没有static修饰的成员变量的内部类被称为对象级内部类。
 * 类级内部类相当于其外部类的static成员，它的对象与外部类对象间不存在依赖关系，相互独立，因此可直接创建。而对象级内部类的实例，是必须绑定在外部对象实例上的。
 * 类级内部类只有在第一次被使用的时候才被会装载。
 *
 * 优点：写法优雅，利用了Java的语法特点，性能高，避免内存浪费
 * 缺点：能够被反射破坏
 */
public class InnerClassSingleton {

    private InnerClassSingleton(){}

    public static InnerClassSingleton getInstance(){
        return InnerHolder.INSTANCE;
    }

    private static class InnerHolder{
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }
}
