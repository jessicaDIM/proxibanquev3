package fr.formation.proxibanquev3.presentation.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.formation.proxibanquev3.metier.entity.Account;
import fr.formation.proxibanquev3.metier.entity.ChequeStatus;
import fr.formation.proxibanquev3.metier.service.AccountService;

import fr.formation.proxibanquev3.metier.service.AccountService;

@Path("/menu")
public class WebServiceCheck {
	

	private AccountService accountService;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	
	public ChequeStatus check(Account account) {
		Integer accountId = account.getId();
		boolean response = accountService.withdrawCheck(accountId);
		return null;
	}


	
	
	
}
