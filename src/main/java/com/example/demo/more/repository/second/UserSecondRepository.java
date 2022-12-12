package com.example.demo.more.repository.second;

import com.example.demo.more.domain.second.UserSecondEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2021/12/30 19:38
 */
@Repository
public interface UserSecondRepository  extends JpaRepository<UserSecondEntity, Long> {
}
