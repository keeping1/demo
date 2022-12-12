package com.example.demo.designPatterns.abstractFactory;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangkg
 * @Date 2021/7/20 14:38
 */
@Data
@NoArgsConstructor
public abstract class CustomerExt {
    /**
     * 客户曾用名
     */
    private String formerName;

    /**
     * 客户扩展说明
     */
    private String note;
}
