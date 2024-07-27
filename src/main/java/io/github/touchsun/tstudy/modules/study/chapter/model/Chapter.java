package io.github.touchsun.tstudy.modules.study.chapter.model;

import io.github.touchsun.tstudy.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The task chapter info doc.
 *
 * @author touchsun
 * @since 2024/7/25 21:40
 */
@Document("study_chapter")
@Data
@EqualsAndHashCode(callSuper = true)
public class Chapter extends BaseModel {

    /**
     * name
     */
    private String name;

    /**
     * task id
     */
    private String task_id;

}
