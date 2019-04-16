package com.kodilla.testing.forum;

import java.util.ArrayList;
import java.util.LinkedList;

public class ForumUser {
    private String name;
    private String realName;
    private ArrayList<ForumPost> posts = new ArrayList<>();
    private LinkedList<ForumComment> comments = new LinkedList<>();

    public ForumUser(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }

    public void addPost(String author, String postBody){

    }

    public void addComment(ForumPost forumPost, String commentBody, String author){

    }

    public int getPostsQuantity() {
        return 100;
    }

    public int getCommentsQuantity() {
        return 100;
    }

    public ForumPost getPost() {
        return null;
    }

    public ForumComment getComment() {
        return null;
    }

    public boolean removePost(ForumPost thePost) {
        return true;
    }

    public boolean removeComment(ForumComment theComment) {
        return true;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }
}
