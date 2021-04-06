package com.test.all.mysql;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDAO {

    @Select("select 1 ")
    int select();

    @Insert("insert into t(a) values (2)")
    int insert();
}
