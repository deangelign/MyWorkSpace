function buscarPontos() {
	var url = ctx + "/rest/historico/buscarPontos6";
	var idSensor = $("select[name$='caixaSelecaoSensor'] option:selected").val();
	var dataIncial = $("#dataInicio").val();
	var dataFinal = $("#dataFim").val();
	
	var parametros = new Parametros(idSensor, dataIncial, dataFinal);
	var json = JSON.stringify(parametros);
	
	
	//var name = "issoAkiEUmTeste";
	
	//$.post(url, json, function(historicos) {
	//	alert("isso aqui e um teste");
	//	var aux = 1;
		//$.each(historicos, function(index, historico) {
		//	var valor = historico.valor;
		//	var tempo = historico.tempo;
		//});
	//});
	$.post(url,function(data){
		alert("teste");
		var aux = data.nome;
	});
	
	//aux = historicos.length
	//aux2 = valor;
	var aux2 = data.nome;
	
	atualizarGrafico();
	
}

function Parametros(id, dataInicial, dataFinal) {
	this.id = id;
	this.dataInicial = dataInicial;
	this.dateFinal = dataFinal;
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