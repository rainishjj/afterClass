package com.rainish.proxy.myself;

import java.io.*;

public class RainishClassLoader extends ClassLoader{

    /**
     * 查看源码注释可以看到当jvm调用loadClass的时候，需要调用这个方法的实现，默认是抛出异常的
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) {
        String className = RainishClassLoader.class.getPackage().getName() + "." + name;
        File classPath = new File(RainishClassLoader.class.getResource("").getPath());
        if(classPath != null){
            File classFile = new File(classPath,name.replaceAll("\\.","/")+".class");
            if(classFile.exists()){
                try {
                    FileInputStream fileInputStream = new FileInputStream(classFile);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while (true){
                        try {
                            if (!((len = fileInputStream.read(buff)) != -1)) {
                                byteArrayOutputStream.write(buff,0,len);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                //将字节码转换成class对象，class对象里面存储的是jvm可识别的指令
                return this.defineClass(className,null,0,0);
            }
        }
        return null;
    }


}
