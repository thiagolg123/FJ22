package br.com.caelum.argentum.manegedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.ChartModel;

import br.com.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.ws.ClienteWebService;

@ManagedBean
@ViewScoped
public class HomeBean {
	
	  private List<Negociacao> negociacoes;
	  private ChartModel modeloGrafico;

	  public HomeBean() {
		  this.negociacoes = new ClienteWebService().getNegociacoes();
		    List<Candlestick> candles = new CandlestickFactory().constroiCandles(negociacoes);
		    SerieTemporal serie = new SerieTemporal(candles);

		    GeradorModeloGrafico geradorGrafico = 
		          new GeradorModeloGrafico(serie, 2, serie.getUltimaPosicao());
		    geradorGrafico.plotaMediaMovelSimples();
		    this.modeloGrafico = geradorGrafico.getModeloGrafico();
	  }

	  public List<Negociacao> getNegociacoes() {
	    return negociacoes;
	  }

	  public ChartModel getModeloGrafico() {
	    return modeloGrafico;
	  }
}
