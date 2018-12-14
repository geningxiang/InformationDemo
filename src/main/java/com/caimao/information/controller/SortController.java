package com.caimao.information.controller;

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
    public List<SortEntity> sorts() {
        List<SortEntity> list = sortService.getList();
        return list;
    }

    @RequestMapping(value="/sort/{id}",method= RequestMethod.GET)
    public SortEntity get(@PathVariable("id") Integer id){
        SortEntity sortEntity = null;
        if(id != null) {
            sortEntity = sortService.getModel(id);
        }
        return sortEntity;
    }

    @RequestMapping(value="/sort",method=RequestMethod.POST)
    public SortEntity post(SortEntity sortEntity){
        Assert.notNull(sortEntity, "参数为空");
        Assert.hasText(sortEntity.getSortName(), "栏位名称不能为空");
        if(sortEntity.getOrderNum() == null) {
            sortEntity.setOrderNum(999);
        }
        sortService.save(sortEntity);
        return sortEntity;
    }

    @RequestMapping(value="/sort/{id}",method=RequestMethod.PUT)
    public SortEntity put(@PathVariable("id") Integer id){
        System.out.println("put"+id);
        return null;
    }

    @RequestMapping(value="/sort/{id}",method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        System.out.println("delete"+id);
        return "1";
    }
}
