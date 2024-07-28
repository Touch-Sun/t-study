    package io.github.touchsun.tstudy.core.constants;
    
    import io.github.touchsun.tstudy.TStudyApplication;
    import jakarta.annotation.PostConstruct;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.beans.BeansException;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.core.env.Environment;
    import org.springframework.core.type.filter.AnnotationTypeFilter;
    import org.springframework.util.ClassUtils;
    import org.springframework.util.ReflectionUtils;
    
    import java.lang.reflect.Field;
    import java.util.Arrays;
    
    /**
     * fill @StaticConstant tag, static field value.
     * 
     * @author lee
     */
    @Configuration
    @Slf4j
    public class StaticConstantProcess {
        
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
                    ReflectionUtils.makeAccessible(field);
                    try {
                        // Set value
                        switch (field.getType().getName()) {
                            case "java.lang.String" ->
                                    field.set(null, environment.getProperty(staticConstant.value(), String.class));
                            case "int", "java.lang.Integer" -> 
                                    field.set(null, environment.getProperty(staticConstant.value(), Integer.class));
                            case "long", "java.lang.Long" ->
                                    field.set(null, environment.getProperty(staticConstant.value(), Long.class));
                            case "boolean", "java.lang.Boolean" ->
                                    field.set(null, environment.getProperty(staticConstant.value(), Boolean.class));
                            case "java.util.List" -> {
                                if (field.getGenericType().toString().equals("java.util.List<java.lang.String>")) {
                                    String property = environment.getProperty(staticConstant.value(), String.class);
                                    if (property != null) {
                                        field.set(null, Arrays.asList(property.split(",")));
                                    }
                                } else {
                                    throw new RuntimeException("Unsupported List type: " + field.getGenericType().toString());
                                }
                            }
                            case "[Ljava.lang.String;" -> {
                                String property = environment.getProperty(staticConstant.value(), String.class);
                                if (property != null) {
                                    field.set(null, property.split(","));
                                }
                            }
                            default ->
                                    throw new RuntimeException("Unsupported field type: " + field.getType().getName());
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Failed to inject configuration property", e);
                    }
                }
            }
        }
    
        @PostConstruct
        public void init() {
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
