package br.com.fiap.resource.yourfriend.controler;

import br.com.fiap.resource.yourfriend.domain.Comments;
import br.com.fiap.resource.yourfriend.service.CommentsService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/comments")
public class CommentsController {
    CommentsService service = new CommentsService();

    @GET
    @Produces("application/json")
    public List<Comments> getAllComments() {
        return service.getAllComments();
    }

    @POST
    @Consumes("application/json")
    public Response insertComments(Comments comments, @Context UriInfo uriInfo) {
        service.insertComments(comments);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(comments.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("{id}") //precissa ser o mesmo parametro da clase java, Domain esta como id
    @Consumes("application/json")
    public Response editComments(Comments comments, @PathParam("id") Integer id) {
        service.editComments(comments, id);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    public Response deleteComments(@PathParam("id") Integer id) {
        service.deleteComments(id);
        return Response.accepted().build();
    }
}
