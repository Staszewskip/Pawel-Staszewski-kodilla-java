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
       double subResult = calculator.subtract(200,150);
           if (addResult == 150 && subResult == 50) {
            System.out.println("Calculator test OK");
        } else {
            System.out.println("Calculator has error!");
        }
    }
}
