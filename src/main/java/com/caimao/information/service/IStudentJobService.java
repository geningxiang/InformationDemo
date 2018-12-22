package com.caimao.information.service;

import com.caimao.information.entity.SortEntity;
import com.caimao.information.entity.StudentJobEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/22 21:33
 */
public interface IStudentJobService {
    StudentJobEntity getModel(String studentId);

    void save(StudentJobEntity model);

    void update(StudentJobEntity model);

    void deleteById(String id);

    List<SortEntity> getList();
}
