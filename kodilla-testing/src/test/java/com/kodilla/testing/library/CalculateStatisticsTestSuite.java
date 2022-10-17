package com.kodilla.testing.library;

import com.kodilla.testing.forum.ForumUser;
import com.kodilla.testing.forum.statistics.CalculateStatistics;
import com.kodilla.testing.forum.statistics.Statistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class CalculateStatisticsTestSuite {
    @Mock
    private Statistics statisticsMock;
    private List<String> generateListOfUsers(int nbOfUsers){
        List<String> listOfUsers = new ArrayList<>();
        for (int n = 0; n < nbOfUsers; n++) {
            ForumUser theUser = new ForumUser("Name"+n, "RealName" +n);
            listOfUsers.add(theUser.getRealName());
        }
        return listOfUsers;
    }
    @DisplayName("gdy liczba postów = 0")
@Test
    void testCalculateStatisticsIfUsers20Posts0Comments0(){
//    given
        List<String> zeroPostsList = generateListOfUsers(20);
        int countOfPosts = 0;
        int countOfComments = 0;
        CalculateStatistics calculatorOfStatistics = new CalculateStatistics();
    when(statisticsMock.usersNames()).thenReturn(zeroPostsList);
    when(statisticsMock.postsCount()).thenReturn(countOfPosts);
    when(statisticsMock.commentsCount()).thenReturn(countOfComments);

//when
        calculatorOfStatistics.calculateAdvStatistics(statisticsMock);
        double size = calculatorOfStatistics.getSize();
        double quantityOfForumPosts = calculatorOfStatistics.getPostsCount();
        double quantityOfForumComments = calculatorOfStatistics.getCommentsCount();
        double averageCommsPerPost = calculatorOfStatistics.getAvgOfCommentsPerPost();
        double averageCommsPerUser = calculatorOfStatistics.getAvgOfCommentsPerUser();
        double averagePostsPerUser = calculatorOfStatistics.getAvgOfPostsPerUser();

    //Then
    assertEquals(20, size);
    assertEquals(0, quantityOfForumPosts);
    assertEquals(0, quantityOfForumComments);
    assertEquals(0.0, averageCommsPerPost);
    assertEquals(0.0, averageCommsPerUser);
    assertEquals(0.0, averagePostsPerUser);
    }
    @DisplayName("gdy liczba postów = 1000")
    @Test
    void testCalculateStatisticsIfUsers200Posts1000Comments250(){
//    given
        List<String> forumUserList = generateListOfUsers(200);
        int countOfPosts = 1000;
        int countOfComments = 250;
        CalculateStatistics calculatorOfStatistics = new CalculateStatistics();
        when(statisticsMock.commentsCount()).thenReturn(countOfComments);
        when(statisticsMock.postsCount()).thenReturn(countOfPosts);
        when(statisticsMock.usersNames()).thenReturn(forumUserList);
        //when
        calculatorOfStatistics.calculateAdvStatistics(statisticsMock);
        double size = calculatorOfStatistics.getSize();
        double quantityOfForumPosts = calculatorOfStatistics.getPostsCount();
        double quantityOfForumComments = calculatorOfStatistics.getCommentsCount();
        double averageCommsPerPost = calculatorOfStatistics.getAvgOfCommentsPerPost();
        double averageCommsPerUser = calculatorOfStatistics.getAvgOfCommentsPerUser();
        double averagePostsPerUser = calculatorOfStatistics.getAvgOfPostsPerUser();
        //Then
        assertEquals(200, size);
        assertEquals(1000, quantityOfForumPosts);
        assertEquals(250, quantityOfForumComments);
        assertEquals(0.25, averageCommsPerPost);
        assertEquals(1.25, averageCommsPerUser);
        assertEquals(5.0, averagePostsPerUser);
    }
    @DisplayName("gdy liczba komentarzy = 0")
    @Test
    void testCalculateStatisticsIfUsers200Posts100Comments0(){
        List<String> forumUserList = generateListOfUsers(50);
        int countOfPosts = 100;
        int countOfComments = 0;
        CalculateStatistics calculatorOfStatistics = new CalculateStatistics();
        when(statisticsMock.commentsCount()).thenReturn(countOfComments);
        when(statisticsMock.postsCount()).thenReturn(countOfPosts);
        when(statisticsMock.usersNames()).thenReturn(forumUserList);
        //when
        calculatorOfStatistics.calculateAdvStatistics(statisticsMock);
        double size = calculatorOfStatistics.getSize();
        double quantityOfForumPosts = calculatorOfStatistics.getPostsCount();
        double quantityOfForumComments = calculatorOfStatistics.getCommentsCount();
        double averageCommsPerPost = calculatorOfStatistics.getAvgOfCommentsPerPost();
        double averageCommsPerUser = calculatorOfStatistics.getAvgOfCommentsPerUser();
        double averagePostsPerUser = calculatorOfStatistics.getAvgOfPostsPerUser();

        //Then
        assertEquals(50, size);
        assertEquals(100, quantityOfForumPosts);
        assertEquals(0, quantityOfForumComments);
        assertEquals(0.0, averageCommsPerPost);
        assertEquals(0.0, averageCommsPerUser);
        assertEquals(2.0, averagePostsPerUser);
    }
    @DisplayName("gdy liczba komentarzy < liczba postów")
    @Test
    void testNbOfCommentsLowerThanNbOfPosts(){
        List<String> forumUserList = generateListOfUsers(50);
        int countOfPosts = 300;
        int countOfComments = 150;
        CalculateStatistics calculatorOfStatistics = new CalculateStatistics();
        when(statisticsMock.commentsCount()).thenReturn(countOfComments);
        when(statisticsMock.postsCount()).thenReturn(countOfPosts);
        when(statisticsMock.usersNames()).thenReturn(forumUserList);
        //when
        calculatorOfStatistics.calculateAdvStatistics(statisticsMock);
        double size = calculatorOfStatistics.getSize();
        double quantityOfForumPosts = calculatorOfStatistics.getPostsCount();
        double quantityOfForumComments = calculatorOfStatistics.getCommentsCount();
        double averageCommsPerPost = calculatorOfStatistics.getAvgOfCommentsPerPost();
        double averageCommsPerUser = calculatorOfStatistics.getAvgOfCommentsPerUser();
        double averagePostsPerUser = calculatorOfStatistics.getAvgOfPostsPerUser();

        //Then
        assertEquals(50, size);
        assertEquals(300, quantityOfForumPosts);
        assertEquals(150, quantityOfForumComments);
        assertEquals(0.5, averageCommsPerPost);
        assertEquals(3.0, averageCommsPerUser);
        assertEquals(6.0, averagePostsPerUser);
    }
    @DisplayName("gdy liczba komentarzy > liczba postów")
    @Test
    void testNbOfCommentsHigherThanNbOfPosts(){
        List<String> forumUserList = generateListOfUsers(50);
        int countOfPosts = 10;
        int countOfComments = 250;
        CalculateStatistics calculatorOfStatistics = new CalculateStatistics();
        when(statisticsMock.commentsCount()).thenReturn(countOfComments);
        when(statisticsMock.postsCount()).thenReturn(countOfPosts);
        when(statisticsMock.usersNames()).thenReturn(forumUserList);
        //when
        calculatorOfStatistics.calculateAdvStatistics(statisticsMock);
        double size = calculatorOfStatistics.getSize();
        double quantityOfForumPosts = calculatorOfStatistics.getPostsCount();
        double quantityOfForumComments = calculatorOfStatistics.getCommentsCount();
        double averageCommsPerPost = calculatorOfStatistics.getAvgOfCommentsPerPost();
        double averageCommsPerUser = calculatorOfStatistics.getAvgOfCommentsPerUser();
        double averagePostsPerUser = calculatorOfStatistics.getAvgOfPostsPerUser();

        //Then
        assertEquals(50, size);
        assertEquals(10, quantityOfForumPosts);
        assertEquals(250, quantityOfForumComments);
        assertEquals(25.0, averageCommsPerPost);
        assertEquals(5.0, averageCommsPerUser);
        assertEquals(0.2, averagePostsPerUser);
    }
    @DisplayName("gdy liczba użytkowników = 0")
    @Test
    void testListOfUsersNone(){
        List<String> forumUserList = generateListOfUsers(0);
        int countOfPosts = 0;
        int countOfComments = 0;
        CalculateStatistics calculatorOfStatistics = new CalculateStatistics();
        when(statisticsMock.commentsCount()).thenReturn(countOfComments);
        when(statisticsMock.postsCount()).thenReturn(countOfPosts);
        when(statisticsMock.usersNames()).thenReturn(forumUserList);
        //when
        calculatorOfStatistics.calculateAdvStatistics(statisticsMock);
        double size = calculatorOfStatistics.getSize();
        double quantityOfForumPosts = calculatorOfStatistics.getPostsCount();
        double quantityOfForumComments = calculatorOfStatistics.getCommentsCount();
        double averageCommsPerPost = calculatorOfStatistics.getAvgOfCommentsPerPost();
        double averageCommsPerUser = calculatorOfStatistics.getAvgOfCommentsPerUser();
        double averagePostsPerUser = calculatorOfStatistics.getAvgOfPostsPerUser();

        //Then
        assertEquals(0, size);
        assertEquals(0, quantityOfForumPosts);
        assertEquals(0, quantityOfForumComments);
        assertEquals(0.0, averageCommsPerPost);
        assertEquals(0.0, averageCommsPerUser);
        assertEquals(0.0, averagePostsPerUser);
    }
    @DisplayName("gdy liczba użytkowników = 100")
    @Test
    void testListOfUsers100(){
        List<String> forumUserList = generateListOfUsers(100);
        int countOfPosts = 10;
        int countOfComments = 0;
        CalculateStatistics calculatorOfStatistics = new CalculateStatistics();
        when(statisticsMock.commentsCount()).thenReturn(countOfComments);
        when(statisticsMock.postsCount()).thenReturn(countOfPosts);
        when(statisticsMock.usersNames()).thenReturn(forumUserList);
        //when
        calculatorOfStatistics.calculateAdvStatistics(statisticsMock);
        double size = calculatorOfStatistics.getSize();
        double quantityOfForumPosts = calculatorOfStatistics.getPostsCount();
        double quantityOfForumComments = calculatorOfStatistics.getCommentsCount();
        double averageCommsPerPost = calculatorOfStatistics.getAvgOfCommentsPerPost();
        double averageCommsPerUser = calculatorOfStatistics.getAvgOfCommentsPerUser();
        double averagePostsPerUser = calculatorOfStatistics.getAvgOfPostsPerUser();

        //Then
        assertEquals(100, size);
        assertEquals(10, quantityOfForumPosts);
        assertEquals(0, quantityOfForumComments);
        assertEquals(0.0, averageCommsPerPost);
        assertEquals(0.0, averageCommsPerUser);
        assertEquals(0.1, averagePostsPerUser);
    }
}

