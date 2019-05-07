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

        //When
        when(statisticsMock.commentsCount()).thenReturn((commentsCount));
        when(statisticsMock.postCount()).thenReturn(postsCount);
        when(statisticsMock.userNames()).thenReturn(usersCount);
        CountingStatistics countingStatistics = new CountingStatistics(statisticsMock);

        //Then
        countingStatistics.calculateAdvStatistic();
        Assert.assertEquals(countingStatistics.getAverageCommentsPerPost(), 0, 0.1);
        Assert.assertEquals(countingStatistics.getAverageCommentsPerUser(), 0, 0.1);
        Assert.assertEquals(countingStatistics.getAveragePostsPerUser(), 0,0.1);
    }

    @Test
    public void testCalculateAdvStatisticThousandPosts() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> usersCount = generateTestList(5);
        int postsCount = 1000;
        int commentsCount = 25;

        //When
        when(statisticsMock.commentsCount()).thenReturn((commentsCount));
        when(statisticsMock.postCount()).thenReturn(postsCount);
        when(statisticsMock.userNames()).thenReturn(usersCount);
        CountingStatistics countingStatistics = new CountingStatistics(statisticsMock);

        //Then
        countingStatistics.calculateAdvStatistic();
        Assert.assertEquals(countingStatistics.getAverageCommentsPerPost(), 25/1000, 0.1);
        Assert.assertEquals(countingStatistics.getAverageCommentsPerUser(), 5.0, 0.1);
        Assert.assertEquals(countingStatistics.getAveragePostsPerUser(), 200.0,0.1);
    }

    @Test
    public void testCalculateAdvStatisticNoComments() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> usersCount = generateTestList(5);
        int postsCount = 10;
        int commentsCount = 0;

        //When
        when(statisticsMock.commentsCount()).thenReturn((commentsCount));
        when(statisticsMock.postCount()).thenReturn(postsCount);
        when(statisticsMock.userNames()).thenReturn(usersCount);
        CountingStatistics countingStatistics = new CountingStatistics(statisticsMock);

        //Then
        countingStatistics.calculateAdvStatistic();
        Assert.assertEquals(countingStatistics.getAverageCommentsPerPost(), 0.0, 0.1);
        Assert.assertEquals(countingStatistics.getAverageCommentsPerUser(), 0.0, 0.1);
        Assert.assertEquals(countingStatistics.getAveragePostsPerUser(), 2.0,0.1);
    }

    @Test
    public void testCalculateAdvStatisticLessCommentsThanPosts() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> usersCount = generateTestList(5);
        int postsCount = 100;
        int commentsCount = 25;

        //When
        when(statisticsMock.commentsCount()).thenReturn((commentsCount));
        when(statisticsMock.postCount()).thenReturn(postsCount);
        when(statisticsMock.userNames()).thenReturn(usersCount);
        CountingStatistics countingStatistics = new CountingStatistics(statisticsMock);

        //Then
        countingStatistics.calculateAdvStatistic();
        Assert.assertEquals(countingStatistics.getAverageCommentsPerPost(), 0.25, 0.1);
        Assert.assertEquals(countingStatistics.getAverageCommentsPerUser(), 5.0, 0.1);
        Assert.assertEquals(countingStatistics.getAveragePostsPerUser(), 20.0,0.1);
    }

    @Test
    public void testCalculateAdvStatisticMoreCommentsThanPosts() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> usersCount = generateTestList(5);
        int postsCount = 10;
        int commentsCount = 25;

        //When
        when(statisticsMock.commentsCount()).thenReturn((commentsCount));
        when(statisticsMock.postCount()).thenReturn(postsCount);
        when(statisticsMock.userNames()).thenReturn(usersCount);
        CountingStatistics countingStatistics = new CountingStatistics(statisticsMock);

        //Then
        countingStatistics.calculateAdvStatistic();
        Assert.assertEquals(countingStatistics.getAverageCommentsPerPost(), 2.5, 0.1);
        Assert.assertEquals(countingStatistics.getAverageCommentsPerUser(), 5.0, 0.1);
        Assert.assertEquals(countingStatistics.getAveragePostsPerUser(), 2.0,0.1);
    }

    @Test
    public void testCalculateAdvStatisticNoUsers() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> usersCount = generateTestList(0);
        int postsCount = 10;
        int commentsCount = 25;

        //When
        when(statisticsMock.commentsCount()).thenReturn((commentsCount));
        when(statisticsMock.postCount()).thenReturn(postsCount);
        when(statisticsMock.userNames()).thenReturn(usersCount);
        CountingStatistics countingStatistics = new CountingStatistics(statisticsMock);

        //Then
        countingStatistics.calculateAdvStatistic();
        Assert.assertEquals(countingStatistics.getAverageCommentsPerPost(), 0, 0.1);
        Assert.assertEquals(countingStatistics.getAverageCommentsPerUser(), 0, 0.1);
        Assert.assertEquals(countingStatistics.getAveragePostsPerUser(), 0,0.1);
    }

    @Test
    public void testCalculateAdvStatisticHundredUsers() {

        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> usersCount = generateTestList(100);
        int postsCount = 10;
        int commentsCount = 25;

        //When
        when(statisticsMock.commentsCount()).thenReturn((commentsCount));
        when(statisticsMock.postCount()).thenReturn(postsCount);
        when(statisticsMock.userNames()).thenReturn(usersCount);
        CountingStatistics countingStatistics = new CountingStatistics(statisticsMock);

        //Then
        countingStatistics.calculateAdvStatistic();
        Assert.assertEquals(countingStatistics.getAverageCommentsPerPost(), 2.5, 0.1);
        Assert.assertEquals(countingStatistics.getAverageCommentsPerUser(), 0.25, 0.1);
        Assert.assertEquals(countingStatistics.getAveragePostsPerUser(), 0.1,0.1);
    }
}
