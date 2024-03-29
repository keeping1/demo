package com.example.demo.designPatterns.abstractFactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangkg
 * @Date 2021/7/20 14:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Customer {
    /**
     * 客户名称
     */
    private String name;

    /**
     * 客户类型
     */
    private String type;

}
