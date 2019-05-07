package com.kodilla.testing.forum.statistics;

public class CountingStatistics {

    Statistics statistics;
    int usersCount;
    int postsCount;
    int commentsCount;
    double averagePostsPerUser;
    double averageCommentsPerUser;
    double averageCommentsPerPost;

    public CountingStatistics (Statistics statistics) {
        this.statistics = statistics;
    }
    public void calculateAdvStatistic() {
        if (statistics.userNames().size()==0) {
            System.out.println("No users, no statistics");
        } else if ( statistics.postCount()==0 && commentsCount>=0) {
            System.out.println("Something wrong - comments without users");
        } else {
            usersCount = statistics.userNames().size();
            postsCount = statistics.postCount();
            commentsCount = statistics.commentsCount();
            averagePostsPerUser = postsCount / (double) usersCount;
            averageCommentsPerUser = commentsCount / (double) usersCount;
            averageCommentsPerPost = commentsCount / (double) postsCount;
        }
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }
}
