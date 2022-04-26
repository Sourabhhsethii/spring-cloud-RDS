package com.upgrad.springcloudrds;

import com.upgrad.springcloudrds.entities.Student;
import com.upgrad.springcloudrds.service.RDSService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Created by Sourabh 25 June 2021
 */
@SpringBootTest
class SpringcloudrdsApplicationTests {

    @Autowired
    private RDSService rdsService;

    @Test
    public void testDataReadAndWrite(){
        rdsService.store(new Student("Sourabh", 30));
        List<Student> students = rdsService.all();
        System.out.println(students.toString());
    }

}
