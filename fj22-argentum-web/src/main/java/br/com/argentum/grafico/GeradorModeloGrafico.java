package br.com.argentum.grafico;

import java.io.Serializable;

import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.caelum.argentum.modelo.MediaMovelSimples;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class GeradorModeloGrafico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3433280867893236788L;
	private SerieTemporal serie;
	private int comeco;
	private int fim;
	private LineChartModel modeloGrafico;

	public GeradorModeloGrafico(SerieTemporal serie, int comeco, int fim) {
		this.serie = serie;
		this.comeco = comeco;
		this.fim = fim;
		this.modeloGrafico = new LineChartModel();
		this.modeloGrafico.setTitle("MMS - Fechamento");
		this.modeloGrafico.setLegendPosition("e");
	}

	public void plotaMediaMovelSimples() {
		MediaMovelSimples indicador = new MediaMovelSimples();
		LineChartSeries chartSerie = new LineChartSeries("fechamento");

		for (int i = comeco; i <= fim; i++) {
			double valor = indicador.calcula(i, serie);
			chartSerie.set(i, valor);
		}
		this.modeloGrafico.addSeries(chartSerie);
	}

	public ChartModel getModeloGrafico() {
		return this.modeloGrafico;
	}

}
