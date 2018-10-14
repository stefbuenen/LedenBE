package nl.nextprogram.ledenBE.api;

import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.nextprogram.ledenBE.domain.Postcode;
import nl.nextprogram.ledenBE.persistence.PostcodeService;


@Path ("postcode")
@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostcodeEndPoint {
	
	@Autowired
	private PostcodeService postcodeService;

	@GET
	public Response getPostcodes(){
		Iterable <Postcode> postcodes = postcodeService.findAll();
		return Response.ok(postcodes).build();
	}
	
	@GET
    @Path("{id}")
	public Response getPostcodeById(@PathParam("id") Long id){
		Optional<Postcode> postcode = postcodeService.findById(id);
		if (postcode.isPresent()) {
            return Response.ok(postcode.get()).build();
        } 
        System.out.println("Postcode id in GET not found!");
        return Response.status(Status.NOT_FOUND).build();
    }
	
	@POST
	public Response addPostcode(Postcode postcode){
		if (postcode!=null) {
			Postcode result = postcodeService.create(postcode);
			return Response.accepted(result.getId()).build();	
		}
        System.out.println("Postcode in POST is null!");
        return Response.status(Status.NO_CONTENT).build();
	}

	@PUT
	@Path("{id}")
    public Response updatePostcode(@PathParam("id") Long id, Postcode postcode){
		Optional<Postcode> postcodeExisting = postcodeService.findById(id);
		if (!postcodeExisting.isPresent()) {
			return Response.status(Status.NOT_FOUND).build();			
		};
			
		Postcode result = postcodeService.update(postcode);
		if (result == null) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			return Response.accepted(result).build();
		}
	}

	@DELETE
	@Path("{id}")
	public Response deleteBoeksaldo(@PathParam("id") Long id) {
		Optional<Postcode> postcodeExisting = postcodeService.findById(id);
		if (!postcodeExisting.isPresent()) {
			return Response.status(Status.NOT_FOUND).build();			
		};
			
		if (!postcodeService.delete(id)) {
			return Response.status(Status.NOT_FOUND).build();
		} else {	
			return Response.ok().build();
		}
	}

}
