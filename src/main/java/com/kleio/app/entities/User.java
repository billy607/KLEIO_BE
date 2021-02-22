package com.kleio.app.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "User")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    public int userId;

    @Column(name = "userName")
    public String userName;

    @Column(name = "password")
    public String password;

    @Column(name = "createDT")
    public String createDT;

    @Column(name = "updateDT")
    public String updateDT;
}
