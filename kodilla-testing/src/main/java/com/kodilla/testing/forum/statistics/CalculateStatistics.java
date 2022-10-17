package com.kodilla.testing.forum.statistics;

import java.util.List;

public class CalculateStatistics {
    private double avgOfCommentsPerPost;
    private double avgOfPostsPerUser;
    private double avgOfCommentsPerUser;
    private double size;
    private double postsCount;
    private double commentsCount;

    public double getAvgOfCommentsPerPost() {
        return avgOfCommentsPerPost;
    }

    public double getAvgOfPostsPerUser() {
        return avgOfPostsPerUser;
    }

    public double getAvgOfCommentsPerUser() {
        return avgOfCommentsPerUser;
    }

    public double getSize() {
        return size;
    }

    public double getPostsCount() {
        return postsCount;
    }

    public double getCommentsCount() {
        return commentsCount;
    }



  public void calculateAdvStatistics(Statistics statistics) {
List<String> userNames = statistics.usersNames();
size = userNames.size();
postsCount = statistics.postsCount();
commentsCount = statistics.commentsCount();
      if (size == 0) {
          avgOfCommentsPerPost = 0.0;
          avgOfPostsPerUser = 0.0;
          avgOfCommentsPerUser = 0.0;
      } else if (size > 0 && postsCount == 0) {
          avgOfCommentsPerUser = 0.0;
          avgOfPostsPerUser = 0.0;
          avgOfCommentsPerPost = 0.0;
      }  else if (size > 0 && postsCount > 0) {
          avgOfCommentsPerUser = commentsCount / size;
          avgOfPostsPerUser = postsCount / size;
          avgOfCommentsPerPost = commentsCount / postsCount;
      }
  }
    public void showStatistics() {
        System.out.println("Nb of users " + size);
        System.out.println("Nb of users " + size);
        System.out.println("Nb of posts " + postsCount);
        System.out.println("Average of posts per user " + avgOfPostsPerUser);
        System.out.println("Average of comments per user " + avgOfCommentsPerUser);
        System.out.println("Average of comments per posts " + avgOfCommentsPerPost);
}
}
