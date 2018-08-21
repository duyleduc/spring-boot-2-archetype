package com.l2d.springboot.common.security;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * created by duc-d on 8/20/2018
 */
@ConfigurationProperties(prefix = "security.token")
@Setter
@Getter
@Data
public class SecurityProperties {
    private String saltKey;

    private int validity;
}
