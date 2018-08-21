package com.l2d.springboot.users.repository;

import com.l2d.springboot.users.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * created by duc-d on 8/17/2018
 */
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Mono<User> findByLogin(String login);
}
