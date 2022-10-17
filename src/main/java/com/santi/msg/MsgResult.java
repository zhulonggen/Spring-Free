package com.santi.msg;


public class MsgResult {
    private Object data;


    @Override
    public String toString() {
        return "MsgResult{" +
                "data=" + data +
                '}';
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public MsgResult(Object data) {
        this.data = data;
    }

    public MsgResult() {
    }
}
