package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumTestSuite {

    private static int testCounter = 0;
    @Before
    public void testCounting(){
        testCounter++;
        System.out.println("Test no.: " + testCounter);
    }

    public List<String> generateTestList(int howManyUsers) {
        List<String> usersCount = new ArrayList<>();
        for (int i = 0; i < howManyUsers; i++) {
            usersCount.add("User" + i);
        }
        return usersCount;
    }

    @Test
    public void testCalculateAdvStatisticNoPosts() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersCount = generateTestList(5);
        int postsCount = 0;
        int commentsCount = 0;
        when(statisticsMock.commentsCount()).thenReturn((commentsCount));
        when(statisticsMock.postCount()).thenReturn(postsCount);
        when(statisticsMock.userNames()).thenReturn(usersCount);
        CountingStatistics countingStatistics = new CountingStatistics(statisticsMock);

        //When
        countingStatistics.calculateAdvStatistic();

        //Then
        int quantityOfUsers = countingStatistics.getUsersCount();
        int quantityOfPosts = countingStatistics.getPostsCount();
        int quantityOfComments = countingStatistics.getCommentsCount();
        Assert.assertEquals(5, quantityOfUsers);
        Assert.assertEquals(0, quantityOfPosts);
        Assert.assertEquals(0, quantityOfComments);
        Assert.assertEquals(0, countingStatistics.getAverageCommentsPerPost(), 0.1);
        Assert.assertEquals(0, countingStatistics.getAverageCommentsPerUser(), 0.1);
        Assert.assertEquals(0, countingStatistics.getAveragePostsPerUser(),0.1);
    }

    @Test
    public void testCalculateAdvStatisticThousandPosts() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersCount = generateTestList(5);
        int postsCount = 1000;
        int commentsCount = 25;
        when(statisticsMock.commentsCount()).thenReturn((commentsCount));
        when(statisticsMock.postCount()).thenReturn(postsCount);
        when(statisticsMock.userNames()).thenReturn(usersCount);
        CountingStatistics countingStatistics = new CountingStatistics(statisticsMock);

        //When
        countingStatistics.calculateAdvStatistic();

        //Then
        int quantityOfUsers = countingStatistics.getUsersCount();
        int quantityOfPosts = countingStatistics.getPostsCount();
        int quantityOfComments = countingStatistics.getCommentsCount();
        Assert.assertEquals(5, quantityOfUsers);
        Assert.assertEquals(1000, quantityOfPosts);
        Assert.assertEquals(25, quantityOfComments);
        countingStatistics.calculateAdvStatistic();
        Assert.assertEquals(25/1000,countingStatistics.getAverageCommentsPerPost(),  0.1);
        Assert.assertEquals(5.0,countingStatistics.getAverageCommentsPerUser(),  0.1);
        Assert.assertEquals(200.0,countingStatistics.getAveragePostsPerUser(), 0.1);
    }

    @Test
    public void testCalculateAdvStatisticNoComments() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersCount = generateTestList(5);
        int postsCount = 10;
        int commentsCount = 0;
        when(statisticsMock.commentsCount()).thenReturn((commentsCount));
        when(statisticsMock.postCount()).thenReturn(postsCount);
        when(statisticsMock.userNames()).thenReturn(usersCount);
        CountingStatistics countingStatistics = new CountingStatistics(statisticsMock);

        //When
        countingStatistics.calculateAdvStatistic();

        //Then
        int quantityOfUsers = countingStatistics.getUsersCount();
        int quantityOfPosts = countingStatistics.getPostsCount();
        int quantityOfComments = countingStatistics.getCommentsCount();
        Assert.assertEquals(5, quantityOfUsers);
        Assert.assertEquals(10, quantityOfPosts);
        Assert.assertEquals(0, quantityOfComments);
        Assert.assertEquals(0.0, countingStatistics.getAverageCommentsPerPost(), 0.1);
        Assert.assertEquals(0.0, countingStatistics.getAverageCommentsPerUser(), 0.1);
        Assert.assertEquals(2.0, countingStatistics.getAveragePostsPerUser(), 0.1);
    }

    @Test
    public void testCalculateAdvStatisticLessCommentsThanPosts() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersCount = generateTestList(5);
        int postsCount = 100;
        int commentsCount = 25;
        when(statisticsMock.commentsCount()).thenReturn((commentsCount));
        when(statisticsMock.postCount()).thenReturn(postsCount);
        when(statisticsMock.userNames()).thenReturn(usersCount);
        CountingStatistics countingStatistics = new CountingStatistics(statisticsMock);

        //When
        countingStatistics.calculateAdvStatistic();

        //Then
        int quantityOfUsers = countingStatistics.getUsersCount();
        int quantityOfPosts = countingStatistics.getPostsCount();
        int quantityOfComments = countingStatistics.getCommentsCount();
        Assert.assertEquals(5, quantityOfUsers);
        Assert.assertEquals(100, quantityOfPosts);
        Assert.assertEquals(25, quantityOfComments);
        Assert.assertEquals(0.25, countingStatistics.getAverageCommentsPerPost(),  0.1);
        Assert.assertEquals(5.0, countingStatistics.getAverageCommentsPerUser(),  0.1);
        Assert.assertEquals(20.0, countingStatistics.getAveragePostsPerUser(), 0.1);
    }

    @Test
    public void testCalculateAdvStatisticMoreCommentsThanPosts() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersCount = generateTestList(5);
        int postsCount = 10;
        int commentsCount = 25;
        when(statisticsMock.commentsCount()).thenReturn((commentsCount));
        when(statisticsMock.postCount()).thenReturn(postsCount);
        when(statisticsMock.userNames()).thenReturn(usersCount);
        CountingStatistics countingStatistics = new CountingStatistics(statisticsMock);

        //When
        countingStatistics.calculateAdvStatistic();

        //Then
        int quantityOfUsers = countingStatistics.getUsersCount();
        int quantityOfPosts = countingStatistics.getPostsCount();
        int quantityOfComments = countingStatistics.getCommentsCount();
        Assert.assertEquals(5, quantityOfUsers);
        Assert.assertEquals(10, quantityOfPosts);
        Assert.assertEquals(25, quantityOfComments);
        Assert.assertEquals(2.5, countingStatistics.getAverageCommentsPerPost(),  0.1);
        Assert.assertEquals(5.0, countingStatistics.getAverageCommentsPerUser(),  0.1);
        Assert.assertEquals(2.0, countingStatistics.getAveragePostsPerUser(), 0.1);
    }

    @Test
    public void testCalculateAdvStatisticNoUsers() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> usersCount = generateTestList(0);
        int postsCount = 10;
        int commentsCount = 25;
        when(statisticsMock.commentsCount()).thenReturn((commentsCount));
        when(statisticsMock.postCount()).thenReturn(postsCount);
        when(statisticsMock.userNames()).thenReturn(usersCount);
        CountingStatistics countingStatistics = new CountingStatistics(statisticsMock);

        //When
        countingStatistics.calculateAdvStatistic();

        //Then
        int quantityOfUsers = countingStatistics.getUsersCount();
        int quantityOfPosts = countingStatistics.getPostsCount();
        int quantityOfComments = countingStatistics.getCommentsCount();
        Assert.assertEquals(0, quantityOfUsers);
        Assert.assertEquals(10, quantityOfPosts);
        Assert.assertEquals(25, quantityOfComments);
        Assert.assertEquals( 0, countingStatistics.getAverageCommentsPerPost(), 0.1);
        Assert.assertEquals( 0, countingStatistics.getAverageCommentsPerUser(), 0.1);
        Assert.assertEquals( 0, countingStatistics.getAveragePostsPerUser(),0.1);
    }

    @Test
    public void testCalculateAdvStatisticHundredUsers() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersCount = generateTestList(100);
        int postsCount = 10;
        int commentsCount = 25;
        when(statisticsMock.commentsCount()).thenReturn((commentsCount));
        when(statisticsMock.postCount()).thenReturn(postsCount);
        when(statisticsMock.userNames()).thenReturn(usersCount);
        CountingStatistics countingStatistics = new CountingStatistics(statisticsMock);

        //When
        countingStatistics.calculateAdvStatistic();

        //Then
        int quantityOfUsers = countingStatistics.getUsersCount();
        int quantityOfPosts = countingStatistics.getPostsCount();
        int quantityOfComments = countingStatistics.getCommentsCount();
        Assert.assertEquals(100, quantityOfUsers);
        Assert.assertEquals(10, quantityOfPosts);
        Assert.assertEquals(25, quantityOfComments);
        Assert.assertEquals(2.5, countingStatistics.getAverageCommentsPerPost(),  0.1);
        Assert.assertEquals(0.25, countingStatistics.getAverageCommentsPerUser(),  0.1);
        Assert.assertEquals(0.1, countingStatistics.getAveragePostsPerUser(), 0.1);
    }
}
