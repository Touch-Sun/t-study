package io.github.touchsun.tstudy.core.constants;

import io.github.touchsun.tstudy.TStudyApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.env.Environment;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * fill @StaticConstant tag, static field value.
 * 
 * @author lee
 */
@Component
@Slf4j
public class StaticConstantProcess implements ApplicationListener<ApplicationReadyEvent> {
    
    @Autowired
    private Environment environment;
    
/**
     * process static field value.
     * 
     * @param staticClass static class
     * @throws BeansException beans exception
     */
    public void processStaticFieldVal(Class<?> staticClass) throws BeansException {
        log.info("process static val fill. class: {}", staticClass.getName());
        Field[] fields = staticClass.getDeclaredFields();
        for (Field field : fields) {
            // field have StaticConstant fill it.
            if (field.isAnnotationPresent(StaticConstant.class)) {
                StaticConstant staticConstant = field.getAnnotation(StaticConstant.class);
                // use env function
                String value = environment.getProperty(staticConstant.value());
                if (value != null) {
                    ReflectionUtils.makeAccessible(field);
                    try {
                        // set value
                        switch (field.getType().getName()) {
                            case "string", "java.lang.String" -> field.set(null, value);
                            case "int", "java.lang.Integer" -> field.set(null, Integer.parseInt(value));
                            case "long", "java.lang.Long" -> field.set(null, Long.parseLong(value));
                            case "boolean", "java.lang.Boolean" -> field.set(null, Boolean.parseBoolean(value));
                            default ->
                                    throw new RuntimeException("Unsupported field type: " + field.getType().getName());
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Failed to inject configuration property", e);
                    }
                }
            }
        }
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // get base package
        String basePackage = ClassUtils.getPackageName(TStudyApplication.class);
        // scan class
        ClassPathScanningCandidateComponentProvider scanningCandidateComponentProvider = 
                new ClassPathScanningCandidateComponentProvider(false);
        // scan annotation config
        scanningCandidateComponentProvider.addIncludeFilter(
                new AnnotationTypeFilter(StaticConstantConfigure.class)
        );
        // loop class for @StaticConstantConfigure annotation
        scanningCandidateComponentProvider.findCandidateComponents(basePackage).forEach(clazzDef -> {
            // process static field fill val.
            try {
                processStaticFieldVal(Class.forName(clazzDef.getBeanClassName()));
            } catch (Exception e) {
                log.warn("process static val error: {}", e.getMessage(), e);
            }
        });
    }
}
