package com.maxiaoyun.ssm.dao;

import com.maxiaoyun.ssm.domain.Member;
import com.maxiaoyun.ssm.domain.Orders;
import com.maxiaoyun.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao {

    //多表操作
    //查询所有订单信息
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId",property = "product" ,javaType = Product.class,one = @One(select = "com.maxiaoyun.ssm.dao.IProductDao.findById"))
    })
    public List<Orders> findAll() throws Exception;

    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId",property = "product" ,javaType = Product.class,one = @One(select = "com.maxiaoyun.ssm.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.maxiaoyun.ssm.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = List.class,many = @Many(select = "com.maxiaoyun.ssm.dao.ITravellerDao.findByOrdersId"))

    })
    Orders findById(String ordersId) throws Exception;
}
