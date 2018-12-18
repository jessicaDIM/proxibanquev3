


<div class="row">
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Faire un retrait</h5>
        
        <div class="transfer-container">
				<form method="post" action="">
						<div class="right-list">
							<h2>Compte courrant à débiter</h2>
							<table>
								<tr>
									<th> Numéro de compte </th>
									<th class="balance"> Solde en € </th>
								</tr>
								<c:forEach var="account" items="${accounts}">
									<tr class="data">
										<td>
											<input type="radio" id="${account.id}" name="compteACrediter" value="${account.id}">
											<label for="${account.id}">n°${account.number}</label>
										</td>
										<td class="balance">${account.balance}</td>
								</c:forEach>
							</table>
						</div>
					</div>
					<div class="centered-input">
						<div>
							<label for="value" class="text"> Montant du virement : </label> 
							<input type="number" step=0.01 name="value" id="value" style="margin-left : 0.5em;">
							<button style="margin-left : 2em;" class="button">Confirmer</button>
						</div>
					</div>
				</form>
			</div>
      </div>
    </div>
  </div>
  
  
  
  
  
  
  
  
  
  
  
  
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Special title treatment</h5>
        
        
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        
        
        <a href="#" class="btn btn-primary">Valider</a>
      </div>
    </div>
  </div>
</div>














	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Account> currentAccount = new ArrayList();
		List<Account> savingsAccount = new ArrayList();
		Client client = (Client) req.getSession().getAttribute("client");
		List<Account> accounts= client.getAccounts();
		req.setAttribute("accounts", accounts);
		for (Account account: accounts) {
			if (account instanceof CurrentAccount) {
				currentAccount.add(account);
			} else { 
				savingsAccount.add(account);
			}
			req.setAttribute("savingsAccounts", savingsAccount);
			req.setAttribute("currentAccounts", currentAccount);
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/menu.jsp").forward(req, resp);
		}
	}