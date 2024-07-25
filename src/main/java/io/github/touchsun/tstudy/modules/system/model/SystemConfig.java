package io.github.touchsun.tstudy.modules.system.model;

import io.github.touchsun.tstudy.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The system config info doc.
 *
 * @author touchsun
 * @since 2024/7/25 21:40
 */
@Document
@Data
@EqualsAndHashCode(callSuper = true)
public class SystemConfig extends BaseModel {

    /**
     * system name
     */
    private String name;

    /**
     * system logo, this is img url.
     */
    private String logo;

    /**
     * the api version, such as '/v1' '/v2'.
     */
    private String api_version;

}

