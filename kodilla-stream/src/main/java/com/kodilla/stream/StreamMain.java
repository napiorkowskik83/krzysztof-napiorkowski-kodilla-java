package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum theForum = new Forum();
        Map<Integer, ForumUser> theResultStringOfForumUsers = theForum.getUserList().stream()
                .filter(forumUser -> forumUser.getUserSex() == 'M')
                .filter(forumUser -> forumUser.getBirthDate().getYear() <= 2000)
                .filter(forumUser -> forumUser.getPostsQuantity() > 0)
                .collect(Collectors.toMap(ForumUser::getUserId, Function.identity()));

        theResultStringOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
