package com.netintech.common.utils.bean;

public class RestResult {

    private static final long serialVersionUID = 1L;

    private Integer returnCode;

    private String reason;

    private Object obj;

    private String status;
    
    private boolean isadmin;

    public RestResult(Integer returnCode) {
        this.returnCode=returnCode;
    }

    public RestResult(Integer returnCode, String reason) {
        this.returnCode = returnCode;
        this.reason = reason;
    }

    public RestResult(Integer returnCode, Object obj) {
        this.returnCode = returnCode;
        this.obj = obj;
    }
   

    public RestResult(Integer returnCode, String reason, Object obj) {
        this.returnCode = returnCode;
        this.reason = reason;
        this.obj = obj;
    }

    public RestResult(Integer returnCode, String reason, Object obj, String status) {
        this.returnCode = returnCode;
        this.reason = reason;
        this.obj = obj;
        this.status = status;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
