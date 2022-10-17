package com.kodilla.testing.statistics;

import com.kodilla.testing.forum.ForumUser;
import com.kodilla.testing.forum.statistics.CalculateStatistics;
import com.kodilla.testing.forum.statistics.Statistics;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {
    @Mock
    private Statistics statisticsMock;

    private List<String> generateListOfUsers(int usersQuantity) {
        List<String> userNames = new ArrayList<>();
        for (int i = 1; i <= usersQuantity; i++) {
            ForumUser theForumUser = new ForumUser("Name " + i, "realName " + i);
            userNames.add(theForumUser.getRealName());
        }
        return userNames;
    }


    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName("gdy liczba postów = 0")
    @Test
    void testIf0Posts() {
        //        given
        CalculateStatistics calculatorOfStatistics = new CalculateStatistics();
        List<String> userList = generateListOfUsers(10);
        int postsCount = 0;
        int commentsCount = 0;
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        //    when
        calculatorOfStatistics.calculateAdvStatistics(statisticsMock);
        double size = calculatorOfStatistics.getSize();
        double quantityOfForumPosts = calculatorOfStatistics.getPostsCount();
        double quantityOfForumComments = calculatorOfStatistics.getCommentsCount();
        double avgCommsPerPost = calculatorOfStatistics.getAvgOfCommentsPerPost();
        double avgCommsPerUser = calculatorOfStatistics.getAvgOfCommentsPerUser();
        double avgPostsPerUser = calculatorOfStatistics.getAvgOfPostsPerUser();
        //    then
        Assertions.assertEquals(10, size);
        Assertions.assertEquals(0, quantityOfForumPosts);
        Assertions.assertEquals(0, quantityOfForumComments);
        Assertions.assertEquals(0.0, avgCommsPerPost);
        Assertions.assertEquals(0.0, avgCommsPerUser);
        Assertions.assertEquals(0.0, avgPostsPerUser);
    }

    @DisplayName("gdy liczba postów = 1000")
    @Test
    void testIf1000Posts() {
        //        given
        CalculateStatistics calculatorOfStatistics = new CalculateStatistics();
        List<String> userList = generateListOfUsers(250);
        int postsCount = 1000;
        int commentsCount = 100;
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        //    when
        calculatorOfStatistics.calculateAdvStatistics(statisticsMock);
        double size = calculatorOfStatistics.getSize();
        double quantityOfForumPosts = calculatorOfStatistics.getPostsCount();
        double quantityOfForumComments = calculatorOfStatistics.getCommentsCount();
        double avgCommsPerPost = calculatorOfStatistics.getAvgOfCommentsPerPost();
        double avgCommsPerUser = calculatorOfStatistics.getAvgOfCommentsPerUser();
        double avgPostsPerUser = calculatorOfStatistics.getAvgOfPostsPerUser();
        //    then
        Assertions.assertEquals(250, size);
        Assertions.assertEquals(1000, quantityOfForumPosts);
        Assertions.assertEquals(100, quantityOfForumComments);
        Assertions.assertEquals(0.1, avgCommsPerPost);
        Assertions.assertEquals(0.4, avgCommsPerUser);
        Assertions.assertEquals(4.0, avgPostsPerUser);
    }

    @DisplayName("gdy liczba komentarzy = 0")
    @Test
    void testIf0Comments() {
        //        given
        CalculateStatistics calculatorOfStatistics = new CalculateStatistics();
        List<String> userList = generateListOfUsers(250);
        int postsCount = 1000;
        int commentsCount = 0;
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        //    when
        calculatorOfStatistics.calculateAdvStatistics(statisticsMock);
        double size = calculatorOfStatistics.getSize();
        double quantityOfForumPosts = calculatorOfStatistics.getPostsCount();
        double quantityOfForumComments = calculatorOfStatistics.getCommentsCount();
        double avgCommsPerPost = calculatorOfStatistics.getAvgOfCommentsPerPost();
        double avgCommsPerUser = calculatorOfStatistics.getAvgOfCommentsPerUser();
        double avgPostsPerUser = calculatorOfStatistics.getAvgOfPostsPerUser();
        //    then
        Assertions.assertEquals(250, size);
        Assertions.assertEquals(1000, quantityOfForumPosts);
        Assertions.assertEquals(0, quantityOfForumComments);
        Assertions.assertEquals(0.0, avgCommsPerPost);
        Assertions.assertEquals(0.0, avgCommsPerUser);
        Assertions.assertEquals(4.0, avgPostsPerUser);
    }

    @DisplayName("gdy liczba komentarzy < liczba postów")
    @Test
    void testIfCommentsLessThanPosts() {
        //        given
        CalculateStatistics calculatorOfStatistics = new CalculateStatistics();
        List<String> userList = generateListOfUsers(250);
        int postsCount = 1000;
        int commentsCount = 500;
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        //    when
        calculatorOfStatistics.calculateAdvStatistics(statisticsMock);
        double size = calculatorOfStatistics.getSize();
        double quantityOfForumPosts = calculatorOfStatistics.getPostsCount();
        double quantityOfForumComments = calculatorOfStatistics.getCommentsCount();
        double avgCommsPerPost = calculatorOfStatistics.getAvgOfCommentsPerPost();
        double avgCommsPerUser = calculatorOfStatistics.getAvgOfCommentsPerUser();
        double avgPostsPerUser = calculatorOfStatistics.getAvgOfPostsPerUser();
        //    then
        Assertions.assertEquals(250, size);
        Assertions.assertEquals(1000, quantityOfForumPosts);
        Assertions.assertEquals(500, quantityOfForumComments);
        Assertions.assertEquals(0.5, avgCommsPerPost);
        Assertions.assertEquals(2.0, avgCommsPerUser);
        Assertions.assertEquals(4.0, avgPostsPerUser);
    }

    @DisplayName("gdy liczba komentarzy > liczba postów")
    @Test
    void testIfCommentsMoreThanPosts() {
        //        given
        CalculateStatistics calculatorOfStatistics = new CalculateStatistics();
        List<String> userList = generateListOfUsers(250);
        int postsCount = 1000;
        int commentsCount = 2500;
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        //    when
        calculatorOfStatistics.calculateAdvStatistics(statisticsMock);
        double size = calculatorOfStatistics.getSize();
        double quantityOfForumPosts = calculatorOfStatistics.getPostsCount();
        double quantityOfForumComments = calculatorOfStatistics.getCommentsCount();
        double avgCommsPerPost = calculatorOfStatistics.getAvgOfCommentsPerPost();
        double avgCommsPerUser = calculatorOfStatistics.getAvgOfCommentsPerUser();
        double avgPostsPerUser = calculatorOfStatistics.getAvgOfPostsPerUser();
        //    then
        Assertions.assertEquals(250, size);
        Assertions.assertEquals(1000, quantityOfForumPosts);
        Assertions.assertEquals(2500, quantityOfForumComments);
        Assertions.assertEquals(2.5, avgCommsPerPost);
        Assertions.assertEquals(10.0, avgCommsPerUser);
        Assertions.assertEquals(4.0, avgPostsPerUser);
    }

    @DisplayName("gdy liczba użytkowników = 0")
    @Test
    void testIfZeroUsers() {
        //        given
        CalculateStatistics calculatorOfStatistics = new CalculateStatistics();
        List<String> userList = generateListOfUsers(0);
        int postsCount = 0;
        int commentsCount = 0;
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        //    when
        calculatorOfStatistics.calculateAdvStatistics(statisticsMock);
        double size = calculatorOfStatistics.getSize();
        double quantityOfForumPosts = calculatorOfStatistics.getPostsCount();
        double quantityOfForumComments = calculatorOfStatistics.getCommentsCount();
        double avgCommsPerPost = calculatorOfStatistics.getAvgOfCommentsPerPost();
        double avgCommsPerUser = calculatorOfStatistics.getAvgOfCommentsPerUser();
        double avgPostsPerUser = calculatorOfStatistics.getAvgOfPostsPerUser();
        //    then
        Assertions.assertEquals(0, size);
        Assertions.assertEquals(0, quantityOfForumPosts);
        Assertions.assertEquals(0, quantityOfForumComments);
        Assertions.assertEquals(0, avgCommsPerPost);
        Assertions.assertEquals(0, avgCommsPerUser);
        Assertions.assertEquals(0, avgPostsPerUser);
    }

    @DisplayName("gdy liczba użytkowników = 100")
    @Test
    void testIf100Users() {
        //        given
        CalculateStatistics calculatorOfStatistics = new CalculateStatistics();
        List<String> userList = generateListOfUsers(100);
        int postsCount = 0;
        int commentsCount = 0;
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        //    when
        calculatorOfStatistics.calculateAdvStatistics(statisticsMock);
        double size = calculatorOfStatistics.getSize();
        double quantityOfForumPosts = calculatorOfStatistics.getPostsCount();
        double quantityOfForumComments = calculatorOfStatistics.getCommentsCount();
        double avgCommsPerPost = calculatorOfStatistics.getAvgOfCommentsPerPost();
        double avgCommsPerUser = calculatorOfStatistics.getAvgOfCommentsPerUser();
        double avgPostsPerUser = calculatorOfStatistics.getAvgOfPostsPerUser();
        //    then
        Assertions.assertEquals(100, size);
        Assertions.assertEquals(0, quantityOfForumPosts);
        Assertions.assertEquals(0, quantityOfForumComments);
        Assertions.assertEquals(0, avgCommsPerPost);
        Assertions.assertEquals(0, avgCommsPerUser);
        Assertions.assertEquals(0, avgPostsPerUser);
    }
}
