package it.uniroma1.lcl.mynn;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

public class TestReteNeurale2 {
	

	@Test
	public void testTrain() throws IOException {
		try {
			
			// provare diversi learning rate. Con 0.2 e la struttura che ho dato funziona bene 

			double[][] inputs = {
					{0.0000},
{					0.0333},
{					0.0667},
{					0.1000},
{					0.1333},
{					0.1667},
{					0.2000},
{					0.2333},
{					0.2667},
{					0.3000},
{					0.3333},
{					0.3667},
{					0.4000},
{					0.4333},
{					0.4667},
{					0.5000},
{					0.5333},
{					0.5667},
{					0.6000},
{					0.6333},
{					0.6667},
{					0.7000},
{					0.7333},
{					0.7667},
{					0.8000},
{					0.8333},
{					0.8667},
{					0.9000},
{					0.9333},
{					0.9667},
{					1.0000}
					};
				
			double[][] outputs = {
					{-0.0700},
					{-0.0519},
					{-0.0366},
					{-0.0240},
					{-0.0139},
					{-0.0059},
					{0.0000},
					{0.0041},
					{0.0067},
					{0.0080},
					{0.0081},
					{0.0074},
					{0.0060},
					{0.0041},
					{0.0021},
					{0.0000},
					{-0.0019},
					{-0.0033},
					{-0.0040},
					{-0.0039},
					{-0.0026},
					{0.0000},
					{0.0041},
					{0.0101},
					{0.0180},
					{0.0281},
					{0.0407},
					{0.0560},
					{0.0741},
					{0.0954},
					{0.1200}
					};
			IReteNeurale rete = IReteNeurale.carica(new File(".").getCanonicalPath() + "/reteSquared3");
		
			rete.train(inputs, outputs);
			
			System.out.println(rete.process(new double[]{0.2})[0]);
			System.out.println(rete.process(new double[]{0.5})[0]);
			System.out.println(rete.process(new double[]{0.7})[0]);

					 
			Assert.assertTrue(Math.abs(rete.process(new double[]{0.2})[0]) < 0.01);
			Assert.assertTrue(Math.abs(rete.process(new double[]{0.5})[0]) < 0.01);			
			Assert.assertTrue(Math.abs(rete.process(new double[]{0.7})[0]) < 0.01);
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test
	public void testTrain2() throws IOException {
		try {
			
			// provare diversi learning rate. Con 0.2 e la struttura che ho dato funziona bene 
			double[][] inputs = {
					{0.479, 0.371},
					{0.128, 0.406},
					{0.157, 0.157},
					{0.275, 0.218},
					{0.835, 0.780},
					{0.855, 0.752},
					{0.785, 0.641},
					{0.876, 0.845},
					{0.812, 0.544},
					{0.332, 0.155},
					{0.258, 0.134},
					{0.233, 0.235},
					{0.297, 0.317},
					{0.883, 0.897},
					{0.858, 0.588},
					{0.238, 0.208},
					{0.268, 0.397},
					{0.326, 0.269},
					{0.759, 0.985},
					{0.795, 0.636},
					{0.849, 0.834},
					{0.752, 0.732},
					{0.794, 0.847},
					{0.782, 0.738},
					{0.898, 0.824},
					{0.828, 0.943},
					{0.170, 0.163},
					{0.373, 0.437},
					{0.195, 0.109},
					{0.175, 0.349},
					{0.166, 0.306},
					{0.319, 0.240},
					{0.379, 0.223},
					{0.323, 0.305},
					{0.141, 0.248},
					{0.734, 0.540},
					{0.678, 0.740},
					{0.749, 0.671},
					{0.660, 0.850},
					{0.804, 0.784}
					};
			double[][] output = {
					{0,1},
					{0,1},
					{0,1},
					{0,1},
					{1,0},
					{1,0},
					{1,0},
					{1,0},
					{1,0},
					{0,1},
					{0,1},
					{0,1},
					{0,1},
					{1,0},
					{1,0},
					{0,1},
					{0,1},
					{0,1},
					{1,0},
					{1,0},
					{1,0},
					{1,0},
					{1,0},
					{1,0},
					{1,0},
					{1,0},
					{0,1},
					{0,1},
					{0,1},
					{0,1},
					{0,1},
					{0,1},
					{0,1},
					{0,1},
					{0,1},
					{1,0},
					{1,0},
					{1,0},
					{1,0},
					{1,0}
				};
				
			IReteNeurale rete = IReteNeurale.carica(new File(".").getCanonicalPath() + "/reteSum_1");
		
			rete.train(inputs, output);
					 
			double[] out1 = rete.process(new double[]{0.25,0.25});
			System.out.println(out1[0]);
			System.out.println(out1[1]);

			Assert.assertTrue(Math.abs(    out1[0]) < 0.01);
			Assert.assertTrue(Math.abs(1 - out1[1]) < 0.01);
			
			double[] out2 = rete.process(new double[]{0.75,0.75});
			
			System.out.println(out2[0]);
			System.out.println(out2[1]);
			
			Assert.assertTrue(Math.abs(1 - out2[0]) < 0.01);
			Assert.assertTrue(Math.abs(    out2[1]) < 0.01);
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


}
