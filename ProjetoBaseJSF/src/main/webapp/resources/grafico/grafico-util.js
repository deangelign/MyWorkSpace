function buscarPontos() {
	var url = ctx + "/rest/historico/buscarPontos";
	var idSensor = $("select[name$='caixaSelecaoSensor'] option:selected").val();
	var dataIncial = $("#dataInicio").val();
	var dataFinal = $("#dataFim").val();
	
	var parametrosRequest = new parametros(idSensor, dataIncial, dataFinal);
	var parametrosRequestJSON = JSON.stringify(parametrosRequest);
	
	//var name = "issoAkiEUmTeste";
	
	//$.post(url, json, function(historicos) {
	//	alert("isso aqui e um teste");
	//	var aux = 1;
		//$.each(historicos, function(index, historico) {
		//	var valor = historico.valor;
		//	var tempo = historico.tempo;
		//});
	//});
	
	$.ajax({
		  url: url,
		  type:'POST',
		  data: parametrosRequestJSON,
		  dataType: 'json',
		  contentType: "application/json",
		  success: function() {
		    alert("final");	
		  }
		});
//	$.post(url,json, function(data){
//		alert("teste");
//		var aux = data.nome;
//	});
	
	//aux = historicos.length
	//aux2 = valor;
	
//	atualizarGrafico();
	
}

function parametros(id, dataInicio, dataFim) {
	this.id = id;
	this.dataInicio = dataInicio;
	this.dataFim = dataFim;
}


function atualizarGrafico() {
    $('#grafico').highcharts({
        title: {
            text: 'Medicoes do sensor',
            x: -20 //center
        },
        subtitle: {
            text: 'sensor',
            x: -20
        },
        xAxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        },
        yAxis: {
            title: {
                text: 'Temperature (°C)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '°C'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: 'Tokyo',
            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
        }]
    });
};