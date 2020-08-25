package com.zzxx.e_register;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String realname;
    private String gender;
    private String birthday;
//    private Date birthday;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", realname='" + realname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    //    public Date getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(String birthday) {
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            this.birthday = sf.parse(birthday);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
}
