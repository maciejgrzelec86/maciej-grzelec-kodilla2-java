package com.kodilla.stream.forumuser;

import java.time.*;
import java.util.*;
import java.io.*;


public final class ForumUser {
    private final int userId;
    private final String userName;
    private final char sex;
    /*private final enum sex {
    'M', 'F';
    }*/
    private final LocalDate dateOfBirth;
    private final int quantityOfPosts;

    public ForumUser(int userId, String userName, char sex, int yearOfBirth,
                     int monthOfBirth, int dayOfBirth, int quantityOfPosts) {
        this.userId = userId;
        this.userName = userName;
        this.sex = sex;
        this.dateOfBirth = LocalDate.of(yearOfBirth,monthOfBirth,dayOfBirth);
        this.quantityOfPosts = quantityOfPosts;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getQuantityOfPosts() {
        return quantityOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", quantityOfPosts=" + quantityOfPosts +
                '}';
    }


}


