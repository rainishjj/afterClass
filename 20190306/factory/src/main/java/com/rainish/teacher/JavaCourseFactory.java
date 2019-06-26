package com.rainish.teacher;

/**
 * @Author jiajiao
 * @Date 2019/6/26 14:43
 */
public class JavaCourseFactory implements CourseFactory {
    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
