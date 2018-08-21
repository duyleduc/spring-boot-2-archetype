package com.l2d.springboot.common.security;

import com.l2d.springboot.common.AbstractException;
import org.springframework.http.HttpStatus;

/**
 * @author dle on 7/16/18
 * @project rdb-api
 */
public class UnauthorizedException extends AbstractException {

    public UnauthorizedException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
