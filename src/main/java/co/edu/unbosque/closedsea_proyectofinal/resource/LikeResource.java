package co.edu.unbosque.closedsea_proyectofinal.resource;


import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.LikeArt;
import co.edu.unbosque.closedsea_proyectofinal.services.LikeService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@Path("/users/{email}/arts/{art}/like")
public class LikeResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@PathParam("email") String email, @PathParam("art") int id ) {

        LikeService likeService = new LikeService();

        try {
            Optional<LikeArt> likeservice = likeService.save(id, email);

            if (likeservice.isPresent()) {
                return Response
                        .status(201)
                        .entity(likeservice.get())
                        .build();
            } else {
                return Response
                        .serverError()
                        .build();
            }
        } catch (Exception e) {
            return Response
                    .status(404)
                    .build();
        }
    }
}
