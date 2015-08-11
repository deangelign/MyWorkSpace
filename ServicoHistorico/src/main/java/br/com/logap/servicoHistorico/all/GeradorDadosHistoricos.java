package br.com.logap.servicoHistorico.all;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GeradorDadosHistoricos {

	public GeradorDadosHistoricos() { 
	}

	public static void main(String args[]) {
		//TODO Criar Tabela no banco
		GerarDadosHistoricosThread thread = new GerarDadosHistoricosThread();
		ScheduledThreadPoolExecutor scheduledThread = new ScheduledThreadPoolExecutor(50);
		scheduledThread.scheduleWithFixedDelay(thread, 0, 30, TimeUnit.SECONDS);
	}

}
