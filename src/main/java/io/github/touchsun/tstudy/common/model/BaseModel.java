package io.github.touchsun.tstudy.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

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
    private Boolean del;

    /**
     * create time. auto fill
     */
    @CreatedDate
    private Instant create_time;

    /**
     * update time. auto fill
     */
    @LastModifiedDate
    private Instant update_time;

    @Override
    public Boolean getDel() {
        return del;
    }

    @Override
    public void setDel(Boolean del) {
        this.del = del;
    }
}

