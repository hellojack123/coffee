package com.lzekai.coffee.domain;

import java.util.Date;

public class TbOrder {
    /**
     * 主键
     */
    private Long id;

    /**
     * 总价格
     */
    private String price;

    /**
     * 订单创建时间
     */
    private Date created;

    /**
     * 订单状态（1、进行中，0、初始化，2、完成）
     */
    private Integer payState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", price=").append(price);
        sb.append(", created=").append(created);
        sb.append(", payState=").append(payState);
        sb.append("]");
        return sb.toString();
    }
}