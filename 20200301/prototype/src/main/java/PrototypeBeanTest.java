import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrototypeBeanTest {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.add(1);
        a.add(1);
        System.out.println(a.toString());


        LinkedList b = new LinkedList();
        b.add(1);
        b.add(1);
        System.out.println(b.toString());

//        PrototypeBean prototypeBean = new PrototypeBean();
//        prototypeBean.setCount(0);
//        prototypeBean.setName("test");
//
//        List<String> hobbies = new ArrayList<>();
//        hobbies.add("panio");
//        hobbies.add("other");
//        prototypeBean.setHobbies(hobbies);
//
//        PrototypeBean cloneBean = CloneUtil.clone(prototypeBean);
//
//        System.out.println(prototypeBean == cloneBean);
//        System.out.println(prototypeBean.getHobbies() == cloneBean.getHobbies());
    }
}
