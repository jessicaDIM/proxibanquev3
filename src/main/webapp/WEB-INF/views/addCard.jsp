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
		<p class="name">Demande de carte bleue</p>
	</div>
		<c:if test="${not empty message1 }">
			<div style="color:red;text-align:center;size:x-large">
				 ${message1}		
			</div>
		</c:if>
		<c:if test="${not empty message2 }">
			<div style="color:red;text-align:center;size:x-large">
				 ${message2}		
			</div>
		</c:if>


	<h3>Sélectionner un compte</h3>
    <div>
				<form method="post" action="">
				<!-- 	    Mettre un href a addCard.html?accountId= pour un retrait de carte -->
					<div class ="account-list">
					<div class="left-list">
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
					</div>
		
		
		<div class="right-list" >
		<h3>Sélectionner un type de carte</h3>
		  <input class="form-check-input" type="radio" name="cardType" id="inlineRadio1" value="Visa premier">
		  <label class="form-check-label" for="cardType">Visa Premier</label>
		</div>
		<div class="form-check form-check-inline">
		  <input class="form-check-input" type="radio" name="cardType" id="inlineRadio2" value="Visa electron">
		  <label class="form-check-label" for="cardType">Visa Electron</label>
			</div>

		<button style="margin-left : 2em;" class="button">Confirmer</button>				
		
	</div>
	</form>
	</div>
		<div class="transfer-button" style="margin-top:50px">

		<a href="menu.html?id=${client.id}">
			<button class="button">Retour au menu </button>
		</a>
	</div>
</body>
</html>