package co.edu.unbosque.closedsea_proyectofinal.resource;

import co.edu.unbosque.closedsea_proyectofinal.dto.UserDTO;
import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.UserApp;
import co.edu.unbosque.closedsea_proyectofinal.services.UserAppService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;


@Path("/users")
public class UserResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response writeInDatabase(UserDTO userDTO){

        UserAppService userAppService = new UserAppService();
        Optional<UserApp> userApp = userAppService.saveInDb(userDTO.getEmail(), userDTO.getPassword(), userDTO.getName(), userDTO.getRole());

        if(userApp.isPresent()){
            return Response.status(201).entity(userApp.get()).build();
        } else {
            return Response.serverError().build();
        }
    }
}

