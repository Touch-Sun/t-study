package io.github.touchsun.tstudy.common.security;

import io.github.touchsun.tstudy.modules.system.user.model.User;

/**
 * t-study
 * Server context
 *
 * @author lee
 * @since 2024/7/26 11:16
 */
public class ServerContext {

    private static final ThreadLocal<String> currentUser = new ThreadLocal<>();
    
    private static final ThreadLocal<User> currentUserInfo = new ThreadLocal<>();

    public static void setCurrentUser(String username) {
        currentUser.set(username);
    }

    public static String getCurrentUser() {
        return currentUser.get();
    }
    
    public static void setCurrentUserInfo(User userInfo) {
        currentUserInfo.set(userInfo);
    }
    
    public static User getCurrentUserInfo() {
        return currentUserInfo.get();
    }

    public static void clear() {
        currentUser.remove();
        currentUserInfo.remove();
    }
}
