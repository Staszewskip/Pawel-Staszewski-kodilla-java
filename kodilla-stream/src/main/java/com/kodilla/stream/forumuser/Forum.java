package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {
    List<ForumUser> forumUsers = new ArrayList<>();
    public Forum() {
        forumUsers.add(new ForumUser(11,"Paweł",'M',1990,02,20,40));
        forumUsers.add(new ForumUser(12,"Michał",'M',2000,05,21,0));
        forumUsers.add(new ForumUser(120,"Monika",'F',2003,03,25, 7));
        forumUsers.add(new ForumUser(111,"Kasia",'F',1999,10,20,5));
        forumUsers.add(new ForumUser(503,"Krzysztof",'M',2004,02,20,100));
    }

    public  List<ForumUser> getUserList() {
        return new ArrayList<>(forumUsers);
    }

}
