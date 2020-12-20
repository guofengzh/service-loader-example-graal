package sukumaar;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.spi.URLStreamHandlerProvider;
import java.util.ServiceLoader;


/**
 * @author sukumaar
 */
public class ServiceLoaderExample {
    public static void main(String[] args) {
//        if (args.length < 2) {
//            System.out.println("parameter missing, we need 2 params");
//            System.out.println("1nd : who should greet");
//            System.out.println("2st : to whom");
//        }

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
