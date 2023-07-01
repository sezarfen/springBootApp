package com.singers.singers.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_singer")
public class UserSinger {
    // Currently only one following is possible

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "singer_id")
    private int singerId;

    public UserSinger() {
    }

    public UserSinger(String username, int singerId) {
        this.username = username;
        this.singerId = singerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    @Override
    public String toString() {
        return "UserSinger{" +
                "username='" + username + '\'' +
                ", singerId=" + singerId +
                '}';
    }
}
