package br.com.fiap.resource.yourfriend.controler;

import br.com.fiap.resource.yourfriend.domain.User;
import br.com.fiap.resource.yourfriend.service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.SQLException;
import java.util.List;


@Path("/users")
public class UserController {

    private UserService service = new UserService();

    @GET
    @Produces("application/json")
    public List<User> listUsers() {
        return service.getAllUser();
    }

    @GET
    @Produces("application/json")
    @Path("{email}")
    public List verifiedByEmail(@PathParam("email") String email) {
        return   service.verifiedByEmail(email);

    };

    @POST
    @Consumes("application/json")
    public Response add(User user, @Context UriInfo uriInfo) {
        service.insertUser(user);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(user.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public  Response edit(User user, @PathParam("id")Integer id){
        service.edit(user,id);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public  Response delete(@PathParam("id") Integer id ){
        service.delete(id);
        return  Response.accepted().build();
    }


}