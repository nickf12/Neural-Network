package it.uniroma1.lcl.mynn;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

public class Testa 
{
	/**/
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
	
	/*
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
					
					};
			double[][] output = {
					{0},
					{0},
					{0},
					{0},
					{1},
					{1},
					{1},
					{1},
					{1},
					{0},
					{0},
					{0},
					{0},
					{1},
					{1},
					{0},
					{0},
					{0},
					{1},
					{1},
					{1},
					{1},
					{1},
					{1},
					{1},
					{1},
					
				};
				
			IReteNeurale rete = IReteNeurale.carica(new File(".").getCanonicalPath() + "/retePercettrone2");
		
			rete.train(inputs, output);
					 
			double[] out1 = rete.process(new double[]{0.25,0.25});
			System.out.println(out1[0]);
			System.out.println("out 1 : "+(out1[1]));

			Assert.assertTrue(Math.abs(    out1[0]) < 0.01);
			Assert.assertTrue(Math.abs(1 - out1[1]) < 0.01);
			
//			double[] out2 = rete.process(new double[]{0.75,0.75});
//			
//			System.out.println(out2[0]);
//			System.out.println(out2[1]);
//			
//			Assert.assertTrue(Math.abs(1 - out2[0]) < 0.01);
//			Assert.assertTrue(Math.abs(    out2[1]) < 0.01);
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	*/
	/*
	@Test
	public void testCaricaReteAnd() throws IOException {
		try {
			StringBuilder str = new StringBuilder();
			Files.newBufferedReader(Paths.get(new File(".").getCanonicalPath() + "/reteAnd")).lines().forEach(l -> {
				str.append(l);
				str.append("\n");
			});
			IReteNeurale rete = IReteNeurale.carica(new File(".").getCanonicalPath() + "/reteAnd");
			Assert.assertTrue(Math.abs(rete.process(new double[]{0.0,0.0})[0]) < 0.01);
			Assert.assertTrue(Math.abs(rete.process(new double[]{1.0,0.0})[0]) < 0.01);
			Assert.assertTrue(Math.abs(rete.process(new double[]{0.0,1.0})[0]) < 0.01);
			Assert.assertTrue(Math.abs(1.0 - rete.process(new double[]{1.0,1.0})[0]) < 0.01);
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testCaricaToStringAnd() throws IOException {
		try {
			StringBuilder str = new StringBuilder();
			Files.newBufferedReader(Paths.get(new File(".").getCanonicalPath() + "/reteAnd")).lines().forEach(l -> {
				str.append(l);
				str.append("\n");
			});
			IReteNeurale rete = IReteNeurale.carica(new File(".").getCanonicalPath() + "/reteAnd");
			
			Assert.assertEquals(str.toString().trim(), rete.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testCaricaNome() throws IOException {
		try {
			StringBuilder str = new StringBuilder();
			Files.newBufferedReader(Paths.get(new File(".").getCanonicalPath() + "/reteAnd")).lines().forEach(l -> {
				str.append(l);
				str.append("\n");
			});
			IReteNeurale rete = IReteNeurale.carica(new File(".").getCanonicalPath() + "/reteAnd");

			Assert.assertEquals("ReteAnd", rete.getNome());
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testCaricaReteOr() throws IOException {
		try {
			StringBuilder str = new StringBuilder();
			Files.newBufferedReader(Paths.get(new File(".").getCanonicalPath() + "/reteOr")).lines().forEach(l -> {
				str.append(l);
				str.append("\n");
			});
			IReteNeurale rete = IReteNeurale.carica(new File(".").getCanonicalPath() + "/reteOr");
			Assert.assertTrue(Math.abs(rete.process(new double[]{0.0,0.0})[0]) < 0.001);
			Assert.assertTrue(Math.abs(1.0 - rete.process(new double[]{1.0,0.0})[0]) < 0.01);
			Assert.assertTrue(Math.abs(1.0 -rete.process(new double[]{0.0,1.0})[0]) < 0.01);
			Assert.assertTrue(Math.abs(1.0 - rete.process(new double[]{1.0,1.0})[0]) < 0.01);
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testCaricaToStringOr() throws IOException {
		try {
			StringBuilder str = new StringBuilder();
			Files.newBufferedReader(Paths.get(new File(".").getCanonicalPath() + "/reteOr")).lines().forEach(l -> {
				str.append(l);
				str.append("\n");
			});
			IReteNeurale rete = IReteNeurale.carica(new File(".").getCanonicalPath() + "/reteOr");
			
			Assert.assertEquals(str.toString().trim(), rete.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testCaricaReteXor() throws IOException {
		try {
			StringBuilder str = new StringBuilder();
			Files.newBufferedReader(Paths.get(new File(".").getCanonicalPath() + "/reteXor")).lines().forEach(l -> {
				str.append(l);
				str.append("\n");
			});
			IReteNeurale rete = IReteNeurale.carica(new File(".").getCanonicalPath() + "/reteXor");
			Assert.assertTrue(Math.abs(rete.process(new double[]{0.0,0.0})[0]) < 0.001);
			Assert.assertTrue(Math.abs(1.0 - rete.process(new double[]{1.0,0.0})[0]) < 0.01);
			Assert.assertTrue(Math.abs(1.0 - rete.process(new double[]{0.0,1.0})[0]) < 0.01);
			Assert.assertTrue(Math.abs(rete.process(new double[]{1.0,1.0})[0]) < 0.01);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testTrain() throws IOException {
		try {
			
			double[][] inputs = {
					{1.0}, 
					{0.0}, 
					};
			double[][] outputs = {
				{0.0},
				{1.0},
				};
		
				
			IReteNeurale rete = IReteNeurale.carica(new File(".").getCanonicalPath() + "/retePercettrone");
		
			rete.train(inputs, outputs);
					 
			Assert.assertTrue(Math.abs(1 - rete.process(new double[]{0.0})[0]) < 0.01);
			Assert.assertTrue(Math.abs(    rete.process(new double[]{1.0})[0]) < 0.01);
		
		} 
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	*/
	
}
