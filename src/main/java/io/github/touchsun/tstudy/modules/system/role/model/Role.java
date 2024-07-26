package io.github.touchsun.tstudy.modules.system.role.model;

import io.github.touchsun.tstudy.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
* The role info doc.
*
* @author touchsun
* @since 2024/7/25 21:40
*/
@Document("system_role")
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseModel {

    /**
    * role name
    */
    private String name;
    /**
    * role code
    */
    private String code;

}
