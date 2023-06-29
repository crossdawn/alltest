package com.test.all.controller;

import com.test.all.mysql.TestDAO;
import com.test.all.mysql.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/mysql")
@RestController

public class MysqlController {
    @Autowired
    private TestService testService;

    @Autowired
    private TestDAO testDAO;

    @GetMapping(value = "/test500")
    @Deprecated
    public Integer test500(@RequestParam(required = true) Integer a) {
        throw new RuntimeException();
    }

    @PostMapping(value = "/test400")
    @Deprecated
    public Integer test400() {
        throw new RuntimeException();
    }

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
