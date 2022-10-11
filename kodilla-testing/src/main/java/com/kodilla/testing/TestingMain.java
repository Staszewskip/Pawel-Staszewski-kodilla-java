package com.kodilla.testing;
import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;
public class TestingMain {
    public static void main(String[] args) {
     SimpleUser simpleUser = new SimpleUser("theForumUser");
     String result = simpleUser.getUserName();

     if (result.equals("theForumUser")){
         System.out.println("Test OK");
     }else{
         System.out.println("Error");
     }
    Calculator calculator = new Calculator();
    double addResult = calculator.add(50,100);
    System.out.println(addResult);

    double subtractResult = calculator.subtract(200,150);
    System.out.println(subtractResult);

    }
}
