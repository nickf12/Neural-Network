package it.uniroma1.lcl.mynn.dummy;

import it.uniroma1.lcl.mynn.IReteNeurale;

public class DummyReteXor implements IReteNeurale {

	@Override
	public double[] process(double[] values) {
		return new double[]{((Math.abs(1-values[0]) < 0.001)^(Math.abs(1-values[1]) < 0.001))?1.0:0.0};
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
		return "ReteXor";
	}
	
	@Override
	public String toString() {
		return "nome=ReteXor\n"
				+ "layer={ nome=input activationFunction=Logistic inputUnits=2 outputUnits=2 weights=[[1,1,0],[2,2,0]] }\n"
				+ "layer={ nome=output activationFunction=Logistic inputUnits=2 outputUnits=1 weights=[[-1000,850,0]] }";
	}

}
