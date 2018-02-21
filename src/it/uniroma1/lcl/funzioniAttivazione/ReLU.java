package it.uniroma1.lcl.funzioniAttivazione;

public class ReLU implements Fa
{

	@Override
	public double esegui(double d) {
		return d<0 ? 0 : d;
	}

	@Override
	public double derivata(double d) {
		// TODO Auto-generated method stub
		return d<0 ? 0: 1;
	}
}
