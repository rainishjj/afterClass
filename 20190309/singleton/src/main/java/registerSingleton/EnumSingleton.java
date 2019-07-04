package registerSingleton;

/**
 * @Author jiajiao
 * @Date 2019/7/4 14:29
 * 不明白为什么，要去理解Enum的机制
 */
public enum EnumSingleton {
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
