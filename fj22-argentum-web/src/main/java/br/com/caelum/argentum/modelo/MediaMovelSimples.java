package br.com.caelum.argentum.modelo;

import br.com.argentum.grafico.Indicador;

public class MediaMovelSimples implements Indicador{

	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		for (int i = posicao; i > posicao - 3; i--) {
			soma += serie.getCandle(i).getFechamento();
		}
		return soma / 3;
	}
}
