import com.google.gson.Gson;

import java.io.*;

/**
 * 克隆的具体工具类
 */
public class CloneUtil {
    public static PrototypeBean clone(PrototypeBean source){
        Gson gson = new Gson();
        String jsonString = gson.toJson(source);
        System.out.println("jsonString " + jsonString);
        return gson.fromJson(jsonString,PrototypeBean.class);
    }

}
