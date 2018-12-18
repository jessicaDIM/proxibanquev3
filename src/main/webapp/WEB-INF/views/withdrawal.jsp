<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Effectuer un retrait</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="css/agency.min.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
</head>
<body>
	<div style="margin-top:100px">
		<p class="name">${client.firstname} ${client.lastname}</p>
	</div>





    <div class="transfer-container">
				<form method="post" action="">
				<!-- 	    Mettre un href a addCard.html?accountId= pour un retrait de carte -->
					<div class ="account-list">
						<div class="left-list">
							<h2>Effectuer un retrait d'espèces</h2>
							<table>
								<tr>
									<th> Numéro de compte </th>
									<th class="balance"> Solde en € </th>
								</tr>
								<c:forEach var="account" items="${accounts}">
									<tr class="data">
										<td>
											<input type="radio" id="${account.id}" name="compteADebiter" value="${account.id}">
											<label for="${account.id}">n°${account.number}</label>
										</td>
										<td class="balance">${account.balance}</td>
								</c:forEach>
							</table>
							<div>
								<label for="value" class="text"> Montant du retrait : </label> 
								<input type="text" name="value" id="value" style="margin-left : 0.5em;">
								<button style="margin-left : 2em;" class="button">Confirmer</button>
							</div>
						</div>
						<div class="right-list">
							<h2>Demande de Carte Bleue</h2>
								<table>
								<tr>
									<th> Numéro de compte </th>
									<th class="balance"> Solde en € </th>
								</tr>
								<c:forEach var="account" items="${accounts}">
									<tr class="data">
										<td>
											<input type="radio" id="${account.id}" name="compteADebiter" value="${account.id}">
											<label for="${account.id}">n°${account.number}</label>
										</td>
										<td class="balance">${account.balance}</td>
								</c:forEach>
							</table>
							<label for="value" class="text"> Choix de carte </label> 
							<input type="text" name="value" id="value" style="margin-left : 0.5em;">
							<button style="margin-left : 2em;" class="button">Confirmer</button>
						</div>
							
							
						</div>
					</div>
				</form>
			</div>































	<div class="transfer-button" style="margin-top:50px">
>>>>>>> 5ea37688761fed0ce251d1b327799e360a741931
		<a href="index.html">
			<button class="button">Retour à l'accueil</button>
		</a>
	</div>
</body>
</html>