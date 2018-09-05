package com.zeng.param;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


/**
 * Created by Guan on 9/4/2018.
 */


public class UserParam {
    private String id;
    @NotEmpty(message = "Name can't be empty")
    private String userName;
    @NotEmpty(message = "Password can't be empty")
    @Length(min = 6, message = "Password can't be less than 6 digits")
    private String password;
    @Email
    private String email;
    @Max(value = 100, message = "Age can't be greater than 100.")
    @Min(value = 18, message = "Age can't be less than 18.")
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
