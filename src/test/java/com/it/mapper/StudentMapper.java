package com.it.mapper;

import com.it.bean.Student;
import com.it.provider.StudentProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
* @author 范亚鑫
* @description 针对表【student】的数据库操作Mapper
* @createDate 2023-02-07 16:53:22
* @Entity com.it.bean.Student
*/
public interface StudentMapper {

    Student selectById(@Param("id") String id);

    List<Student> selectAll();

    @SelectProvider(type = StudentProvider.class, method = "queryByCondition")
    List<Student> selectByCondition(@Param("name") String name);

    Integer insertBatch(@Param("list") List<Student> list);

    List<Student> selectDefines(@Param("id") String id);
}




