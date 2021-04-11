package com.kleio.app.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.sql.Date;

@Entity
@Table(name = "User")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "country")
    private String country;

    @Column(name = "createDT")
    private Date createDT;

    @Column(name = "updateDT")
    private Date updateDT;

    @Column(name = "lastLoginTime")
    private Date lastLoginTime;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="UserAchievements", joinColumns = @JoinColumn(name="userId"),
            inverseJoinColumns = @JoinColumn(name="achievementId"))
    private List<Achievement> achievements;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="UserInterests", joinColumns = @JoinColumn(name="userId"),
            inverseJoinColumns = @JoinColumn(name="interestId"))
    private List<Interest> interests;

    @OneToMany(mappedBy = "User")
    private List<Note> notes;

    @OneToMany(mappedBy = "UserReport")
    private List<UserReport> userReports;
}
