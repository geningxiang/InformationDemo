package com.caimao.information.service.impl;

import com.caimao.information.entity.StudentJobEntity;
import com.caimao.information.service.IStudentJobService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/22 21:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/*.xml"})
public class StudentJobServiceImplTest {

    @Autowired
    private IStudentJobService studentJobService;

    @Test
    public void getModel() {
    }

    @Test
    public void save() {
        StudentJobEntity model = new StudentJobEntity();
        model.setStudentId("154173335");

        studentJobService.save(model);
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void getList() {
    }
}