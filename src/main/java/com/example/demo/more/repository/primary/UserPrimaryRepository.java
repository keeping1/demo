package com.example.demo.more.repository.primary;

import com.example.demo.more.domain.primary.UserPrimaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2021/12/30 19:37
 */
@Repository
public interface UserPrimaryRepository extends JpaRepository<UserPrimaryEntity, Long> {
}
