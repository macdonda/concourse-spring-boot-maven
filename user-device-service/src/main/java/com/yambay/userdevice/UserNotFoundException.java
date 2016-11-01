package com.yambay.userdevice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by steve on 4/10/2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {
}
