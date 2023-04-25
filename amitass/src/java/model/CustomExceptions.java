/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tengz
 */
public class CustomExceptions extends Exception {
    public CustomExceptions(String message){
        super(message);
    }
    
    public CustomExceptions(String message, Throwable cause){
        super(message, cause);
    }
    
    public static class InvalidCredentials extends CustomExceptions {
        public InvalidCredentials(){
            super("Invalid Credentials!!");
        }
        
        public InvalidCredentials(Throwable cause) {
            super("Invalid credentials!", cause);
        }
    }

    public static class ExampleTest extends CustomExceptions {
        public ExampleTest(){
            super("Example Test");
        }
    }
}
