package it.uniroma1.lcl.mynn;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestReteNeuraleQualsiasiFunzione2 {
	@Test
	public void testTrain() throws IOException {
		try {
			
			double[][] inputs = {
					{0.0, 0.0, 0.0},
					{0.0, 0.0, 1.0},
					{0.0, 1.0, 0.0},
					{0.0, 1.0, 1.0},
					{1.0, 0.0, 0.0},
					{1.0, 0.0, 1.0},
					{1.0, 1.0, 0.0},
					{1.0, 1.0, 1.0},
					};
			double[][] output = {
					{0,0},
					{0,0},
					{1,0},
					{1,0},
					{0,0},
					{0,0},
					{0,0},
					{0,1}
				};
				
			IReteNeurale rete = IReteNeurale.carica(new File(".").getCanonicalPath() + "/reteSum2");
		
			rete.train(inputs, output);
					 
			System.out.println();

			System.out.println();

			double[] out1 = rete.process(new double[]{0.0,0.0,0.0});
			System.out.println(out1[0]);
			System.out.println(out1[1]);

			Assert.assertTrue(Math.abs(    out1[0]) < 0.1);
			Assert.assertTrue(Math.abs(	   out1[1]) < 0.1);
			
			double[] out2 = rete.process(new double[]{0.0,1.0,1.0});
			
			System.out.println(out2[0]);
			System.out.println(out2[1]);
			
			Assert.assertTrue(Math.abs(1 - out2[0]) < 0.1);
			Assert.assertTrue(Math.abs(    out2[1]) < 0.1);
			
			double[] out3 = rete.process(new double[]{1.0,1.0,1.0});
			
			System.out.println(out3[0]);
			System.out.println(out3[1]);
			
			Assert.assertTrue(Math.abs(	   out3[0]) < 0.1);
			Assert.assertTrue(Math.abs(1 - out3[1]) < 0.1);
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
