package it.uniroma1.lcl.mynn.dummy;

import it.uniroma1.lcl.mynn.IReteNeurale;

public class DummyRetePercettrone implements IReteNeurale {

	@Override
	public double[] process(double[] values) {
		return new double[]{Math.abs(1- values[0])};				
	}

	@Override
	public double trainIstanza(double[] values, double[] output) {
		return 0.0;
	}

	@Override
	public void train(double[][] listOfvalues, double[][] output) {
		//
	}

	@Override
	public String getNome() {
		return "RetePercettrone";
	}
	
	@Override
	public String toString() {
		return "";
	}

}
