package mx.uv.basededatos;

import static spark.Spark.*;
import java.util.UUID;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class AppDB 
{   
    private static Gson gson = new Gson();
    public static void main( String[] args ){

        options("/*",
        (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });
        

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
        
        before((req, res) -> res.type("application/json")); 
        get("/usuarios",(req,res)-> gson.toJson(DAO.dameUsuarios()));

       /* List<Usuarios> users = new ArrayList<>();
        users = DAO.dameUsuarios();

        for(Usuarios user: users) {
            System.out.println("ID: " + user.getId() + "\n" + 
                                "Email: " + user.getEmail() + "\n" + 
                                "Password: " + user.getPassword());
            System.out.println();
        }

        return gson.toJson(users);
    });*/
        
        post("/usuarios", (req, res) -> {
            String query = req.body();
            System.out.println("peticion: " + query);
            Usuarios u = gson.fromJson(query, Usuarios.class);
            String id = UUID.randomUUID().toString();
            u.setId(id);
           
            return DAO.crearUsuarios(u);
        });
    }
}
