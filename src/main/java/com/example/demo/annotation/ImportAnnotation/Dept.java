package com.example.demo.annotation.ImportAnnotation;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/2/25 9:48
 */
@Data
@ConfigurationProperties(prefix = "wkg.dept")
public class Dept {

    private String name;

    private Integer age;

}
