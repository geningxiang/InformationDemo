package com.caimao.information.controller;

import com.caimao.information.common.ResponseEntity;
import com.caimao.information.entity.SortEntity;
import com.caimao.information.service.ISortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: genx
 * @date: 2018/12/14 0:19
 */
@RestController
@RequestMapping("/")
public class SortController {

    @Autowired
    private ISortService sortService;

    @RequestMapping("/sorts")
    public ResponseEntity<List<SortEntity>> sorts() {
        List<SortEntity> list = sortService.getList();
        return ResponseEntity.ok(list);
    }

    @RequestMapping(value = "/sort/{id}", method = RequestMethod.GET)
    public SortEntity get(@PathVariable("id") Integer id) {
        SortEntity sortEntity = null;
        if (id != null) {
            sortEntity = sortService.getModel(id);
        }
        return sortEntity;
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public ResponseEntity<SortEntity> save(SortEntity sortEntity) {
        Assert.isNull(sortEntity.getId(), "参数错误");
        Assert.hasText(sortEntity.getSortName(), "请输入栏位名称");
        if (sortEntity.getOrderNum() == null) {
            sortEntity.setOrderNum(999);
        }
        sortService.save(sortEntity);
        return ResponseEntity.ok(sortEntity);
    }

    @RequestMapping(value = "/sort/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SortEntity> put(@PathVariable("id") Integer id, SortEntity sortEntity) {
        Assert.notNull(id, "参数错误");
        sortEntity.setId(id);
        Assert.hasText(sortEntity.getSortName(), "请输入栏位名称");
        if (sortEntity.getOrderNum() == null) {
            sortEntity.setOrderNum(999);
        }
        sortService.update(sortEntity);
        return ResponseEntity.ok(sortEntity);
    }

    @RequestMapping(value = "/sort/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        Assert.notNull(id, "参数错误");
        sortService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
