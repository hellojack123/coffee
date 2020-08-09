package com.lzekai.coffee.controller;

import com.lzekai.coffee.domain.TbItem;
import com.lzekai.coffee.domain.TbOrder;
import com.lzekai.coffee.entity.ItemEntity;
import com.lzekai.coffee.entity.OrderEntity;
import com.lzekai.coffee.entity.ResponseResult;
import com.lzekai.coffee.service.TbOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("order")
public class TbOrderController {

    @Autowired
    private TbOrderService tbOrderService;

    /**
     * 添加订单
     *
     * @param param
     * @return
     */
    @PostMapping("add")
    public ResponseResult add(@RequestBody List<ItemEntity> param) {
        TbOrder tbOrder = tbOrderService.insertList(param);
        return new ResponseResult(20000, "添加成功", tbOrder);
    }

    /**
     * 获取订单状态
     *
     * @param id
     * @return
     */
    @GetMapping("state/{id}")
    public ResponseResult state(@PathVariable Long id) {
        int state = tbOrderService.getStateById(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("state", state);
        return new ResponseResult(20000, "查询成功", map);
    }

    /**
     * 获取订单
     *
     * @param id
     * @return
     */
    @GetMapping("get/{id}")
    public ResponseResult get(@PathVariable Long id) {
        OrderEntity orderEntity = tbOrderService.getOrderEntityById(id);
        return new ResponseResult(20000, "查询成功", orderEntity);
    }

    /**
     * 更改订单状态
     *
     * @param id
     * @param state
     * @return
     */
    @PostMapping("state/update/{id}")
    public ResponseResult stateUpdate(@PathVariable Long id, Integer state) {
        TbOrder order = tbOrderService.getById(id);
        order.setPayState(state);
        tbOrderService.update(order);
        return new ResponseResult(20000, "修改状态成功", null);
    }

}
