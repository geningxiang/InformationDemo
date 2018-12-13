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
    /**
     * 根据ID查询栏位对象
     * @param id
     * @return
     */
    SortEntity getModel(int id);

    /**
     * 保存
     * @param model
     */
    void save(SortEntity model);

    /**
     * 更新
     * @param model
     */
    void update(SortEntity model);

    /**
     * 删除
     * @param id
     */
    void deleteById(int id);

    /**
     * 获取全部列表
     * @return
     */
    List<SortEntity> getList();
}
