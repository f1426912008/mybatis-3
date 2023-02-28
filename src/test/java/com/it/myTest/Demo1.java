package com.it.myTest;

import com.github.pagehelper.PageHelper;
import com.it.bean.Student;
import com.it.mapper.StudentMapper;
import com.it.myTest.base.BaseDemo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demo1 extends BaseDemo {

    @Test
    public void test1() {
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectAll();
        students.forEach(System.out::println);
    }

    @Test
    public void test2() {
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByCondition("张三");
        students.forEach(System.out::println);
    }

    @Test
    public void test3() {
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.selectById("1");
        System.out.println(student);
    }

    @Test
    public void test4() {
        try {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            List<Student> list = new ArrayList<>();
            for (int i = 0; i < 50; i++) {
                Student student = new Student();
                student.setName(String.valueOf(i));
                student.setGender(i % 2 == 0 ? "男" : "女");
                student.setMajor("python");
                student.setGrade(new Random().nextInt(100) + "");
                list.add(student);
            }
            Integer result = mapper.insertBatch(list);
            System.out.println(result);

            // session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

    @Test
    public void test5() {
        // 分页需要进行配置分页拦截器
        PageHelper.startPage(1, 2);
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectAll();
        students.forEach(System.out::println);
    }

}
