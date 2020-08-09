package com.lzekai.coffee;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzekai.coffee.controller.TbItemController;
import com.lzekai.coffee.entity.ResponseResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TbItemControllerTests {

    @Autowired
    private TbItemController tbItemController;

    @Test
    void listTest() throws JsonProcessingException {
        ResponseResult rs = tbItemController.list();
        System.out.println(new ObjectMapper().writeValueAsString(rs.getData()));
        System.out.println(rs);
    }

}
