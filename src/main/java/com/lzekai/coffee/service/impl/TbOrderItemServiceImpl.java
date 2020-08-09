package com.lzekai.coffee.service.impl;

import com.lzekai.coffee.domain.TbOrderItem;
import com.lzekai.coffee.domain.TbOrderItemExample;
import com.lzekai.coffee.mapper.TbOrderItemMapper;
import com.lzekai.coffee.service.TbOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbOrderItemServiceImpl implements TbOrderItemService {

    @Autowired
    private TbOrderItemMapper tbOrderItemMapper;

    @Override
    public int insert(TbOrderItem tbOrderItem) {
        return tbOrderItemMapper.insertSelective(tbOrderItem);
    }

    @Override
    public List<TbOrderItem> listByOrderId(Long orderId) {
        TbOrderItemExample e = new TbOrderItemExample();
        e.createCriteria()
                .andOrderIdEqualTo(orderId);
        return tbOrderItemMapper.selectByExample(e);
    }
}
