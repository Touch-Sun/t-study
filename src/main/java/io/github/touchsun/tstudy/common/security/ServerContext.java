package io.github.touchsun.tstudy.common.security;

/**
 * t-study
 * Server context
 *
 * @author lee
 * @since 2024/7/26 11:16
 */
public class ServerContext {

    private static final ThreadLocal<String> currentUser = new ThreadLocal<>();

    public static void setCurrentUser(String username) {
        currentUser.set(username);
    }

    public static String getCurrentUser() {
        return currentUser.get();
    }

    public static void clear() {
        currentUser.remove();
    }
}
