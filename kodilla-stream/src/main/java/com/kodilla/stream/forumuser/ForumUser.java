package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private int userId;
    private String userName;
    private char userSex;
    private LocalDate birthDate;
    private int postsQuantity;

    public ForumUser(int userId, String userName, char userSex, int yearOfBirth,
                     int monthOfBirth, int dayOfBirth, int postsQuantity) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.postsQuantity = postsQuantity;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public char getUserSex() {
        return userSex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", birthDate=" + birthDate +
                ", postsQuantity=" + postsQuantity +
                '}';
    }
}
