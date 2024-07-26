package io.github.touchsun.tstudy.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;

import java.time.Instant;
import java.util.Date;

/**
 * BaseModel Class
 * This is base model, have common fields, such as createTime... createUserId...
 *
 * @author touchsun
 * @since 2024/7/25 21:56
 */
@Data
@NoArgsConstructor
public class BaseModel implements LogicDelInterface {

    /**
     * doc id.
     */
    @Id
    private String id;

    /**
     * logic del field
     */
    @LogicDel
    private Boolean del;

    /**
     * create time. autofill
     */
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date create_time;

    /**
     * update time. autofill
     */
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date update_time;

    /**
     * create user id. autofill
     */
    @CreatedBy
    private String create_by;

    /**
     * update user id. autofill
     */
    @LastModifiedBy
    private String update_by;

    @Override
    public Boolean getDel() {
        return del;
    }

    @Override
    public void setDel(Boolean del) {
        this.del = del;
    }
    
}

