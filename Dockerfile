FROM openjdk:8-jre-slim
 
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/jk/jk.spring.playground-1.0.jar"]
 
# Add Maven dependencies
ADD target/jk.spring.playground-1.0.jar /usr/share/jk/jk.spring.playground-1.0.jar