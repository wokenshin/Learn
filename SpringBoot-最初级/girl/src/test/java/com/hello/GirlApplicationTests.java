package com.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlApplicationTests {

    @Test
    public void contextLoads() {
        //在使用 maven 打包 程序的时候 会默认执行所有的 test类，也可以在打包的时候忽略测试
    }

}
