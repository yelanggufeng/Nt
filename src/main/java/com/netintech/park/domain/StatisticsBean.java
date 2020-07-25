package com.netintech.park.domain;

/**
 * @author summer
 * @date 2020/5/11 12:41
 */
public class StatisticsBean {

    //园区等级
    private Long id;
    private String name;
    private Long level;

    // 企业收入排行榜
    private Double amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
