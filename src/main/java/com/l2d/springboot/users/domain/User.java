package com.l2d.springboot.users.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.l2d.springboot.common.AbstractAuditingEntity;
import com.l2d.springboot.common.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * created by duc-d on 8/17/2018
 */
@Document(collection = "user")
@Setter
@Getter
public class User extends AbstractAuditingEntity {
    @Id
    private String id;

    @NotNull
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    @Indexed(unique = true)
    private String login;

    @JsonIgnore
    @NotNull
    @Size(min = 60, max = 60)
    private String password;

    @Indexed(unique = true)
    private String customer;

    @JsonIgnore
    private Set<Authority> authorities = new HashSet<>();

    private Boolean activated = true;
}
