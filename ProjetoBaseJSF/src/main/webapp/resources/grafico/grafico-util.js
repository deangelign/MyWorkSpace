function buscarPontos() {
	var url = ctx + "/rest/historico/buscarPontos";
	var idSensor = $("select[name$='caixaSelecaoSensor'] option:selected").val();
	var dataIncial = $("#dataInicio").val();
	var dataFinal = $("#dataFim").val();
	
	var parametrosRequest = new parametros(idSensor, dataIncial, dataFinal);
	var parametrosRequestJSON = JSON.stringify(parametrosRequest);
	

	
	$.ajax({
		  url: url,
		  type:'POST',
		  data: parametrosRequestJSON,
		  dataType: 'json',
		  contentType: "application/json",
		  
		  success: function(data) {
			  var graficoHighChart = $('#grafico').highcharts();
			  var pontosGrafico = [];
			  
			  $.each(data, function(index, historico){
				 pontosGrafico.push({x:historico.tempo, y:historico.valor});
			  });
			  
			  graficoHighChart.series[0].setData(pontosGrafico);
			  graficoHighChart.yAxis[0].update();	
			 
		  }
		});

	
	
//	atualizarGrafico();
	
}

function parametros(id, dataInicio, dataFim) {
	this.id = id;
	this.dataInicio = dataInicio;
	this.dataFim = dataFim;
}

$(document).ready(function(){
	criarGrafico();
});

function criarGrafico() {
	var data;
	var chart = new Highcharts.StockChart({
		chart : {
			renderTo : 'grafico'
		},

		rangeSelector : {
			selected : 1
		},

		title : {
			text : 'Medicao de sensor'
		},
		
		series : [{
			name : 'medicoes',
			data : data,
			tooltip: {
				valueDecimals: 2
			}
		}]
	});

	
};