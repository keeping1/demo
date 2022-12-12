package com.example.demo.more.domain.primary;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2021/12/30 19:36
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserPrimaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * 名称
     */
    String name;

    /**
     * 性别
     */
    String sex;
}
