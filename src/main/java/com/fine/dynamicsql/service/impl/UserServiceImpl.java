package com.fine.dynamicsql.service.impl;

import com.fine.dynamicsql.domian.QUser;
import com.fine.dynamicsql.domian.User;
import com.fine.dynamicsql.repository.UserRepository;
import com.fine.dynamicsql.service.UserService;
import com.fine.dynamicsql.vo.UserSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * userserviceimpl
 *
 * @author finefine
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> searchUser(UserSearchVO user) {

//        return userRepository.findAll((root, query, criteriaBuilder) -> {
//            List<Predicate> predicateList = new ArrayList<>();
//            if (!StringUtils.isEmpty(user.getUsername())) {
//                predicateList.add(criteriaBuilder.like(root.get("username").as(String.class),user.getUsername()));
//            }
//            if (user.getAge() != null&&user.getAge()>0) {
//                predicateList.add(criteriaBuilder.equal(root.get("age").as(Integer.class),user.getAge()));
//            }
//
//            //and 表示数组中的所有条件都要满足 ，相当于sql 的 where a=1 and b =2
//            return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
//
//        });

        return userRepository.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (!StringUtils.isEmpty(user.getUsername())) {
                    predicateList.add(criteriaBuilder.like(root.get("username").as(String.class), user.getUsername()));
                }
                if (user.getAge() != null && user.getAge() > 0) {
                    predicateList.add(criteriaBuilder.equal(root.get("age").as(Integer.class), user.getAge()));
                }

                //and 表示数组中的所有条件都要满足 ，相当于sql 的 where a=1 and b =2
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        });
    }

    @Override
    public List<User> searchUserDsl(UserSearchVO user) {
        QUser qUser = QUser.user;
        return StreamSupport
                .stream(userRepository
                        .findAll(qUser.age.eq(user.getAge())
                                .and(qUser.username.like(user.getUsername())))
                        .spliterator(), false)
                .collect(Collectors.toList());
    }

}
