package com.tuita.bookkeeping.bean;

public class InsertItemBean {
    private String insertTypeName;
    private int insertType;
    private String name;
    private boolean isDefault;

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getInsertTypeName() {
        return insertTypeName;
    }

    public void setInsertTypeName(String insertTypeName) {
        this.insertTypeName = insertTypeName;
    }

    public int getInsertType() {
        return insertType;
    }

    public void setInsertType(int insertType) {
        this.insertType = insertType;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
