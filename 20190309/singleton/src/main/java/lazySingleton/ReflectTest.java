package lazySingleton;

import java.lang.reflect.Constructor;

/**
 * @author jiajiao
 * @Classname:
 * @Description:
 * @Date 2022/2/115:17 下午
 */
public class ReflectTest {
    public static void main(String[] args) {
        try {
            Class<?> clazz = InnerClassSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            //反射能破坏之前的一切单例，除了注册式单例
            Object instance1 = c.newInstance();
            Object instance2 = c.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
