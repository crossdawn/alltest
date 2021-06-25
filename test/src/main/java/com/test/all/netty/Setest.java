package com.test.all.netty;


import com.test.all.jdk.lang.Person;

import java.io.*;

public class Setest {
    public static void main(String[] args) {

        //将Person对象序列化
//        SerializePerson();

        Person person =DeserializePerson();
        System.err.println(person.getAge());
    }


    /**
     *
     * @author crazyandcoder
     * @Title: 序列化Person对象，将其存储到 E:/hello.txt文件中
     * @param
     * @return void
     * @throws
     * @date [2015-8-5 上午11:21:27]
     */
    private static void SerializePerson() {
        Person person =new Person();
        person.setAge(30);
        ObjectOutputStream outputStream = null;
        try {
            outputStream=new ObjectOutputStream(new FileOutputStream("E:/hello.txt"));
            outputStream.writeObject(person);
            System.out.println("序列化成功。");
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 执行反序列化过程生产Person对象
     *
     * @author crazyandcoder
     * @Title: DeserializePerson
     * @param @return
     * @return Person
     * @throws
     * @date [2015-8-5 下午1:30:12]
     */
    private static Person DeserializePerson() {

        Person person = null;
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream("E:/hello.txt"));
            try {
                person = (Person) inputStream.readObject();
                System.out.println("执行反序列化过程成功。");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return person;
    }



}
