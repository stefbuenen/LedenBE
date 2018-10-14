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

import nl.nextprogram.ledenBE.domain.Lid;
import nl.nextprogram.ledenBE.persistence.LidService;


@Path ("lid")
@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LidEndPoint {
	@Autowired
	private LidService lidService;

	@GET
	public Response getLeden(){
		Iterable <Lid> leden = lidService.findAll();
		return Response.ok(leden).build();
	}
	
	@GET
    @Path("{id}")
	public Response getLidById(@PathParam("id") Long id){
		Optional<Lid> lid = lidService.findById(id);
		if (lid.isPresent()) {
            return Response.ok(lid.get()).build();
        } 
        System.out.println("Lid id in GET not found!");
        return Response.status(Status.NOT_FOUND).build();
    }
	
	@POST
	public Response addLid(Lid lid){
		if (lid!=null) {
			Lid result = lidService.create(lid);
			return Response.accepted(result.getId()).build();	
		}
        System.out.println("Lid in POST is null!");
        return Response.status(Status.NO_CONTENT).build();
	}

	@PUT
	@Path("{id}")
    public Response updateLid(@PathParam("id") Long id, Lid lid){
		Optional<Lid> lidExisting = lidService.findById(id);
		if (!lidExisting.isPresent()) {
			return Response.status(Status.NOT_FOUND).build();			
		};
			
		Lid result = lidService.update(lid);
		if (result == null) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			return Response.accepted(result).build();
		}
	}

	@DELETE
	@Path("{id}")
	public Response deleteBoeksaldo(@PathParam("id") Long id) {
		Optional<Lid> lidExisting = lidService.findById(id);
		if (!lidExisting.isPresent()) {
			return Response.status(Status.NOT_FOUND).build();			
		};
			
		if (!lidService.delete(id)) {
			return Response.status(Status.NOT_FOUND).build();
		} else {	
			return Response.ok().build();
		}
	}
}

