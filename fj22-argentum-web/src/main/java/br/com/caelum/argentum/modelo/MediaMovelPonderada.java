package br.com.caelum.argentum.modelo;

import br.com.argentum.grafico.Indicador;

public class MediaMovelPonderada implements Indicador{

	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		int peso = 3;

		for (int i = posicao; i > posicao - 3; i--) {
			Candlestick c = serie.getCandle(i);
			soma += c.getFechamento() * peso;
			peso--;
		}
		return soma / 6;
	}
}