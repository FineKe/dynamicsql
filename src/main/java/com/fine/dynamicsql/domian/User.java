package com.fine.dynamicsql.domian;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * User 领域
 *
 * @author finefine
 */
@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {

    /**
     * id 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 年龄
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "age")
    private Integer age;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;
}
