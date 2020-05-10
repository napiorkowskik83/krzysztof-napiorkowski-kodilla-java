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
        ArrayList<String> usersList = createUsersList(10);
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
        Assert.assertEquals(postsNo / usersList.size(), retrievedAvPostsPerUser, 0);
        Assert.assertEquals(commentsNo / usersList.size(), retrievedAvCommentsPerUser, 0);
        Assert.assertEquals(0, retrievedAvCommentsPerPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsWith1000Posts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> usersList = createUsersList(10);
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
        Assert.assertEquals(postsNo / usersList.size(), retrievedAvPostsPerUser, 0);
        Assert.assertEquals(commentsNo / usersList.size(), retrievedAvCommentsPerUser, 0);
        Assert.assertEquals(commentsNo / postsNo, retrievedAvCommentsPerPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsWith0Comments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> usersList = createUsersList(10);
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
        Assert.assertEquals(postsNo / usersList.size(), retrievedAvPostsPerUser, 0);
        Assert.assertEquals(commentsNo / usersList.size(), retrievedAvCommentsPerUser, 0);
        Assert.assertEquals(commentsNo / postsNo, retrievedAvCommentsPerPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsWithLessCommentsThanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> usersList = createUsersList(11);
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
        Assert.assertEquals(postsNo / usersList.size(), retrievedAvPostsPerUser, 0);
        Assert.assertEquals(commentsNo / usersList.size(), retrievedAvCommentsPerUser, 0);
        Assert.assertEquals(commentsNo / postsNo, retrievedAvCommentsPerPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsWithMoreCommentsThanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> usersList = createUsersList(13);
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
        Assert.assertEquals(postsNo / usersList.size(), retrievedAvPostsPerUser, 0);
        Assert.assertEquals(commentsNo / usersList.size(), retrievedAvCommentsPerUser, 0);
        Assert.assertEquals(commentsNo / postsNo, retrievedAvCommentsPerPost, 0);
    }

    @Test
    public void testCalculateAdvStatisticsWith0Users() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> usersList = createUsersList(0);
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
        ArrayList<String> usersList = createUsersList(100);
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
        Assert.assertEquals(postsNo / usersList.size(), retrievedAvPostsPerUser, 0);
        Assert.assertEquals(commentsNo / usersList.size(), retrievedAvCommentsPerUser, 0);
        Assert.assertEquals(commentsNo / postsNo, retrievedAvCommentsPerPost, 0);
    }

    private ArrayList<String> createUsersList(int usersNo) {
        ArrayList<String> usersList = new ArrayList<String>();
        for (int i = 0; i < usersNo; i++) {
            usersList.add("user" + (i + 1));
        }
        return usersList;
    }
}
