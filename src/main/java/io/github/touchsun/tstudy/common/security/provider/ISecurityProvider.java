package io.github.touchsun.tstudy.common.security.provider;

/**
 * t-study
 *
 * @author lee
 * @since 2024/7/27 10:39
 */
public interface ISecurityProvider {
    
    String createToken(String userId);
    
    boolean checkToken(String token);
}
