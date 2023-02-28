package com.test.all.mysql;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDAO {

    List<Tb1> select(String sql);

    int insertBatch(@Param("records") List<Tb1> records);
}
