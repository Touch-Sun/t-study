package io.github.touchsun.tstudy.modules.study.member.model;

import io.github.touchsun.tstudy.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
* The member info doc.
*
* @author touchsun
* @since 2024/7/25 21:40
*/
@Document("study_member")
@Data
@EqualsAndHashCode(callSuper = true)
public class Member extends BaseModel {

    /**
    * member username
    */
    private String username;
    /**
    * the email
    */
    private String email;
    /**
    * password
    */
    private String password;
    /**
    * member status
    */
    private String status;

}
