/**
 * @Author jiajiao
 * @Date 2019/7/4 14:25
 * 写的几种单例的实现都考虑了常规用法的线程安全
 * 但是如果反射调用，又是否是线程安全的呢？不是，解决方案
 * 如果是序列化，反序列化后，是否又是线程安全呢？  不是，解决方案
 */
public class ReflactAttackTest {
}
