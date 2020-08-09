package com.lzekai.coffee.domain;

import java.util.Date;

public class TbItem {
    /**
     * 主键
     */
    private Long id;

    /**
     * 商品名
     */
    private String name;

    /**
     * 单价
     */
    private String unitPrice;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 商品描述
     */
    private String desc;

    /**
     * 更新时间
     */
    private Date updated;

    /**
     * 是否为辅料
     */
    private Boolean ingredients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Boolean getIngredients() {
        return ingredients;
    }

    public void setIngredients(Boolean ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", created=").append(created);
        sb.append(", desc=").append(desc);
        sb.append(", updated=").append(updated);
        sb.append(", ingredients=").append(ingredients);
        sb.append("]");
        return sb.toString();
    }
}