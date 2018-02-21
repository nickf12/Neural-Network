package it.uniroma1.lcl.funzioniAttivazione;

public class TanH implements Fa{

	@Override
	public double esegui(double d) {
		
		return Math.tanh(d);
	}

	@Override
	public double derivata(double d) {
		// TODO Auto-generated method stub
		return 1-Math.pow(esegui(d), 2);
	}

}
