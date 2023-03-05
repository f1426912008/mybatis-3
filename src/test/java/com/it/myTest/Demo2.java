package com.it.myTest;

import com.it.bean.SysUserinfo;
import com.it.mapper.SysUserinfoMapper;
import com.it.myTest.base.BaseDemo;
import org.junit.Test;

import java.util.List;

public class Demo2 extends BaseDemo {

    @Test
    public void test1() {
        SysUserinfoMapper mapper = session.getMapper(SysUserinfoMapper.class);
        List<SysUserinfo> list = mapper.queryAll();
        list.forEach(item -> System.out.println(item.getAddress()));
    }

}
