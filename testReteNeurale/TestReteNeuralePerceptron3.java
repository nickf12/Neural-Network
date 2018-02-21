package it.uniroma1.lcl.mynn;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

public class TestReteNeuralePerceptron3 {
	
	@Test
	public void testTrain() throws IOException {
		try {
			
			double[][] inputs = {
					
					{0.9},
					{0.8},
					{0.7},
					
					{0.1},
					{0.2},
					{0.3},
					
					};
			double[][] outputs = {
				{0.0},
				{0.0},
				{0.0},
			
				{1.0},
				{1.0},
				{1.0},
				};
		
				
			IReteNeurale rete = IReteNeurale.carica(new File(".").getCanonicalPath() + "/retePercettrone");
		
			rete.train(inputs, outputs);
			System.out.println(rete.process(new double[]{0.0})[0]);
			System.out.println(rete.process(new double[]{1.0})[0]);
			
					 
			Assert.assertTrue(Math.abs(1 - rete.process(new double[]{0.0})[0]) < 0.01);
			Assert.assertTrue(Math.abs(    rete.process(new double[]{1.0})[0]) < 0.01);
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testTrain2() throws IOException {
		try {
			
			double[][] inputs = {
					
					{0.9},
					{0.8},
					{0.7},
					
					{0.1},
					{0.2},
					{0.3},
					
					};
			double[][] outputs = {
				{1.0},
				{1.0},
				{1.0},
			
				{0.0},
				{0.0},
				{0.0},
				};
		
				
			IReteNeurale rete = IReteNeurale.carica(new File(".").getCanonicalPath() + "/retePercettrone");
		
			rete.train(inputs, outputs);
			
			System.out.println("-----");
			System.out.println(rete.process(new double[]{0.0})[0]);
			System.out.println(rete.process(new double[]{1.0})[0]);
			
			Assert.assertTrue(Math.abs(    rete.process(new double[]{0.0})[0]) < 0.01);
			Assert.assertTrue(Math.abs(1 - rete.process(new double[]{1.0})[0]) < 0.01);
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
