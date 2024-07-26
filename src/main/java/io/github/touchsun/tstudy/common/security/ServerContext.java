package io.github.touchsun.tstudy.common.security;

import org.springframework.stereotype.Service;

/**
 * t-study
 * Server context
 *
 * @author lee
 * @since 2024/7/26 11:16
 */
@Service
public class ServerContext {

    /**
     * get current user id
     */
    public String getCurrentUserId() {
        return "admin";
    }
}
