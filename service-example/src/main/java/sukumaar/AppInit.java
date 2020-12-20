package sukumaar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.spi.URLStreamHandlerProvider;
import java.util.ServiceLoader;

@Component
public class AppInit implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("-AppInit-");

        // runs using java -jar target\service-example-1.0-SNAPSHOT.jar, output:
        //    org.springframework.boot.loader.LaunchedURLClassLoader
        //    jdk.internal.loader.ClassLoaders.AppClassLoader
        // runs using mvn spring-boot:run, output:
        //    jdk.internal.loader.ClassLoaders.AppClassLoader
        //    jdk.internal.loader.ClassLoaders.PlatformClassLoader
        // runs in Intellij, output:
        //    jdk.internal.loader.ClassLoaders.AppClassLoader
        //    jdk.internal.loader.ClassLoaders.PlatformClassLoader
        // conclusion: LaunchedURLClassLoader does not search META-INF/servics correctly

        System.out.println(Thread.currentThread().getContextClassLoader().getClass().getCanonicalName()) ;
        System.out.println(Thread.currentThread().getContextClassLoader().getParent().getClass().getCanonicalName()) ;
        //Thread.currentThread().setContextClassLoader(Thread.currentThread().getContextClassLoader().getParent().getParent()) ;

        ServiceLoader<URLStreamHandlerProvider> urlStreamHandlerProviderLoader = ServiceLoader.load(URLStreamHandlerProvider.class);
        for (URLStreamHandlerProvider urlStreamHandlerProvider : urlStreamHandlerProviderLoader) {
            System.out.println("url handler provider: " + urlStreamHandlerProvider.getClass().getCanonicalName());
        }

        try {
            URL uri = new URL("springbootssl:keystore");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        ServiceLoader<GreetService> greetServiceServiceLoader = ServiceLoader.load(GreetService.class);
        for (GreetService knownGreeter : greetServiceServiceLoader) {
            System.out.println(knownGreeter.greet("haha"));
        }

    }
}
