package it.uniroma1.lcl.mynn.dummy;

import it.uniroma1.lcl.mynn.IReteNeurale;

public class DummyReteSquared implements IReteNeurale {

	@Override
	public double[] process(double[] values) {
		return new double[]{Math.pow(values[0], 2)};
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
		return "ReteSquared";
	}
	
	@Override
	public String toString() {
		return "";
	}

}
