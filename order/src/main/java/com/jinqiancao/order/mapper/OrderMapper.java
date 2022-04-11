package com.jinqiancao.order.mapper;

import com.jinqiancao.order.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


/**
 * @author jinqiancao
 * @date 2022/3/4 21:45
 */
@Mapper
public interface OrderMapper {

    @Select("select * from orders where id = #{id}")
    Orders findById(Integer id);

    @Update("update orders set number = #{number} where id = #{id}")
    void update(@Param("number") Integer number, @Param("id") Integer id);
}
