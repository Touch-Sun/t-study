package io.github.touchsun.tstudy.common.utils.code;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * field class
 * 
 * @author lee 
 * @since 2024/7/26 13:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Field {
    
    String fieldName;
    
    String fieldRemark;
}