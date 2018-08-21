package com.l2d.springboot.common;

import org.springframework.http.HttpStatus;

/**
 * created by duc-d on 8/17/2018
 */
public abstract class AbstractException extends RuntimeException {
    protected HttpStatus status;

    protected int code;

    /**
     * ${@inheritDoc}
     */
    public AbstractException(String message) {
        super(message);
    }

    public abstract HttpStatus getStatus();

    public int getCode() {
        return code;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
