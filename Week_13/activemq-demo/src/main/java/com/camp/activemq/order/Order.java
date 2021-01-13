package com.camp.activemq.order;

import java.time.LocalDateTime;

public class Order {
    private int id;
    private int user_id;
    private int commodity_id;
    private int quantity;
    private LocalDateTime created_ts;
    private LocalDateTime updated_ts;

    public Order() {
    }

    public Order(int id, int user_id, int commodity_id, int quantity) {
        this.id = id;
        this.user_id = user_id;
        this.commodity_id = commodity_id;
        this.quantity = quantity;
        this.created_ts = LocalDateTime.now();
        this.updated_ts = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(int commodity_id) {
        this.commodity_id = commodity_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreated_ts() {
        return created_ts;
    }

    public void setCreated_ts(LocalDateTime created_ts) {
        this.created_ts = created_ts;
    }

    public LocalDateTime getUpdated_ts() {
        return updated_ts;
    }

    public void setUpdated_ts(LocalDateTime updated_ts) {
        this.updated_ts = updated_ts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (user_id != order.user_id) return false;
        if (commodity_id != order.commodity_id) return false;
        if (quantity != order.quantity) return false;
        if (created_ts != null
                ? !created_ts.equals(order.created_ts)
                : order.created_ts != null) return false;
        return updated_ts != null
                ? updated_ts.equals(order.updated_ts)
                : order.updated_ts == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + user_id;
        result = 31 * result + commodity_id;
        result = 31 * result + quantity;
        result = 31 * result + (created_ts != null
                ? created_ts.hashCode()
                : 0);
        result = 31 * result + (updated_ts != null
                ? updated_ts.hashCode()
                : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", commodity_id=" + commodity_id +
                ", quantity=" + quantity +
                ", created_ts=" + created_ts +
                ", updated_ts=" + updated_ts +
                '}';
    }
}
