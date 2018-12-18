$(document).ready(function() {
	$("#choco").selectmenu({
		select : function(event, ui) {
			console.log("Item sélectionné : ", ui);
			var id = ui.item.element[0].id;
			$.ajax({
				url: "http://localhost:8080/proxibanquev3/webservices/chocostock/" + id
			}).done(function(stock) {
				var nbStock = parseInt(stock);
				var stockinfoDiv = $("#stockinfo");
				stockinfoDiv.empty();
				if (nbStock > 0) {
					// En stock
					stockinfoDiv.append($("<span class=\"stock ok\">En stock !</span>"));
				} else {
					// Pas de stock
					stockinfoDiv.append($("<span class=\"stock ko\">Pas de stock !</span>"));			
				}
			});
		}
	});
});

// “Premier chéquier pour ce compte en cours de distribution...”
//: “Nouveau chéquier valable jusqu’au DATE_EXPIR encours de distribution...” avec DATE_EXPIR la date d’expiration du chéquie
//e « Impossible d’effectuer le retrait d’un nouveauchéquier pour ce compte avant le DATE_VALIDE » avec DATE_VALIDE lapremière date valide dans le temps pour retirer ce chéquier