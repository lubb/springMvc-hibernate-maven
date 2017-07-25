package com.lbb.user.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Created by bing on 2017/7/20.
 */
@Entity
@Table(name="user")
public class User implements Serializable {

    private Long id;
    private String name;
    private Date birthday;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
