package com.example.demo.designPatterns.abstractFactory;

import lombok.Data;
import lombok.ToString;

/**
 * @author wangkg
 * @Date 2021/7/20 14:39
 */
@Data
@ToString(callSuper = true)
public class MerchantExt extends  CustomerExt {
    /**
     * 介绍人
     */
    private int introduceName;

    /**
     * 介绍人电话
     */
    private String introduceTel;
}
