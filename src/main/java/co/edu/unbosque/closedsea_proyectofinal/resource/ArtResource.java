package co.edu.unbosque.closedsea_proyectofinal.resource;

import co.edu.unbosque.closedsea_proyectofinal.jpa.entities.Art;
import co.edu.unbosque.closedsea_proyectofinal.resource.pojos.ArtPOJO;
import co.edu.unbosque.closedsea_proyectofinal.services.ArtService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Optional;

/*@Path("/users/{email}/collections/{collection}/arts")*/
@Path("/collections/{collection}/arts")
public class ArtResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@PathParam("collection") int id, ArtPOJO artPOJO){
        ArtService artService = new ArtService();

        try{


            Optional<Art> art =
                    artService.save(id,artPOJO.getName(),artPOJO.getPrice(),artPOJO.getImagePath(),artPOJO.isForSale());

            if(art.isPresent()){
                return Response
                        .status(200)
                        .entity(art.get())
                        .build();
            } else {
                return Response
                        .serverError()
                        .build();
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.status(404).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Integer id){

        ArtService artService = new ArtService();
        Optional<Art> art = artService.get(id);

        if(art.isPresent()){
            return Response
                    .status(200)
                    .entity(art.get())
                    .build();
        } else {
            return Response
                    .status(404)
                    .build();
        }
    }
}
