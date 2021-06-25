package com.test.all.spring;

import org.springframework.boot.CommandLineRunner;

//@Component
public class CommandLineRunnerTest implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.err.println("CommandLineRunner");
    }
}
