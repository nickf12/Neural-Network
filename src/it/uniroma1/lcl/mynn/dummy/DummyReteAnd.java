package it.uniroma1.lcl.mynn.dummy;

import it.uniroma1.lcl.mynn.IReteNeurale;

public class DummyReteAnd implements IReteNeurale {

	@Override
	public double[] process(double[] values) {
		return new double[] {(values[0] > 0.5 && values[1] > 0.5)?1.0:0.0};
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
		return "ReteAnd";
	}
	
	@Override
	public String toString() {
		return "nome=ReteAnd\nlayer={ nome=layer activationFunction=Step inputUnits=2 outputUnits=1 weights=[[1,1,-1.5]] }";
	}

}
