package io.github.touchsun.tstudy.common.security;

import io.github.touchsun.tstudy.core.constants.StaticConstant;
import io.github.touchsun.tstudy.core.constants.StaticConstantConfigure;

/**
 * t-study
 *
 * @author lee
 * @since 2024/7/27 10:28
 */
@StaticConstantConfigure
public class SecurityConstant {

    /**
     * security key
     */
    @StaticConstant("security.private-key")
    public static String PRIVATE_KEY;

    /**
     * expire time
     */
    @StaticConstant("security.expire-time")
    public static long EXPIRE_TIME;

    /**
     * token prefix such as Bearer
     */
    @StaticConstant("security.token-prefix")
    public static String TOKEN_PREFIX;

    /**
     * default password for user
     */
    @StaticConstant("security.default-password")
    public static String DEFAULT_PASSWORD;
}
