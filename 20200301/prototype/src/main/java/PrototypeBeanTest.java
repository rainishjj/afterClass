import java.util.ArrayList;
import java.util.List;

public class PrototypeBeanTest {
    public static void main(String[] args) {
        PrototypeBean prototypeBean = new PrototypeBean();
        prototypeBean.setCount(0);
        prototypeBean.setName("test");

        List<String> hobbies = new ArrayList<>();
        hobbies.add("panio");
        hobbies.add("other");
        prototypeBean.setHobbies(hobbies);

        PrototypeBean cloneBean = CloneUtil.clone(prototypeBean);

        System.out.println(prototypeBean == cloneBean);
        System.out.println(prototypeBean.getHobbies() == cloneBean.getHobbies());
    }
}
