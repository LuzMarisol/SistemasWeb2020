package mx.uv.sw80688;
import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        get("/", (req, res) -> "Hola desde Spark");
    }
}
