package com.imooc.dateobject.mapper;

import com.imooc.dateobject.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 使用mybatis 对 类目 进行 增删改查
 * @author kenshin
 * @date 2018/8/6 上午9:06
 */
public interface ProductCategoryMapper {

    //方式一
    @Insert("insert into product_category(category_name, category_type) values (#{category_name, jdbcType=VARCHAR}, #{category_type, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object>map);
    //这里返回值的 int 代表 插入的条数，

    //方式二
    @Insert("insert into product_category(category_name, category_type) values (#{categoryName, jdbcType=VARCHAR}, #{categoryType, jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory);

    //查询
    @Select("select * from product_category where category_type = #{categoryType}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    ProductCategory findByCategoryType(Integer categoryType);

    //查询
    @Select("select * from product_category where category_name = #{categoryName}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ProductCategory> findByCategoryNme(String categoryName);

    //更新[根据字段]
    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByCatgeoryType(@Param("categoryName") String categoryName,
                             @Param("categoryType") Integer categoryType);

    //更新【根据对象】
    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByObject(ProductCategory productCategory);

    //删除
    @Delete("delete from product_category where category_type = #{categoryType}")
    int deleteByCategoryType(Integer categoryType);

    //查询 通过使用xml文件来实现查询
    ProductCategory selectByCategoryType(Integer categoryType);
}
