package fr.formation.proxibanquev3.presentation.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.formation.proxibanquev3.metier.entity.Account;
import fr.formation.proxibanquev3.metier.entity.ChequeStatus;
import fr.formation.proxibanquev3.metier.service.AccountService;

/**
 * Web service permettant d'envoyer et recevoir des informations sous format JSON sans avoir à recharger la page
 * @author Jessica Di Marco & Sandy Colin
 *
 */
@Path("/menu")
public class WebServiceCheck {
	/**
	 * Méthode qui va envoyer et recevoir des informations JSON et qui va permettre de dire s'il faut éditer un nouveau chéquier
	 * @param account afin de récupérer son id pour vérifier s'il est possible de créer un nouveau chéquier
	 * @return un objet de type ChequeStatus qui permet de savoir quel message doit être affiché
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	
	public ChequeStatus check(Account account) {
		Integer accountId = account.getId();
		ChequeStatus chequeStatus = AccountService.getInstance().withdrawCheck(accountId);
		return chequeStatus;
	}


	
	
	
}
