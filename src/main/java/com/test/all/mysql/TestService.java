package com.test.all.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestService {
    @Autowired
    private TestDAO testDAO;

//    @Transactional
    public void trx(){
        testDAO.insert();
        int i=1/0;
        testDAO.insert();

    }
}
