package Resource;

import Classes.Cidade;
import Classes.ContaBancaria;
import DAO.ContaBancariaDAO;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.dropwizard.jersey.params.*;
import java.util.*;

@Path("/contasbancaria")
@Produces(MediaType.APPLICATION_JSON)
public class ContaBancariaResource {

    private ContaBancariaDAO daocontasbancaria;

    public ContaBancariaResource(ContaBancariaDAO daocontasbancaria) {
        this.daocontasbancaria = daocontasbancaria;
    }

    @GET
    public List<ContaBancaria> read() {
        return daocontasbancaria.read();
    }

    @POST
    public ContaBancaria create(ContaBancaria cb) {
        return this.daocontasbancaria.create(cb);
    }

    @PUT
    @Path("{id}")
    public boolean update(@PathParam("id") IntParam id, ContaBancaria p) {
        return daocontasbancaria.update(p, id.get());
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") IntParam id) {
        if (this.daocontasbancaria.delete(id.get())) {
            return Response.ok().build();
        } else {
            return Response.serverError().build();
        }

    }
}
