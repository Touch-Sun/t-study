package io.github.touchsun.tstudy.modules.system.log.model;

import io.github.touchsun.tstudy.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
* The log info doc.
*
* @author touchsun
* @since 2024/7/25 21:40
*/
@Document("system_log")
@Data
@EqualsAndHashCode(callSuper = true)
public class Log extends BaseModel {

    /**
    * opt system
    */
    private String system;
    /**
    * opt module
    */
    private String module;
    /**
    * request end_points
    */
    private String end_points;
    /**
    * request start time
    */
    private String start_time;
    /**
    * request end time
    */
    private String end_time;
    /**
    * cost times
    */
    private String times;
    /**
    * request ip
    */
    private String ip;

}
