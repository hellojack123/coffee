package com.lzekai.coffee.service.impl;

import com.lzekai.coffee.domain.TbItem;
import com.lzekai.coffee.domain.TbItemExample;
import com.lzekai.coffee.domain.TbOrderItem;
import com.lzekai.coffee.mapper.TbItemMapper;
import com.lzekai.coffee.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TbItemServiceImpl implements TbItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public List<TbItem> list() {
        return tbItemMapper.selectByExample(new TbItemExample());
    }

    @Override
    public int insert(TbItem tbItem) {
        return tbItemMapper.insert(tbItem);
    }

    @Override
    public List<TbItem> listByOrderItemList(List<TbOrderItem> tbOrderItems) {
        List<TbItem> res = new ArrayList<>();
        tbOrderItems.forEach(tbOrderItem -> {
            TbItem tbItem = tbItemMapper.selectByPrimaryKey(tbOrderItem.getItemId());
            res.add(tbItem);
        });
        return res;
    }

    @Override
    public TbItem getById(Long id) {
        return tbItemMapper.selectByPrimaryKey(id);
    }
}
