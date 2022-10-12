package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;


@DisplayName("Forum Test Suite")
class ForumTestSuite {
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
@DisplayName (
        "when create SimpleUser with realName, " + "then getRealName should return real user name"
)
@Test
void testCaseRealName() {
//        given
    SimpleUser simpleUser = new SimpleUser("theForumUser", "John Smith");

//    when
    String result = simpleUser.getRealName();
    System.out.println("testing " + result);
//    then
    Assertions.assertEquals("John Smith", result);
}
    @DisplayName(
            "when created SimpleUser with name, " +
                    "then getUsername should return correct name"
    )
    @Test
    void testCaseUsername() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String expectedResult = "theForumUser";
        //When
        String result = simpleUser.getUserName();
        //Then
        Assertions.assertEquals(expectedResult, result);
    }
}