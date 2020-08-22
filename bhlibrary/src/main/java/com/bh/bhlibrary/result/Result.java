package com.bh.bhlibrary.result;

import lombok.Data;

@Data
public class Result {
    private int code;
    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
