package com.caimao.information.service;

import com.caimao.information.entity.SortEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/13 22:43
 */
public interface ISortService {
    SortEntity getModel(int id);

    void save(SortEntity model);

    void update(SortEntity model);

    void deleteById(int id);

    List<SortEntity> getList();
}
