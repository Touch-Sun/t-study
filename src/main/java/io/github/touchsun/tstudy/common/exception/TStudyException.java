package io.github.touchsun.tstudy.common.exception;

import cn.hutool.core.text.StrFormatter;

/**
 * t-study
 *
 * @author lee
 * @since 2024/7/27 22:51
 */
public class TStudyException extends RuntimeException {
    
    public TStudyException(String message, String... args) {
        super(StrFormatter.format(message, (Object) args));
    }
    
    public TStudyException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public TStudyException(Throwable cause) {
        super(cause);
    }
    
    public TStudyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
