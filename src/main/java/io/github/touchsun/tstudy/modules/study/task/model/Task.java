package io.github.touchsun.tstudy.modules.study.task.model;

import io.github.touchsun.tstudy.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
* The task info doc.
*
* @author touchsun
* @since 2024/7/25 21:40
*/
@Document("study_task")
@Data
@EqualsAndHashCode(callSuper = true)
public class Task extends BaseModel {

    /**
    * task name
    */
    private String name;
    /**
    * task remark
    */
    private String remark;
    /**
    * task icon
    */
    private String icon;
    /**
    * task group id
    */
    private String group_id;

}
