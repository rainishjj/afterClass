package com.rainish.main;

import com.rainish.teacher.CourseFactory;
import com.rainish.teacher.JavaCourseFactory;

/**
 * @Author jiajiao
 * @Date 2019/6/26 13:45
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
//        CourseFactory factory = new AFactoryCourse();
//        factory.create1().producer();
//        factory.create2().producer();
        CourseFactory courseFactory = new JavaCourseFactory();
        courseFactory.createNote().edit();
        courseFactory.createVideo().record();
    }
}
