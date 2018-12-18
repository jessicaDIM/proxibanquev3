function responseCheque(e) {
	var input = e.target || e.currentTarget;
	var accountId = input.id;
	$.ajax({
		url:"http://localhost:8080/proxibanquev3/webservices/menu",
		type:"post",
		data: {
			"id" : accountId
		}
	}).done(function() {
		$(".boutonCheque").css("visibility","hidden");      
		if (chequeStatus.isChequeIsOK) {
			var span1 = "<span class=\"cheque Ok\">";
			$('#infoCheque').append($(span1 + chequeStatus.getMessage + "</span>"));
			$("#infoCheque").css("color","green");
		}
		else {
			var span2 ="<span class=\"cheque Ko\">";
			$('#infoCheque').append($(span1 + chequeStatus.getMessage + "</span>"));
			$("#infoCheque").css("color","red");  
		}
	});
}






// “Premier chéquier pour ce compte en cours de distribution...”
//: “Nouveau chéquier valable jusqu’au DATE_EXPIR encours de distribution...” avec DATE_EXPIR la date d’expiration du chéquie
//e « Impossible d’effectuer le retrait d’un nouveauchéquier pour ce compte avant le DATE_VALIDE » avec DATE_VALIDE lapremière date valide dans le temps pour retirer ce chéquier