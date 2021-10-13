package br.com.fiap.resource.yourfriend.controler;


import br.com.fiap.resource.yourfriend.domain.Boot;
import br.com.fiap.resource.yourfriend.service.BootService;

import javax.ws.rs.*;
import java.util.List;

@Path("/boots")
public class BootController {
    private BootService service = new BootService();

    @GET
    @Produces("application/json")
    public List<Boot> listAllBoot() {
        return service.getALlBot();
    }



}