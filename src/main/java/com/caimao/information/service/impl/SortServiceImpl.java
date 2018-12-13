package com.caimao.information.service.impl;

import com.caimao.information.dao.SortDAO;
import com.caimao.information.entity.SortEntity;
import com.caimao.information.service.ISortService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/13 22:43
 */
@Service
public class SortServiceImpl implements ISortService {

    private SortDAO sortDAO;

    @Override
    public SortEntity getModel(int id) {
        return sortDAO.getModel(id);
    }

    /**
     * 添加对象
     **/
    @Override
    public void save(SortEntity model) {
        sortDAO.save(model);
    }

    /**
     * 更新对象
     **/
    @Override
    public void update(SortEntity model) {
        sortDAO.update(model);
    }

    /**
     * 删除对象
     **/
    @Override
    public void deleteById(int id) {
        sortDAO.deleteById(id);
    }

    @Override
    public List<SortEntity> getList(){
        String hql = "from SortEntity order by orderNum, id";
        return sortDAO.getList(hql);
    }


    public void setSortDAO(SortDAO sortDAO) {
        this.sortDAO = sortDAO;
    }
}
