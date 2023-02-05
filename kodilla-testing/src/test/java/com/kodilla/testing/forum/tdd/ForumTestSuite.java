package com.kodilla.testing.forum.tdd;


import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



@DisplayName("TDD: Forum Test Suite")
class ForumTestSuite {

 @Nested
 @DisplayName( "Tests for posts")
 class TestPosts {
     @Test
     void testAddPost() {
//        given
         ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
//       when
         forumUser.addPost("mrSmith", "Hello everyone, this is my first contribution here");
//       then
         assertEquals(1, forumUser.getPostsQuantity());
     }

     @Test
     void testGetPost() {
//        given
         ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
         ForumPost thePost = new ForumPost("Hello everyone, " +
                 "this is my first contribution here!", "mrSmith");
         forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());
//when
         ForumPost retrievedPost;
         retrievedPost = forumUser.getPost(0);
//then
         assertEquals(thePost, retrievedPost);
     }

     @Test
     void testRemovePost() {
         //Given
         ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
         ForumPost thePost = new ForumPost("Hello everyone, " +
                 "this is my first contribution here!", "mrSmith");
         forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

         //When
         boolean result = forumUser.removePost(thePost);

         //Then
         Assertions.assertTrue(result);
         assertEquals(0, forumUser.getPostsQuantity());
     }
 }
@Nested
@DisplayName("Tests for comments")
class TestComments {
    @Test
    void testAddComment() {
//        given
        ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrSmith");
//    when
        forumUser.addComment(thePost, "mrSmith", "Thank you for all good words!");
//    then
        assertEquals(1, forumUser.getCommentsQuantity());
    }
    @Test
    void testGetComment(){
//    given
        ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrSmith");
        ForumComment theComment = new ForumComment(thePost, "mrSmith",
                "Thank you for all good words!");
        forumUser.addComment(thePost, theComment.getAuthor(),
                theComment.getCommentBody());
//        when
        ForumComment retrievedComment = forumUser.getComment(0);
//        then
        assertEquals(theComment, retrievedComment);

    }
    @Test
    void testRemoveComment() {
        //Given
        ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrSmith");
        ForumComment theComment = new ForumComment(thePost, "mrSmith",
                "Thank you for all good words!");
        forumUser.addComment(thePost, theComment.getAuthor(),
                theComment.getCommentBody());

        //When
        boolean result = forumUser.removeComment(theComment);

        //Then
        Assertions.assertTrue(result);
        assertEquals(0, forumUser.getCommentsQuantity());
    }
}

   }