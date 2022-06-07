package co.edu.unbosque.closedsea_proyectofinal.resource;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Collection;
import co.edu.unbosque.closedsea_proyectofinal.resource.pojos.CollectionPOJO;
import co.edu.unbosque.closedsea_proyectofinal.services.CollectionService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@Path("/users/{email}/collections")
public class CollectionsResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@PathParam("email") String email, CollectionPOJO collectionPOJO) {

        CollectionService collectionService = new CollectionService();

        try {
            Optional<Collection> collection = collectionService
                    .save(email, collectionPOJO.getName(), collectionPOJO.getDescription(), collectionPOJO.getCategory());

            if (collection.isPresent()) {
                return Response
                        .status(201)
                        .entity(collection.get())
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
