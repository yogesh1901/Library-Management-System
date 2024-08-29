package com.dh.lms.util;

import com.dh.lms.model.User;

public class LoginUtil {
    private static User loggedInUser;

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        LoginUtil.loggedInUser = loggedInUser;
    }
    

}
