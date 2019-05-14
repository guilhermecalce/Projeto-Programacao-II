
package Resource;
import Classes.Cidade;
import DAO.CidadeDAO;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.dropwizard.jersey.params.*;
import java.util.*;

@Path("/cidades")
@Produces(MediaType.APPLICATION_JSON)
public class CidadeResource {
    private CidadeDAO daocidade;
    
    public CidadeResource (CidadeDAO daocidade){
        this.daocidade = daocidade;
    }
    
    @GET
    public List<Cidade> read() {
        return daocidade.read();
    }
    
    @POST
    public Cidade create(Cidade c) {
        return this.daocidade.create(c);
    }
    
@PUT
    @Path("{id}")
    public boolean update(@PathParam("id") IntParam id, Cidade p) {
        return daocidade.update(p, id.get());
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") IntParam id) {
        if (this.daocidade.delete(id.get())) {
            return Response.ok().build();
        } else {
            return Response.serverError().build();
        }

    }
}

