package com.kodilla.testing.statistics;

import com.kodilla.testing.forum.ForumUser;
import com.kodilla.testing.forum.statistics.CalculateStatistics;
import com.kodilla.testing.forum.statistics.Statistics;
import org.junit.jupiter.api.*;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {
    private List<String> generateListOfUsers(int n) {
        List<String> userNames = new ArrayList<>();
        for (int i = 1; i < n; i++){
            ForumUser theForumUser = new ForumUser("Name " + n, "realName " + n);
            userNames.add(theForumUser.getName());
        }
        return userNames;
    }

    @Mock
    private Statistics statisticsMock;
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
//    given
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
//    given
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
        Assertions.assertEquals(10, quantityOfForumComments);
        Assertions.assertEquals(0.01, avgCommsPerPost);
        Assertions.assertEquals(2.5, avgCommsPerUser);
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
//    given
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
//    given
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
//    given
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
//    given
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
//    given
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
