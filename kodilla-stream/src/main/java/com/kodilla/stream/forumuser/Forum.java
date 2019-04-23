package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> theList = new ArrayList<>();

    public Forum() {
        theList.add(new ForumUser(1,"User1", 'M', 1986, 2, 5, 1));
        theList.add(new ForumUser(2,"User2", 'M', 1986, 2, 5, 2));
        theList.add(new ForumUser(3,"User3", 'M', 2000, 2, 5, 3));
        theList.add(new ForumUser(4,"User4", 'F', 2000, 2, 5, 4));
        theList.add(new ForumUser(5,"User5", 'F', 2000, 2, 5, 5));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(theList);
    }
}
