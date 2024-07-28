package io.github.touchsun.tstudy.common.security.filter;

import io.github.touchsun.tstudy.common.security.SecurityConstant;

import java.util.Arrays;
import java.util.List;

/**
 * t-study
 *
 * @author lee
 * @since 2024/7/28 12:58
 */
public abstract class AbstractWebFilter {

    /**
     * exclude path
     */
    protected boolean exclude(String requestPath) {
        // exclude path
        List<String> excludePaths = Arrays.asList(SecurityConstant.EXCLUDE_PATHS);
        if (excludePaths.contains(requestPath)) {
            return true;
        }
        // /** exclude path process
        for (String excludePath : SecurityConstant.EXCLUDE_PATHS) {
            if (excludePath.endsWith("/**")) {
                String prefix = excludePath.substring(0, excludePath.length() - 3);
                if (requestPath.startsWith(prefix)) {
                    return true;
                }
            }
        }
        return false;
    }
}
