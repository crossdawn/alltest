package com.test.all.controller;

import com.test.all.mysql.TestDAO;
import com.test.all.mysql.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/mysql")
@RestController

public class MysqlController {
    @Autowired
    private TestService testService;

    @Autowired
    private TestDAO testDAO;

    @GetMapping(value = "/trx")
    @Deprecated
    public Integer trx(Integer flag) {
        testService.trx(flag);
        return flag;
    }

    @GetMapping(value = "/trxWithLimit")
    @Deprecated
    public Integer trxWithLimit(Integer flag) {
        testService.trxWithLimit(flag);
        return flag;
    }

    @GetMapping("/initDb")
    public String initDb(int page) {
        for (int i = 0; i < page; i++) {
            testDAO.insertBatch(testService.genData(1000,"mysql"));
        }
        return "插入数据完成";
    }

}
