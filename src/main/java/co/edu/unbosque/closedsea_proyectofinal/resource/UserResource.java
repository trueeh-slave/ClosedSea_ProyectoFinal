package co.edu.unbosque.closedsea_proyectofinal.resource;

import co.edu.unbosque.closedsea_proyectofinal.services.UserService;
import co.edu.unbosque.closedsea_proyectofinal.dto.User;
import jakarta.servlet.ServletContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


@Path("/users")
public class UserResource {

    @Context
    ServletContext context;

    static final String JDBC_DRIVER = "org.postgres.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost/ClosedSeaDB";
    static final String USER = "postgres";
    static final String PASS = "1234";

    @Path("/register")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createUser(@FormParam("email") String email, @FormParam("password") String password, @FormParam("name") String name, @FormParam("role") String role){
        System.out.println("1");
        Connection connection = null;
        List<User> userList = null;
        User user = null;

        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER,PASS);

            UserService userService = new UserService(connection);

            user = new User(email, password, name, role);
            userList.add(user);
            userService.newUser(user);

            connection.close();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try{
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
        return Response.created(UriBuilder.fromResource(UserResource.class).path(email).build())
                .entity(user)
                .build();
    }
}

