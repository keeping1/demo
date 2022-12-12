package com.example.demo.designPatterns.abstractFactory;

import lombok.Data;
import lombok.ToString;

/**
 * @author wangkg
 * @Date 2021/7/20 14:40
 */
@Data
@ToString(callSuper = true)
public class AgentExt extends CustomerExt {
    /**
     * 来源
     */
    private String source;

    /**
     * 资质
     */
    private String certification;

}
