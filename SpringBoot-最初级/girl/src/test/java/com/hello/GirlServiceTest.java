package com.hello;

import com.girl.domain.Girl;
import com.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author kenshin
 * @date 2018/7/11 下午3:40
 */
@RunWith(SpringRunner.class)//注解的意思是 当前要在测试环境里运行
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        Girl girl = girlService.findOne(19);
        Assert.assertEquals(new Integer(5), girl.getAge());
    }

}
