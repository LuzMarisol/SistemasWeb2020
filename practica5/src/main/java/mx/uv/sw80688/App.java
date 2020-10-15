package mx.uv.sw80688;
import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App {
    
    public static void main( String[] args ){
        options("/*",
        (request, response) -> {

            String accessControlRequestHeaders = request
                    .headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers",
                        accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request
                    .headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods",
                        accessControlRequestMethod);
            }

            return "OK";
        });
        
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
        get("/hello/:name", (request,response) -> {
            return "Hello: " + request.params(":name");
        });
    } 
}
