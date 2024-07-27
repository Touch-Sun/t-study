package io.github.touchsun.tstudy.modules.system.roleuser.model;

import io.github.touchsun.tstudy.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
* The role user relation info doc.
*
* @author touchsun
* @since 2024/7/25 21:40
*/
@Document("system_role_user")
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleUser extends BaseModel {

    /**
    * role id
    */
    private String role_id;
    /**
    * user id
    */
    private String user_id;

}
