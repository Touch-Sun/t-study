package io.github.touchsun.tstudy.modules.system.menu.model;

import io.github.touchsun.tstudy.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The menu menu info doc.
 *
 * @author touchsun
 * @since 2024/7/25 21:40
 */
@Document("system_menu")
@Data
@EqualsAndHashCode(callSuper = true)
public class SystemMenu extends BaseModel {

    /**
     * menu name
     */
    private String name;

    /**
     * menu logo, this is img url.
     */
    private String logo;

    /**
     * menu type 1 - group / 2 - menu
     */
    private String type;
    
    /**
     * menu path
     */
    private String path;
    
    /**
     * menu parent id
     */
    private String parent_id;

}

