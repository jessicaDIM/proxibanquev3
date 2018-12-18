package fr.formation.proxibanquev3.presentation;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/menu")
public class WebServiceCheck {

	@GET
	public Response list() {
		return Response.ok()
				.ok(StockService.getInstance().getChocoStocks().toString())
				.build();
	}

	@GET
	@Path("/{id}")
	public Response read(@PathParam("id") Integer id) {
		return Response.ok(StockService.getInstance().getChocoStock(id)
				.getStock().toString()).build();
	}
	
	
	
	
	
	
	
}
