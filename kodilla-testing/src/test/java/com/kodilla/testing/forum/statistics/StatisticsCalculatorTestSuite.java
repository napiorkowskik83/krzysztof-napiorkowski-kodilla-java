package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsCalculatorTestSuite {

    @Test
    public void testCalculateAdvStatisticsWith0Posts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> usersList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            usersList.add("user" + (i + 1));
        }
        int postsNo = 0;
        int commentsNo = 0;
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(postsNo);
        when(statisticsMock.commentsCount()).thenReturn(commentsNo);

        StatisticsCalculator statCalc = new StatisticsCalculator();
        statCalc.calculateAdvStatistics(statisticsMock);

        //When
        double retrievedAvPostsPerUser = statCalc.avPostsPerUser;
        double retrievedAvCommentsPerUser = statCalc.avCommentsPerUser;
        double retrievedAvCommentsPerPost = statCalc.avCommentsPerPost;

        //Then
        Assert.assertEquals(0 / 10, retrievedAvPostsPerUser, 0);
        Assert.assertEquals(0 / 10, retrievedAvCommentsPerUser, 0);
        Assert.assertEquals(0, retrievedAvCommentsPerPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsWith1000Posts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> usersList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            usersList.add("user" + (i + 1));
        }
        int postsNo = 1000;
        int commentsNo = 20;
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(postsNo);
        when(statisticsMock.commentsCount()).thenReturn(commentsNo);

        StatisticsCalculator statCalc = new StatisticsCalculator();
        statCalc.calculateAdvStatistics(statisticsMock);

        //When
        double retrievedAvPostsPerUser = statCalc.avPostsPerUser;
        double retrievedAvCommentsPerUser = statCalc.avCommentsPerUser;
        double retrievedAvCommentsPerPost = statCalc.avCommentsPerPost;

        //Then
        Assert.assertEquals(1000 / 10, retrievedAvPostsPerUser, 0);
        Assert.assertEquals(20 / 10, retrievedAvCommentsPerUser, 0);
        Assert.assertEquals(20 / 1000, retrievedAvCommentsPerPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsWith0Comments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> usersList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            usersList.add("user" + (i + 1));
        }
        int postsNo = 35;
        int commentsNo = 0;
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(postsNo);
        when(statisticsMock.commentsCount()).thenReturn(commentsNo);

        StatisticsCalculator statCalc = new StatisticsCalculator();
        statCalc.calculateAdvStatistics(statisticsMock);

        //When
        double retrievedAvPostsPerUser = statCalc.avPostsPerUser;
        double retrievedAvCommentsPerUser = statCalc.avCommentsPerUser;
        double retrievedAvCommentsPerPost = statCalc.avCommentsPerPost;

        //Then
        Assert.assertEquals(35 / 10, retrievedAvPostsPerUser, 0);
        Assert.assertEquals(0 / 10, retrievedAvCommentsPerUser, 0);
        Assert.assertEquals(0 / 35, retrievedAvCommentsPerPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsWithLessCommentsThanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> usersList = new ArrayList<String>();
        for (int i = 0; i < 11; i++) {
            usersList.add("user" + (i + 1));
        }
        int postsNo = 35;
        int commentsNo = 23;
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(postsNo);
        when(statisticsMock.commentsCount()).thenReturn(commentsNo);

        StatisticsCalculator statCalc = new StatisticsCalculator();
        statCalc.calculateAdvStatistics(statisticsMock);

        //When
        double retrievedAvPostsPerUser = statCalc.avPostsPerUser;
        double retrievedAvCommentsPerUser = statCalc.avCommentsPerUser;
        double retrievedAvCommentsPerPost = statCalc.avCommentsPerPost;

        //Then
        Assert.assertEquals(35 / 11, retrievedAvPostsPerUser, 0);
        Assert.assertEquals(23 / 11, retrievedAvCommentsPerUser, 0);
        Assert.assertEquals(23 / 35, retrievedAvCommentsPerPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsWithMoreCommentsThanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> usersList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            usersList.add("user" + (i + 1));
        }
        int postsNo = 35;
        int commentsNo = 47;
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(postsNo);
        when(statisticsMock.commentsCount()).thenReturn(commentsNo);

        StatisticsCalculator statCalc = new StatisticsCalculator();
        statCalc.calculateAdvStatistics(statisticsMock);

        //When
        double retrievedAvPostsPerUser = statCalc.avPostsPerUser;
        double retrievedAvCommentsPerUser = statCalc.avCommentsPerUser;
        double retrievedAvCommentsPerPost = statCalc.avCommentsPerPost;

        //Then
        Assert.assertEquals(35 / 10, retrievedAvPostsPerUser, 0);
        Assert.assertEquals(47 / 10, retrievedAvCommentsPerUser, 0);
        Assert.assertEquals(47 / 35, retrievedAvCommentsPerPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsWith0Users() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> usersList = new ArrayList<String>();
        int postsNo = 0;
        int commentsNo = 0;
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(postsNo);
        when(statisticsMock.commentsCount()).thenReturn(commentsNo);

        StatisticsCalculator statCalc = new StatisticsCalculator();
        statCalc.calculateAdvStatistics(statisticsMock);

        //When
        double retrievedAvPostsPerUser = statCalc.avPostsPerUser;
        double retrievedAvCommentsPerUser = statCalc.avCommentsPerUser;
        double retrievedAvCommentsPerPost = statCalc.avCommentsPerPost;

        //Then
        Assert.assertEquals(0, retrievedAvPostsPerUser, 0);
        Assert.assertEquals(0, retrievedAvCommentsPerUser, 0);
        Assert.assertEquals(0, retrievedAvCommentsPerPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsWith100Users() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> usersList = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            usersList.add("user" + (i + 1));
        }
        int postsNo = 35;
        int commentsNo = 67;
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(postsNo);
        when(statisticsMock.commentsCount()).thenReturn(commentsNo);

        StatisticsCalculator statCalc = new StatisticsCalculator();
        statCalc.calculateAdvStatistics(statisticsMock);

        //When
        double retrievedAvPostsPerUser = statCalc.avPostsPerUser;
        double retrievedAvCommentsPerUser = statCalc.avCommentsPerUser;
        double retrievedAvCommentsPerPost = statCalc.avCommentsPerPost;

        //Then
        Assert.assertEquals(35 / 100, retrievedAvPostsPerUser, 0);
        Assert.assertEquals(67 / 100, retrievedAvCommentsPerUser, 0);
        Assert.assertEquals(67 / 35, retrievedAvCommentsPerPost, 0);
    }
}
