package io.github.touchsun.tstudy.common.utils.code;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * t-study
 *
 * @author lee
 * @since 2024/7/26 13:43
 */
public class CodeGenUtil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the base directory (e.g., src/main/java/io/github/touchsun/tstudy/modules):");
        String baseDir = scanner.nextLine();
        if (StringUtils.isBlank(baseDir)) {
            baseDir = "src/main/java/io/github/touchsun/tstudy/modules";
        }

        System.out.println("Enter the module name:");
        String module = scanner.nextLine();

        System.out.println("Enter the function name:");
        String function = scanner.nextLine();

        System.out.println("Enter the bean name:");
        String beanName = scanner.nextLine();

        System.out.println("Enter the document remark:");
        String remark = scanner.nextLine();

        List<Field> fields = new ArrayList<>();
        while (true) {
            System.out.println("Enter field name (type 'done' to finish):");
            String fieldName = scanner.nextLine();
            if("done".equalsIgnoreCase(fieldName)) break;

            System.out.println("Enter field remark:");
            String fieldRemark = scanner.nextLine();

            fields.add(new Field(fieldName, fieldRemark));
        }

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();

        createFiles(velocityEngine, baseDir, module, function, beanName, remark, fields);
    }

    private static void createFiles(VelocityEngine velocityEngine, String baseDir, String module, String function, String beanName, String remark, List<Field> fields) {
        String basePath = baseDir + "/" + module + "/" + function;
        String[] subPaths = {"model", "repository", "service", "controller"};

        for (String path : subPaths) {
            try {
                Files.createDirectories(Paths.get(basePath + "/" + path));
            } catch (IOException e) {
                System.out.println("Failed to create directory: " + basePath + "/" + path);
                e.printStackTrace();
                return;
            }
        }

        VelocityContext context = new VelocityContext();
        context.put("module", module);
        context.put("function", function);
        context.put("beanName", beanName);
        context.put("remark", remark);
        context.put("fields", fields);

        String[] templateFiles = {"Model.vm", "Repository.vm", "Service.vm", "Controller.vm"};
        String[] classNames = {beanName, beanName + "Repository", beanName + "Service", beanName + "Controller"};

        for (int i = 0; i < subPaths.length; i++) {
            try {
                Template template = velocityEngine.getTemplate("template/code/" + templateFiles[i]);
                StringWriter writer = new StringWriter();
                template.merge(context, writer);

                File file = new File(basePath + "/" + subPaths[i] + "/" + classNames[i] + ".java");
                try (FileWriter fileWriter = new FileWriter(file)) {
                    fileWriter.write(writer.toString());
                    System.out.println("File generated: " + file.getPath());
                }
            } catch (IOException e) {
                System.out.println("Error writing file for: " + classNames[i]);
                e.printStackTrace();
            }
        }
    }
}
