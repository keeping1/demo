package com.example.demo.more.domain.second;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2021/12/30 19:37
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "aft_clue")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSecondEntity {

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
