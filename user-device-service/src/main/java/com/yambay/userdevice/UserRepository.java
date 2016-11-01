package com.yambay.userdevice;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by steve on 4/10/2016.
 */
public interface UserRepository extends JpaRepository <User, Long>
{
    User findByUserId(String userId);
    User findByExternalUserId(String externalUserId);
}
