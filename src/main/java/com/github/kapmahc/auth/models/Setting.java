package com.github.kapmahc.auth.models;

/**
 * Created by flamen on 16-12-13.
 */
public class Setting extends Model {
    private String key;
    private byte[] val;
    private boolean flag;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public byte[] getVal() {
        return val;
    }

    public void setVal(byte[] val) {
        this.val = val;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
