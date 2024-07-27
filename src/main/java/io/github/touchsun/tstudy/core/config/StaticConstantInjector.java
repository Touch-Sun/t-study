package io.github.touchsun.tstudy.core.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * fill @StaticConstant tag, static field value.
 * 
 * @author lee
 */
@Component
public class StaticConstantInjector implements BeanPostProcessor {
    
    private final Environment environment;

    public StaticConstantInjector(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            // field have StaticConstant fill it.
            if (field.isAnnotationPresent(StaticConstant.class)) {
                StaticConstant StaticConstant = field.getAnnotation(StaticConstant.class);
                // use env function
                String value = environment.getProperty(StaticConstant.value());
                if (value != null) {
                    ReflectionUtils.makeAccessible(field);
                    try {
                        Field modifiersField = Field.class.getDeclaredField("modifiers");
                        modifiersField.setAccessible(true);
                        // alter final field
                        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
                        // set value
                        if (field.getType() == String.class) {
                            field.set(null, value);
                        } else if (field.getType() == int.class || field.getType() == long.class) {
                            field.set(null, Long.parseLong(value));
                        } // ... other type
                    } catch (IllegalAccessException | NoSuchFieldException e) {
                        throw new RuntimeException("Failed to inject configuration property", e);
                    }
                }
            }
        }
        return bean;
    }
}
