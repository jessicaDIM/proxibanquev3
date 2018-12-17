<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Outil de virement</title>

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
	<section class="head"></section>
	
	<section class="account-body">
		<c:if test="${not empty message }">
			<div style="color:red;text-align:center;size:x-large">
				 ${message}		
			</div>
		</c:if>
		<c:if test="${fn:length(accounts) <= 1}">
			<div style="color:red;text-align:center;size:x-large">
				 Vous ne pouvez pas effectuer de virement interne si vous n'avez pas 2 comptes au minimum	
			</div>
		</c:if>
		<c:if test="${fn:length(accounts) > 1}">
		<h1 class="page-title">Transfert pour ${client.firstname} ${client.lastname }</h1>
			<div class="transfer-container">
				<form method="post" action="">
				
					<div class ="account-list">
						<div class="left-list">
							<h2>Compte à débiter</h2>
							<table>
								<tr>
									<th> Numéro de compte </th>
									<th class="balance"> Solde en &#8364 </th>
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
						<div class="right-list">
							<h2>Compte à créditer</h2>
							<table>
								<tr>
									<th> Numéro de compte </th>
									<th class="balance"> Solde en &#8364 </th>
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
		</c:if>
		<div class="footer-button">
			<a href="index.html">
				<button class="button">Retour à l'accueil</button>
			</a>
		</div>
	</section>
</body>
</html>