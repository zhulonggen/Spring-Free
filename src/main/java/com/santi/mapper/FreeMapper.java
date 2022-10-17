package com.santi.mapper;

import com.santi.pojo.Free;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FreeMapper {
    /**
     * 查询free表
     * @return
     */
    @Select("select * from free;")
    List<Free> getFreeAll();

    //添加父级id
    @Insert("insert into free(pid) values (#{pid})")
    int addFreePid(Integer pid);

//    获取最新id
    
    @Select("select * from free order by id desc limit 1;")
    Free getNewId();

//    修改title
    @Update("update free set title=#{title} where id=#{id}")
    int updateTitle(@Param("title") String title,@Param("id") Integer id);

    @Delete("delete from free where id=#{id}")
    int del(@Param("id") Integer id);

    @Select("select pid from free id=#{id};")
    Free isPid(@Param("id") Integer id);

}
