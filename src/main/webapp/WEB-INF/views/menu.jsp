<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Acceuil</title>

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
	<div>
		<table class="table table-hover">
            
            <thead>
                <tr>
                    <th class="listecompte">Id</th>
                    <th class="listecompte">Num�ro de compte</th>
                    <th class="listecompte">Solde</th>
                    <th class="listecompte">Date d'ouverture</th>
                    <th class="listecompte">Compte �pargne</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="account" items ="${accounts}">
                <tr>    
                    <td class="listecompte">${account.id}</td>
                    <td class="listecompte">${account.number}</td>
                    <td class="listecompte">${account.balance}</td>
                    <td class="listecompte">${account.openDate}</td>
                    <td class="listecompte">${account.type}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
	</div>
</body>
</html>