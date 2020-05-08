package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {
    int usersQuantity;
    int postsQuantity;
    int commentsQuantity;
    double avPostsPerUser;
    double avCommentsPerUser;
    double avCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        usersQuantity = statistics.usersNames().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();
        if(usersQuantity!=0){
            avPostsPerUser = postsQuantity/usersQuantity;
            avCommentsPerUser = commentsQuantity/usersQuantity;
        }
        if(postsQuantity!=0){avCommentsPerPost = commentsQuantity/postsQuantity;}
    }

    public void showStatistics() {
        System.out.println("Quantity of users: " + usersQuantity);
        System.out.println("quantity of posts: " + postsQuantity);
        System.out.println("Quantity of comments: " + commentsQuantity);
        System.out.println("Average quantity of posts per user: " +avPostsPerUser);
        System.out.println("Average quantity of comments per user: " + avCommentsPerUser);
        System.out.println("Average quantity of comments per post: " + avCommentsPerPost);
    }


}
