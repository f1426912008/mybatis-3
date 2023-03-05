package com.it.mapper;

import com.it.bean.SysUserinfo;

import java.util.List;

/**
 * @author 范亚鑫
 * @description 针对表【sys_userinfo】的数据库操作Mapper
 * @createDate 2023-03-05 23:05:23
 * @Entity com.it.bean.SysUserinfo
 */
public interface SysUserinfoMapper {

    List<SysUserinfo> queryAll();

}




