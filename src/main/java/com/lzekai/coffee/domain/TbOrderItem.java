package com.lzekai.coffee.domain;

public class TbOrderItem {
    private Long id;

    private Long itemId;

    private Long orderId;

    private Boolean ingredients;

    private String unitPrice;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Boolean getIngredients() {
        return ingredients;
    }

    public void setIngredients(Boolean ingredients) {
        this.ingredients = ingredients;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", itemId=").append(itemId);
        sb.append(", orderId=").append(orderId);
        sb.append(", ingredients=").append(ingredients);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", name=").append(name);
        sb.append("]");
        return sb.toString();
    }
}