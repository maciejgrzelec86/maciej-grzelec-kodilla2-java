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
            postsCount = statistics.postCount();
            commentsCount = statistics.commentsCount();
        } else if ( statistics.postCount()==0 && commentsCount>=0) {
            System.out.println("Something wrong - comments without users");
            usersCount = statistics.userNames().size();
        } else {
            usersCount = statistics.userNames().size();
            postsCount = statistics.postCount();
            commentsCount = statistics.commentsCount();
            if (usersCount != 0){
                averagePostsPerUser = postsCount / (double) usersCount;
            } else {
                averagePostsPerUser = 0;
            }
            if (usersCount != 0) {
                averageCommentsPerUser = commentsCount / (double) usersCount;
            } else {
                averageCommentsPerUser = 0;
            }
            if (postsCount != 0) {
                averageCommentsPerPost = commentsCount / (double) postsCount;
            } else {
                commentsCount = 0;
                averageCommentsPerPost =0;
            }
        }
    }

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
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
