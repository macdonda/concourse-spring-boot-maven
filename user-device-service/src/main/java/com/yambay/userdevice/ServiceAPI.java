package com.yambay.userdevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by steve on 4/10/2016.
 */
@RestController
public class ServiceAPI
{
    @Autowired
    private UserService userService;

    @RequestMapping("/user/{userId}/getExternalUserIdFromUserId")
    @ResponseBody

    public String getExternalUserId(@PathVariable String userId) throws UserNotFoundException
    {
        return userService.getExternalUserId(userId);
    }

    @RequestMapping("/user/{externalUserId}/getUserIdFromExternalUserId")

    @ResponseBody
    public String getUserId(@PathVariable String externalUserId) throws UserNotFoundException
    {
        return userService.getUserId(externalUserId);
    }
}
