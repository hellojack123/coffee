package com.lzekai.coffee.controller;

import com.lzekai.coffee.domain.TbItem;
import com.lzekai.coffee.entity.ResponseResult;
import com.lzekai.coffee.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("item")
public class TbItemController {

    @Autowired
    private TbItemService tbItemService;


    /**
     * 查询所有商品
     * @return
     */
    @GetMapping("list")
    public ResponseResult list(){
        List<TbItem> list = tbItemService.list();
        return new ResponseResult(20000,"查询成功",list);
    }
}
