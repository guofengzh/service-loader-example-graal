# service-loader-example
Service Loader Example in Java

# steps to Run

```
C:\projects\AVICI\Node-locked-license\service-loader-example-master\service-example>target\service-example.exe
Exception in thread "main" java.lang.IllegalArgumentException: Cannot instantiate interface org.springframework.context.ApplicationContextInitializer : org.springframework.graalvm.utils.LiteConfigurationInitializer
        at org.springframework.boot.SpringApplication.createSpringFactoriesInstances(SpringApplication.java:467)
        at org.springframework.boot.SpringApplication.getSpringFactoriesInstances(SpringApplication.java:449)
        at org.springframework.boot.SpringApplication.getSpringFactoriesInstances(SpringApplication.java:442)
        at org.springframework.boot.SpringApplication.<init>(SpringApplication.java:284)
        at org.springframework.boot.SpringApplication.<init>(SpringApplication.java:264)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1309)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1298)
        at sukumaar.SpringBootLoaderApplication.main(SpringBootLoaderApplication.java:11)
Caused by: java.lang.ClassNotFoundException: org.springframework.graalvm.utils.LiteConfigurationInitializer
        at com.oracle.svm.core.hub.ClassForNameSupport.forName(ClassForNameSupport.java:60)
        at java.lang.Class.forName(DynamicHub.java:1292)
        at org.springframework.util.ClassUtils.forName(ClassUtils.java:284)
        at org.springframework.boot.SpringApplication.createSpringFactoriesInstances(SpringApplication.java:460)
        ... 7 more
```