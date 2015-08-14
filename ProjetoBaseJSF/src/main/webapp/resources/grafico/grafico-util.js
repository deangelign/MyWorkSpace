function buscarPontos() {
	var url = ctx + "/rest/historico/buscarPontos";
	var idSensor = $("#idSelectSensor").val();
	var dataIncial = $("#idDataInicial").val();
	var dataFinal = $("#idDataFinal").val();
	
	var parametros = new Paramentros(idSensor, dataIncial, dataFinal);
	var json = JSON.stringify(parametros);
	
	$.post(url, json, function(historicos) {
		$.each(historicos, function(index, historico) {
			var valor = historico.valor;
			var tempo = historico.tempo;
		});
	});
	
}

function parametros(ataIniid, dcial, dataFinal) {
	this.id = id;
	this.dataInicial = dataInicial;
	this.dateFinal = dataFinal;
}