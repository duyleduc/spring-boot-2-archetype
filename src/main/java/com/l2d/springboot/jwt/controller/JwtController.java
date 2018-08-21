package com.l2d.springboot.jwt.controller;

import com.l2d.springboot.common.security.JWTReactiveAuthenticationManager;
import com.l2d.springboot.common.security.JWTToken;
import com.l2d.springboot.common.security.TokenProvider;
import com.l2d.springboot.jwt.dto.LoginVM;
import javassist.tools.web.BadHttpRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Validator;

/**
 * created by duc-d on 8/17/2018
 */
@RestController
public class JwtController {
    private final TokenProvider tokenProvider;

    private final JWTReactiveAuthenticationManager authenticationManager;

    private final Validator validation;

    public JwtController(TokenProvider tokenProvider,
                         JWTReactiveAuthenticationManager authenticationManager,
                         Validator validation) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
        this.validation = validation;
    }

    @RequestMapping(value = "/authorize", method = RequestMethod.POST)
    public Mono<JWTToken> authorize(@RequestBody LoginVM loginVM) {
        if (!this.validation.validate(loginVM).isEmpty()) {
            return Mono.error(new BadHttpRequest());
        }

        Authentication authenticationToken =
                new UsernamePasswordAuthenticationToken(loginVM.getUsername(), loginVM.getPassword());

        Mono<Authentication> authentication = this.authenticationManager.authenticate(authenticationToken);
        authentication.doOnError(throwable -> {
            throw new BadCredentialsException("Bad crendentials");
        });
        ReactiveSecurityContextHolder.withAuthentication(authenticationToken);

        return authentication.map(auth -> {
            String jwt = tokenProvider.createToken(auth);
            return new JWTToken(jwt);
        });
    }
}
