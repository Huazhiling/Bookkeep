package com.tuita.bookkeeping.base;

import java.io.Serializable;


/**
 * 基础Bean
 * @author Administrator
 */
public class BaseBean implements Serializable {

    protected String message;
    protected int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
