package io.github.touchsun.tstudy.modules.system.user.model;

import io.github.touchsun.tstudy.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
* The user info doc.
*
* @author touchsun
* @since 2024/7/25 21:40
*/
@Document("system_user")
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseModel {

    /**
    * the username
    */
    private String username;
    /**
    * the password
    */
    private String password;
    /**
    * the status for user
    */
    private String status;

}
