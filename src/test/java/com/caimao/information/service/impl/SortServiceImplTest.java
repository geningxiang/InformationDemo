package com.caimao.information.service.impl;

import com.caimao.information.entity.SortEntity;
import com.caimao.information.service.ISortService;
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
 * @date: 2018/12/14 0:02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/*.xml", "classpath:/spring-mvc.xml"})
public class SortServiceImplTest {

    @Autowired
    private ISortService sortService;

    @Test
    public void getModel() {
    }

    @Test
    public void save() {
        SortEntity sortEntity = new SortEntity();
        sortEntity.setSortName("热门");
        sortEntity.setOrderNum(1);
        sortService.save(sortEntity);

        sortEntity = new SortEntity();
        sortEntity.setSortName("社会");
        sortEntity.setOrderNum(2);
        sortService.save(sortEntity);

        sortEntity = new SortEntity();
        sortEntity.setSortName("体育");
        sortEntity.setOrderNum(3);
        sortService.save(sortEntity);

        sortEntity = new SortEntity();
        sortEntity.setSortName("财经");
        sortEntity.setOrderNum(4);
        sortService.save(sortEntity);

        sortEntity = new SortEntity();
        sortEntity.setSortName("娱乐");
        sortEntity.setOrderNum(5);
        sortService.save(sortEntity);

        sortEntity = new SortEntity();
        sortEntity.setSortName("理财");
        sortEntity.setOrderNum(6);
        sortService.save(sortEntity);
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }
}