package br.com.logap.servicoHistorico.all;

import org.apache.log4j.Logger;

public class ThreadSensorManager implements Runnable{

	private  final static Logger loggerSensorReveiver = Logger.getLogger(GeradorDadosHistoricos.class);

	
	@Override
	public void run() {
		
		loggerSensorReveiver.info("Consultando id dos sensores......");
		//setHistoricos(pegarIdSensores());
		loggerSensorReveiver.info("Consulta realizada com sucesso");

		
	}

	
	
}
