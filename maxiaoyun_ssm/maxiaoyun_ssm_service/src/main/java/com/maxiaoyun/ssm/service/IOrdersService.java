package com.maxiaoyun.ssm.service;

import com.maxiaoyun.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {

    public List<Orders> findAll(int page,int size) throws Exception;

    Orders findById(String ordersId) throws Exception;
}
