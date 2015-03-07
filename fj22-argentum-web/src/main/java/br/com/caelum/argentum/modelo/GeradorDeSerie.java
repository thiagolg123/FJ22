package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GeradorDeSerie {

	public static SerieTemporal criaSerie(double... valores) {
		List<Candlestick> candles = new ArrayList<Candlestick>();
		for (double d : valores) {
			candles.add(new Candlestick(d, d, d, d, 1000, Calendar
					.getInstance()));
		}
		return new SerieTemporal(candles);

	}

}
