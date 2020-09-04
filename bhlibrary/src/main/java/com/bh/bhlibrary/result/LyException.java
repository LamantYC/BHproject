package com.bh.bhlibrary.result;

import lombok.Data;

/**
 * 自定义的异常
 */
@Data
public class LyException extends RuntimeException {

    private Integer status;


    public LyException(Integer status,String message) {
        super(message);
        this.status = status;
    }

    public LyException(String message, Throwable cause, Integer status) {
        super(message, cause);
        this.status = status;
    }

    public LyException(ExceptionEnum enums) {
        super(enums.getMessage());
        this.status = enums.getStauts();
    }
}
