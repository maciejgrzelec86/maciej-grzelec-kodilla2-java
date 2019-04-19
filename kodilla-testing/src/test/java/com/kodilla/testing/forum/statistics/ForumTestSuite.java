package com.kodilla.testing.forum.statistics;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumTestSuite {

    private static int testCounter = 0;
    @Before
    public void testCounting(){
        testCounter++;
        System.out.println("Test no.: " + testCounter);
    }

    @Test
    public void testCalculateAdvStatistic() {
        Statistics statisticsMock = mock(Statistics.class);

        CountingStatistics countingStatistics = new CountingStatistics();
        //when(countingStatistics.calculateAdvStatistic(Statistics)).then;
        countingStatistics.calculateAdvStatistic(statisticsMock);

    }


}
