package com.fine.dynamicsql.repository;

import com.fine.dynamicsql.domian.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * user repository
 *
 * @author finefine
 */
public interface UserRepository extends JpaRepository<User,Long>
        , JpaSpecificationExecutor<User>
        , QuerydslPredicateExecutor<User> {

}
