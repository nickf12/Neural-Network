package it.uniroma1.lcl.funzioniAttivazione;

public class Logistic implements Fa
{

	@Override
	public double esegui(double d) {
		// TODO Auto-generated method stub
		return 1/(1+(Math.pow(2.718, -d)));
	}

	@Override
	public double derivata(double d) {
		// TODO Auto-generated method stub
		return esegui(d)*(1-esegui(d));
	}

}
