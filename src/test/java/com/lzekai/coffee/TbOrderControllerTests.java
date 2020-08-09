package com.lzekai.coffee;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzekai.coffee.controller.TbOrderController;
import com.lzekai.coffee.domain.TbItem;
import com.lzekai.coffee.entity.ItemEntity;
import com.lzekai.coffee.entity.OrderEntity;
import com.lzekai.coffee.entity.ResponseResult;
import com.lzekai.coffee.service.TbItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TbOrderControllerTests {

    @Autowired
    private TbOrderController tbOrderController;
    @Autowired
    private TbItemService tbItemService;

    /**
     * 添加订单
     */
    @Test
    void addTest() throws JsonProcessingException {
        List<TbItem> list = tbItemService.list();
        List<ItemEntity> param = new ArrayList<>();
        String json = "[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"摩卡\",\n" +
                "        \"unitPrice\": \"10\",\n" +
                "        \"created\": 1596729600000,\n" +
                "        \"desc\": \"\",\n" +
                "        \"updated\": 1596729600000,\n" +
                "        \"ingredients\": false,\n" +
                "        \"parentItemId\" : 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"卡普奇诺\",\n" +
                "        \"unitPrice\": \"15\",\n" +
                "        \"created\": 1596729600000,\n" +
                "        \"desc\": \" \",\n" +
                "        \"updated\": 1596729600000,\n" +
                "        \"ingredients\": false,\n" +
                "        \"parentItemId\" : 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"name\": \"美式\",\n" +
                "        \"unitPrice\": \"18\",\n" +
                "        \"created\": 1596729600000,\n" +
                "        \"desc\": \"\",\n" +
                "        \"updated\": 1596729600000,\n" +
                "        \"ingredients\": false,\n" +
                "        \"parentItemId\" : 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 4,\n" +
                "        \"name\": \"糖\",\n" +
                "        \"unitPrice\": \"1\",\n" +
                "        \"created\": 1596729600000,\n" +
                "        \"desc\": \"\",\n" +
                "        \"updated\": 1596729600000,\n" +
                "        \"ingredients\": true,\n" +
                "        \"parentItemId\" : 3\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 5,\n" +
                "        \"name\": \"牛奶\",\n" +
                "        \"unitPrice\": \"8\",\n" +
                "        \"created\": 1596729600000,\n" +
                "        \"desc\": \"\",\n" +
                "        \"updated\": 1596729600000,\n" +
                "        \"ingredients\": true,\n" +
                "        \"parentItemId\" : 3\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 6,\n" +
                "        \"name\": \"奶盖\",\n" +
                "        \"unitPrice\": \"12\",\n" +
                "        \"created\": 1596729600000,\n" +
                "        \"desc\": \"\",\n" +
                "        \"updated\": 1596729600000,\n" +
                "        \"ingredients\": true,\n" +
                "        \"parentItemId\" : 3\n" +
                "    }\n" +
                "]";
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, ItemEntity.class);
        List<ItemEntity> o = mapper.readValue(json, javaType);
        ResponseResult rs = tbOrderController.add(o);
        System.out.println(rs);
    }

    /**
     * 获取订单状态
     */
    @Test
    void stateTest(){
        ResponseResult rs = tbOrderController.state(15L);
        System.out.println(rs);
    }

    /**
     * 获取订单
     */
    @Test
    void getTest(){
        ResponseResult rs = tbOrderController.get(15L);
        OrderEntity data = (OrderEntity) rs.getData();
        System.out.println(data.getItems());
    }


    /**
     * 更改订单状态
     * @return
     */
    @Test
    void stateUpdateTest(){
        ResponseResult rs = tbOrderController.stateUpdate(15L, 1);
        System.out.println(rs);
    }
}
