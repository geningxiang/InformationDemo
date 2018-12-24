package com.caimao.information.service.impl;

import com.caimao.information.dao.StudentJobDAO;
import com.caimao.information.entity.SortEntity;
import com.caimao.information.entity.StudentJobEntity;
import com.caimao.information.service.IStudentJobService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/22 21:33
 */
@Service
public class StudentJobServiceImpl implements IStudentJobService {

    private StudentJobDAO studentJobDAO;

    @Override
    public StudentJobEntity getModel(String studentId) {
        return studentJobDAO.getModel(studentId);
    }

    /**
     * 添加对象
     **/
    @Override
    public void save(StudentJobEntity model) {
        studentJobDAO.save(model);
    }

    /**
     * 更新对象
     **/
    @Override
    public void update(StudentJobEntity model) {
        studentJobDAO.update(model);
    }

    /**
     * 删除对象
     **/
    @Override
    public void deleteById(String id) {
        studentJobDAO.deleteById(id);
    }

    @Override
    public List<StudentJobEntity> getList() {
        String hql = "from StudentJobEntity order by studentId";
        return studentJobDAO.getList(hql);
    }

    public void setStudentJobDAO(StudentJobDAO studentJobDAO) {
        this.studentJobDAO = studentJobDAO;
    }
}
