package com.example.demo.controller;

import com.software.boot.common.entity.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangkg
 * @Date 2021/8/25 15:46
 */
@Api(tags = "wkg专用")
@RestController
@RequestMapping(value = "/v1")
public class TestController {

    @ApiOperation(value = "获取部门成员列表", response = Response.class)
    @GetMapping(value = "/members")
    public Response<?> list() {
        ArrayList<String> strings = new ArrayList<>() {{
            this.add("sdsfsd");
            this.add("sdsfsdewewewewe");
        }};
        return Response.success(strings);
    }
}
