package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        userList.add(new ForumUser(1, "Chris", 'M',
                1982, 12, 28, 21));
        userList.add(new ForumUser(2, "Tom", 'M',
                2005, 3, 31, 3));
        userList.add(new ForumUser(3, "Kate", 'F',
                1991, 6, 18, 33));
        userList.add(new ForumUser(4, "Julie", 'F',
                2003, 7, 15, 17));
        userList.add(new ForumUser(5, "Leo", 'M',
                1995, 5, 2, 11));
        userList.add(new ForumUser(6, "Monica", 'F',
                1980, 9, 27, 41));
        userList.add(new ForumUser(7, "Nicole", 'F',
                1997, 8, 8, 28));
        userList.add(new ForumUser(8, "Bob", 'M',
                1975, 1, 17, 0));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}
