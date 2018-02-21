
package it.uniroma1.lcl.mynn;

import it.uniroma1.lcl.funzioniAttivazione.Fa;

public class Neurone 
{
	protected double[] val;
	protected double treshO;
	private double out;
	/*costruttore neurone*/
	public Neurone(double[] val)
	{

		double[] val1 = new double[val.length-1];
		for(int i=0; i<val.length-1;i++)
		{
			
			val1[i]=val[i];
		}
		this.val=val1;
		treshO=val[val.length-1];

	}
	/*funzione del neurone che ritorna un Double*/
	public Double esegui(double[] input)
	{
		out=0.0;
		for(int i=0; i<input.length; i++)
		{
			out+=(input[i]*val[i]);
		}
		System.out.println("input :"+input[0]+" valore :"+ val[0]+" tresh OLD "+treshO);
		double out1 = out+treshO;
		System.out.println("out Neurone -->"+out1);
		return out+treshO;
	}
	public void setV(double v)
	{
		val[0]=v;
	}
	public void setT(double t)
	{
		treshO=t;
	}
	public double getV()
	{
		return val[0];
	}
	public double getT()
	{
		return treshO;
	}
}
