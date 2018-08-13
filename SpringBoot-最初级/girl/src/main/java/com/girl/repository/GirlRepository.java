package com.girl.repository;

import com.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author kenshin
 * @date 2018/6/29 上午12:56
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    //通过年龄查询女生
    public List<Girl> findByAge(Integer age);

}
