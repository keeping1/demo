package com.example.demo.designPatterns.abstractFactory;

import lombok.Data;
import lombok.ToString;

/**
 * @author wangkg
 * @Date 2021/7/20 14:40
 */
@Data
@ToString(callSuper = true)
public class BankPartnerExt extends CustomerExt {
    /**
     * 分行个数
     */
    private int branchCount;

    /**
     * ATM个数
     */
    private int atmCount;
}
