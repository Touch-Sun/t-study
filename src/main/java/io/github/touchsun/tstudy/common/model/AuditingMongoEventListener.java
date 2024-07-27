package io.github.touchsun.tstudy.common.model;

import io.github.touchsun.tstudy.common.security.ServerContext;
import lombok.SneakyThrows;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Objects;

/**
 * autofill create_by with current user
 *
 * @author lee
 * @since 2024/7/25 21:56
 */
@Component
public class AuditingMongoEventListener extends AbstractMongoEventListener {

    @SneakyThrows
    @Override
    public void onBeforeConvert(BeforeConvertEvent event) {
        // get event source content
        Object source = event.getSource();
        // object id
        Field id = ReflectionUtils.findField(source.getClass(), FieldConstant.ID_FIELD_NAME);
        // current date
        Date date = new Date();
        if (Objects.nonNull(id) && valueIsNotEmpty(source, id)) {
            // object id is not null will exec update
            ReflectionUtils.doWithFields(source.getClass(), field -> {
                // date
                handleLastModifiedDate(source, field, date);
                // user
                handleLastModifiedBy(source, field);
            });
        } else {
            // exec add
            ReflectionUtils.doWithFields(source.getClass(), field -> {
                // date
                handleCreatedDate(source, field, date);
                // date
                handleLastModifiedDate(source, field, date);
                // user
                handleCreatedBy(source, field);
                // user
                handleLastModifiedBy(source, field);
                // logic del
                handleLogicDel(source, field);
            });
        }
    }

    /**
     * process created date
     * 
     * @param source source object
     * @param field field
     * @param time current time
     * @throws IllegalAccessException e
     */
    private void handleCreatedDate(Object source, Field field, Date time) throws IllegalAccessException {
        if (canBeFilled(field, CreatedDate.class)) {
            field.setAccessible(true);
            field.set(source, time);
        }
    }

    /**
     * process created by
     * 
     * @param source source object
     * @param field field
     * @throws IllegalAccessException e
     */
    private void handleCreatedBy(Object source, Field field) throws IllegalAccessException {
        if (canBeFilled(field, CreatedBy.class)) {
            field.setAccessible(true);
            field.set(source, ServerContext.getCurrentUser());
        }
    }

    /**
     * process last modified by
     * 
     * @param source source object
     * @param field field
     * @throws IllegalAccessException e
     */
    private void handleLastModifiedBy(Object source, Field field) throws IllegalAccessException {
        if (canBeFilled(field, LastModifiedBy.class)) {
            field.setAccessible(true);
            field.set(source, ServerContext.getCurrentUser());
        }
    }

    /**
     * process last modified date
     * 
     * @param source source object
     * @param field field
     * @param time current time
     * @throws IllegalAccessException e
     */
    private void handleLastModifiedDate(Object source, Field field, Date time) throws IllegalAccessException {
        if (canBeFilled(field, LastModifiedDate.class)) {
            field.setAccessible(true);
            field.set(source, time);
        }
    }

    /**
     * process logic del
     *
     * @param source source object
     * @param field field
     * @throws IllegalAccessException e
     */
    private void handleLogicDel(Object source, Field field) throws IllegalAccessException {
        if (canBeFilled(field, LogicDel.class)) {
            field.setAccessible(true);
            field.set(source, FieldConstant.LOGIC_DEL_DEFAULT_VALUE);
        }
    }

    /**
     * object field is null
     *
     * @param source object
     * @param field  field
     * @return not null
     * @throws IllegalAccessException e
     */
    private boolean valueIsNotEmpty(Object source, Field field) throws IllegalAccessException {
        ReflectionUtils.makeAccessible(field);
        return Objects.nonNull(field.get(source));
    }

    /**
     * field can be filled
     *
     * @param field          field
     * @param annotationType annotationType
     * @return can fill
     */
    private boolean canBeFilled(Field field, Class<? extends Annotation> annotationType) {
        return Objects.nonNull(AnnotationUtils.getAnnotation(field, annotationType));
    }
}
