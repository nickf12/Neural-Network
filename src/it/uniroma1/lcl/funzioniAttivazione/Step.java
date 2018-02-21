package it.uniroma1.lcl.funzioniAttivazione;

public class Step implements Fa
{
	@Override
	public double esegui(double d) {
		return d<0 ? 0: 1;
	}

	@Override
	public double derivata(double d) {
		// TODO Auto-generated method stub
		return 0;
	}

}
