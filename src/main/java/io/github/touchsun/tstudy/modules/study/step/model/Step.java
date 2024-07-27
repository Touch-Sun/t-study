package io.github.touchsun.tstudy.modules.study.step.model;

import io.github.touchsun.tstudy.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
* The chapter step info, this is study core info doc.
*
* @author touchsun
* @since 2024/7/25 21:40
*/
@Document("study_step")
@Data
@EqualsAndHashCode(callSuper = true)
public class Step extends BaseModel {

    /**
    * chapter_id
    */
    private String chapter_id;
    /**
    * step name
    */
    private String name;
    /**
    * study content, maybe is a html text
    */
    private String content;

}
