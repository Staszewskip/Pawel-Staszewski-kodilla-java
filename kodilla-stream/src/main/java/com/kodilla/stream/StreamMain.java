package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifer;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        System.out.println("7.1 text beautifier");
        PoemBeautifer poemBeautifer = new PoemBeautifer();
        poemBeautifer.beautify("barcelona", text -> text.toUpperCase());
        poemBeautifer.beautify("Barcelona", text -> "FC " + text);
        poemBeautifer.beautify("barcelona", text -> text.replace("b", "B"));
        poemBeautifer.beautify("   Barcelona    ", text -> text.trim());


        System.out.println("7.3 funkcyjny spacer po liście użytkowników forum");
        Forum forum = new Forum();
        Map<Integer, ForumUser> userMap = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> LocalDate.now().getYear() - forumUser.getBirthDate().getYear() >= 20)
                .filter(forumUser -> forumUser.getNbOfPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getId, forumUser -> forumUser));

               userMap.entrySet().stream()
                       .map(entry -> entry.getKey() + ": " + entry.getValue())
                       .forEach(System.out::println);
    }
}
