package com.yambay.userdevice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by steve on 4/10/2016.
 */
@Service
@Slf4j
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public String getExternalUserId(String userId) throws UserNotFoundException
    {
        log.info("In UserService.userRepository()..");

        User user = userRepository.findByUserId(userId);
        if (user != null)
        {
            return user.getExternalUserId();
        }
        else
        {
            return "Unknown";
            //throw new UserNotFoundException();
        }
    }

    public String getUserId(String externalUserId) throws UserNotFoundException
    {
        User user = userRepository.findByExternalUserId(externalUserId);
        if (user != null)
        {
            return user.getUserId();
        }
        else
        {
            return null;
            //throw new UserNotFoundException();
        }
    }
}
