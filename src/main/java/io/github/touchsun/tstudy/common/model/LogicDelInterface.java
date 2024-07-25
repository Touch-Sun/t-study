package io.github.touchsun.tstudy.common.model;

/**
 * LogicDelInterface Interface
 * Impl this interface will auto logic del doc.
 *
 * @author touchsun
 * @since 2024/7/25 21:57
 */
public interface LogicDelInterface {

    /**
     * set logic del field val
     *
     * @param del true or false
     */
    void setDel(Boolean del);

    /**
     * get logic del field val
     *
     * @return true or false
     */
    Boolean getDel();
}
