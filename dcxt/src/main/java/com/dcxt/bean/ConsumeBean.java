package com.dcxt.bean;

import java.util.Date;

public class ConsumeBean {
    private int id;
    private int tid;
    private String unameaccount;
    private String tablenum;
    private Date createtime;
    private Double Total;
    private String consumptionnum;
    private int isaccount;
    private int isinvalid;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsinvalid() {
        return isinvalid;
    }

    public void setIsinvalid(int isinvalid) {
        this.isinvalid = isinvalid;
    }


    public String getUnameaccount() {
        return unameaccount;
    }

    public void setUnameaccount(String unameaccount) {
        this.unameaccount = unameaccount;
    }

    public String getTablenum() {
        return tablenum;
    }

    public void setTablenum(String tablenum) {
        this.tablenum = tablenum;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double total) {
        Total = total;
    }

    public String getConsumptionnum() {
        return consumptionnum;
    }

    public void setConsumptionnum(String consumptionnum) {
        this.consumptionnum = consumptionnum;
    }

    public int getIsaccount() {
        return isaccount;
    }

    public void setIsaccount(int isaccount) {
        this.isaccount = isaccount;
    }
}
