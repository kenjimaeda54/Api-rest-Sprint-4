package br.com.fiap.resource.yourfriend.controler;


import br.com.fiap.resource.yourfriend.domain.Boot;
import br.com.fiap.resource.yourfriend.service.BootService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/boots")
public class BootController {
    private BootService service = new BootService();

    @GET
    @Produces("application/json")
    public List<Boot> listAllBoot() {
        return service.getALlBot();
    }

    @POST
    @Consumes("application/json")
    public Response insertPhases(Boot boot, @Context UriInfo uriInfo) {
        service.insertPhases(boot);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(boot.getId()));
        return Response.created(builder.build()).build();
    }


}