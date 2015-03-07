package br.com.argentum.grafico;

import br.com.caelum.argentum.modelo.SerieTemporal;

public interface Indicador {
	public double calcula(int posicao, SerieTemporal serie);
}
