package it.uniroma1.lcl.mynn.dummy;

import it.uniroma1.lcl.mynn.IReteNeurale;

public class DummyReteSum implements IReteNeurale {

	@Override
	public double[] process(double[] values) {
		double out = values[0] + values[1];
		return new double[]{(out<1)?0:1,(out<1)?1:0};
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
		return "ReteSum";
	}
	
	@Override
	public String toString() {
		return "";
	}

}
