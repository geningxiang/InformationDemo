package com.caimao.information.controller;

import com.caimao.information.common.ResponseEntity;
import com.caimao.information.common.ResponseStatus;
import com.caimao.information.entity.SortEntity;
import com.caimao.information.service.ISortService;
import org.apache.commons.lang3.StringUtils;
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


    /**
     * 修改
     * @param model
     * @return
     */
    @RequestMapping(value="/sort/{id}", method= RequestMethod.PUT)
    public ResponseEntity<SortEntity> update(@PathVariable("id") Integer id, SortEntity model){
        if(id == null || model == null || StringUtils.isEmpty(model.getSortName())){
            return ResponseEntity.of(ResponseStatus.BAD_REQUEST, "参数错误", null);
        }
        model.setId(id);
        if(model.getOrderNum() == null) {
            model.setOrderNum(999);
        }
        sortService.update(model);
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value="/sort/{id}", method= RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Integer id){
        if(id == null){
            return ResponseEntity.of(ResponseStatus.BAD_REQUEST, "参数错误", null);
        }
        sortService.deleteById(id);
        return ResponseEntity.ok(null);
    }


}
