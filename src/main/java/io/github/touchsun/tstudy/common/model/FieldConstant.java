package io.github.touchsun.tstudy.common.model;

import io.github.touchsun.tstudy.core.constants.StaticConstant;
import io.github.touchsun.tstudy.core.constants.StaticConstantConfigure;

/**
 * t-study
 * field constant
 *
 * @author lee
 * @since 2024/7/26 11:03
 */
@StaticConstantConfigure
public class FieldConstant {

    /**
     * id
     */
    @StaticConstant("mongodb.id-field-name")
    public static String ID_FIELD_NAME;

    /**
     * logic del default value 'false'
     */
    @StaticConstant("mongodb.logic-del-default-val")
    public static Boolean LOGIC_DEL_DEFAULT_VALUE;
}
