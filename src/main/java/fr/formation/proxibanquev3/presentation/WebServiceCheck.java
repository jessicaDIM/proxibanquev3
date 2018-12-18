package fr.formation.proxibanquev3.presentation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import fr.formation.proxibanquev3.metier.service.CheckService;

@Path("/menu")
public class WebServiceCheck {

	@GET
	public Response list() {
		return Response.ok(CheckService.getInstance().getChecks().toString()).build();
	}

	@GET
	@Path("/{id}")
	public Response read(@PathParam("id") Integer id) {
		return Response.ok(StockService.getInstance().getChocoStock(id)
				.getStock().toString()).build();
	}
	
	
	
	
	@GET
//	@Path("/{id}")
//	public Response read(@PathParam("id") Integer id) {
//		ChocoStock searchedStock = new ChocoStock();
//		searchedStock.setId(id);
//		int index = StockService.getInstance().getChocoStocks().indexOf(searchedStock);
//		if (index >= 0) {
//			ChocoStock chocoStock = StockService.getInstance().getChocoStocks().get(index);
//			return Response.ok(chocoStock.toString()).build();
//		} else {
//			return Response.status(Status.NOT_FOUND).build();
//		}
//	}
	
//	@POST
//	public Response create(@FormParam("title") String title, @FormParam("content") String content) {
//		Boolean createOK = StockService.getInstance().addStock(title, content);
//		return Response.status(createOK ? Status.OK : Status.INTERNAL_SERVER_ERROR).entity(createOK.toString()).build();
//	}
//	
//	@DELETE
//	@Path("/{id}")
//	public Response delete(@PathParam("id") Integer id) {
//		StockService.getInstance().deleteArticle(id);
//		return Response.noContent().build();
//	}
//	
//	@PUT
//	public Response update(@FormParam("id") Integer id, @FormParam("title") String title, @FormParam("content") String content) {
//		if (StockService.getInstance().update(id, title, content)) {
//			return Response.noContent().build();
//		} else {
//			return Response.status(Status.BAD_REQUEST).entity("Le paramètre 'id' est manquant dans le corps de la requête.").build();
//		}
//	} 
	
	
}
