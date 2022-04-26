package com.upgrad.springcloudrds.service;

import com.upgrad.springcloudrds.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class RDSService {

    private final JdbcTemplate jdbctemplate;

    @Autowired
    public RDSService(DataSource dataSource){
        this.jdbctemplate = new JdbcTemplate(dataSource);
    }

    public List<Student> all(){
        return this.jdbctemplate.query("SELECT * FROM Student", new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Student(resultSet.getString("name"), resultSet.getInt("age"));
            }
        });
    }

    @Transactional
    public void store(Student student){
        this.jdbctemplate.update("INSERT INTO Student(name,age) VALUES (?,?)", student.getName(), student.getAge());
    }
}
