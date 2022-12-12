package com.example.demo.more;

import com.example.demo.more.domain.primary.UserPrimaryEntity;
import com.example.demo.more.repository.primary.UserPrimaryRepository;
import com.example.demo.more.repository.second.UserSecondRepository;
import com.software.boot.common.entity.Response;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2021/12/30 19:52
 */
@RestController
public class SpringbootJapDatasourceApplicationTests {

    @Autowired
    private UserPrimaryRepository userPrimaryRepository;

    @Autowired
    private UserSecondRepository userSecondRepository;

    @Test
    public void contextTest(){
        System.out.println(userPrimaryRepository.findAll());
        System.out.println(userSecondRepository.findAll());
    }

    @RequestMapping(path = "/agent_token", method = RequestMethod.GET)
    public Response<?> getAgentToken() {
        List<UserPrimaryEntity> all = userPrimaryRepository.findAll();
        return Response.success(all);
    }

}
