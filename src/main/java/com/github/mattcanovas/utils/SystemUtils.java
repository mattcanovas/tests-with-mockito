package com.github.mattcanovas.utils;

public class SystemUtils {
    
    public static String getWelcomeMessage(String username, Boolean isCustomer) {
        if (isCustomer) {
            return "Dear " + username;
        }
        return "Hello " + username;
    }

}
