package it.uniroma1.lcl.mynn.dummy;

import it.uniroma1.lcl.mynn.IReteNeurale;

public class DummyReteOr implements IReteNeurale {

	@Override
	public double[] process(double[] values) {
		return new double[]{(values[0] < 0.5 && values[1] < 0.5)?0.0:1.0};
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
		return "ReteOr";
	}
	
	@Override
	public String toString() {
		return "nome=ReteOr\nlayer={ nome=layer activationFunction=Step inputUnits=2 outputUnits=1 weights=[[1,1,-0.5]] }";
	}

}
