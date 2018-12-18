function responseCheque(e) {
	var input = e.target || e.currentTarget;
	var accountId = input.id;
	var account = JSON.stringify({"id" : accountId});
	
	$.ajax({
		url:"http://localhost:8080/proxibanquev3/webservices/menu",
		type:"post",
		contentType: "application/json",
		data: account,
		dataType: "json"
	}).done(function(chequeStatus) {
		$(".boutonCheque").css("visibility","hidden");      
		if (chequeStatus.chequeIsOK) {
			$('#infoCheque').append(chequeStatus.message);
			$("#infoCheque").css("color","green");
			console.log(chequeStatus.message);
		}
		else {
			$('#infoCheque').append(chequeStatus.message);
			$("#infoCheque").css("color","red");  
			console.log(chequeStatus.message);
		}
	});
}






// “Premier chéquier pour ce compte en cours de distribution...”
//: “Nouveau chéquier valable jusqu’au DATE_EXPIR encours de distribution...” avec DATE_EXPIR la date d’expiration du chéquie
//e « Impossible d’effectuer le retrait d’un nouveauchéquier pour ce compte avant le DATE_VALIDE » avec DATE_VALIDE lapremière date valide dans le temps pour retirer ce chéquier