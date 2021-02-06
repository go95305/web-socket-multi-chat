package com.websocket.chat.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long uid;

    private String access_token;


}
