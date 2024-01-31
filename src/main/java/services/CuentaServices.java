package services;

import business.GestionCuentas;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("cuentas")
public class CuentaServices {
	
	@Inject
    private GestionCuentas gCuentas;
	
	
	@Path("/transferir")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response transferir(@QueryParam("origen") int cuentaOrigen, 
                               @QueryParam("destino") int cuentaDestino, 
                               @QueryParam("monto") double monto) {
        try {
            gCuentas.realizarTransferencia(cuentaOrigen, cuentaDestino, monto);
            return Response.ok().entity("Transferencia realizada con éxito").build();
        } catch (Exception e) {
            ErrorMessage error = new ErrorMessage(99, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(error)
                    .build();
        }
    }
	
	
}
