# 基于 OpenJDK 18 的官方镜像
FROM openjdk:18

# 使用 Maven 构建参数
ARG JAR_FILE

# 将 jar 文件添加到容器中
ADD ${JAR_FILE} app.jar

# 暴露容器运行时的端口
EXPOSE 8080

# 启动应用
ENTRYPOINT ["java", "-jar", "/app.jar"]
