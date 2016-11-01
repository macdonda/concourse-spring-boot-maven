package com.yambay.userdevice;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by steve on 4/10/2016.
 */
@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long Id;

    private String userId;

    private String displayName;

    private String externalUserId;
}
