package com.girl.service;

import com.girl.domain.Girl;
import com.girl.enums.ResultEnum;
import com.girl.exception.GirlException;
import com.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author kenshin
 * @date 2018/6/29 上午12:57
 */
@Service
public class GirlService {

    @Autowired
    GirlRepository girlRepository;

    //添加事务 由于使用事务之后 里面的操作要么全部执行成功，要么都不执行
    @Transactional
    public void insertTwoGirl(){
        Girl girlA = new Girl();
        Girl girlB = new Girl();

        girlA.setAge(18);
        girlA.setCupSize("C");

        girlB.setAge(28);
        girlB.setCupSize("D");

        girlRepository.save(girlA);
        girlRepository.save(girlB);

    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();

        if (age < 10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }
        if (age < 15 && age >= 10){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /***
     * 通过id查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.getOne(id);
    }

}
