package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int id;
    private final String userName;
    private final char sex;
    private final LocalDate birthDate;
    private final int nbOfPosts;

    public ForumUser(int id, String userName, char sex, int year, int month, int dayOfMonth, int nbOfPosts) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.birthDate = LocalDate.of(year, month, dayOfMonth);
        this.nbOfPosts = nbOfPosts;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getNbOfPosts() {
        return nbOfPosts;
    }


}
