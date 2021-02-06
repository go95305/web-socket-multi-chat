package com.websocket.chat.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Authorities implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    private String role;
}
