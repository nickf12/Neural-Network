package it.uniroma1.lcl.mynn;

import java.util.Set;
import java.util.stream.Stream;

import it.uniroma1.lcl.funzioniAttivazione.Fa;

public class StratoDiNeuroni 
{
	protected Set<Neurone> s;
	private String name;
	protected Fa fAtt;
	private int iU;
	private int oU;
	private String pesi;
	/*Costruttore degli strati della rete*/
	public StratoDiNeuroni(Set<Neurone> s, String name, Fa fAtt, int iU, int oU, String pesi)
	{
		this.s=s;
		this.name=name;
		this.fAtt=fAtt;
		this.iU=iU;
		this.pesi=pesi;
		this.oU=oU;
	}
	/*funzione degli strati con java8*/
	public double[] esegui(double[] input)
	{
		Stream<Double> ss= s.stream().map(s->fAtt.esegui(s.esegui(input)));
		double[] ff = ss.mapToDouble(Double::doubleValue).toArray();
		return ff;
	}
	/*toString strati*/
	public String toString()
	{
		return "layer={ nome="
				+name
				+" activationFunction="
				+fAtt.getClass().getSimpleName()
				+" inputUnits="
				+iU+" outputUnits="
				+oU+" weights=[["
				+pesi+"]] }";
	}
}
