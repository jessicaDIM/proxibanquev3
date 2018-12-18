<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Retrait impossible</title>
</head>
<body>
	<h1>Impossible d’effectuer le retrait, votre ancienne carte est encore valide.</h1>
	
	
	<div class="transfer-button" style="margin-top:50px">

		<a href="menu.html?id=${client.id}">
			<button class="button">Retour au menu </button>
		</a>
	</div>
	
</body>
</html>