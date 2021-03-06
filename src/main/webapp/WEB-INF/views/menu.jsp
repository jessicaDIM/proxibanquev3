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
<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script> 
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<script type="text/javascript" src="js/menu.js"></script>
<title>Accueil</title>

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
	<h1 class="page-title">Bienvenue sur Proxibanque 3.0.</h1>
	<div style="margin-top:100px">
		<p class="name">${client.firstname} ${client.lastname}</p>
		
	</div>
	<div>
		<table class="table table-hover">
            
            <thead>
                <tr>
                    <th class="listecompte">Id</th>
                    <th class="listecompte">Numéro de compte</th>
                    <th class="listecompte">Solde</th>
                    <th class="listecomptes">Demande de chéquier</th>

                </tr>
            </thead>
            <tbody>
            <c:forEach var="account" items ="${accounts}">
                <tr>    
                    <td class="listecompte">${account.id}</td>
                    <td class="listecompte">${account.number}</td>
                    <td class="listecompte">${account.balance}</td>
                    <td class="listecompte"><div id="infoCheque"><input type="button" id="${account.id}" class="boutonCheque" value="Demande de chéquier" onclick="responseCheque(event)"></div></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
	</div>

	<div style="text-align:center; margin-bottom:100px">
		
		<a href="addCard.html?id=${client.id }"><input type="button"  value="Demander une carte"></a>
		<a href="withdrawal.html?id=${client.id }"><input type="button"  value="Réaliser un retrait"></a>
		<a href="transfer.html?id=${client.id }"><input type="button"  value="Faire un virement interne"></a>
		<a href="index.html"><input type="button" value="Se Déconnecter"></a>

	</div>
	
</body>
</html>