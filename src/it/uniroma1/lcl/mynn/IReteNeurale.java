package it.uniroma1.lcl.mynn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import it.uniroma1.lcl.funzioniAttivazione.Fa;

public interface IReteNeurale {
	
	
	public double[] process(double[] values);
	public double trainIstanza(double[] values, double output[]);
	public void train(double[][] inputs, double[][] outputs);
	
	public String getNome();
	
	/*funzione che mi crea un array di double(weights) da una stringa*/
	static ArrayList<double[]> pesi(String s)
	{
		
		ArrayList<double[]> aD= new ArrayList<double[]>();
		
		String[] com= s.split("\\],\\[");
		for(String ss: com)
		{
			double[] com2=new double[ss.split(",").length]; 
			int cnt=0;
			for(String sss: ss.split(",")) com2[cnt++]=Double.parseDouble(sss);
			
			aD.add(com2);			
		}
		return aD;
	}
	
	
	public static IReteNeurale carica(String filename) 
	{	
		ArrayList<Neurone> aN;
		ReteNeurale rN=new ReteNeurale();
		ArrayList<String> linee= new ArrayList<>();
		Random ran= new Random();
		Set<Neurone> insieme;
		ArrayList<StratoDiNeuroni> layer= new ArrayList<StratoDiNeuroni>();
		try
		{
			/*da file carico la rete */
			ArrayList<String> com= new ArrayList<>();
			Files.newBufferedReader(Paths.get(filename)).lines().forEach(l->{com.add(l);});
			
			com.stream().forEach(i->
								{if(com.indexOf(i)!=0)
									linee.add(i);
								});
			
			/*for sulle linee e quindi sui layer della Rete*/
			for(String s1:linee)
			{
				double[] weights=new double[0];
				insieme= new HashSet<Neurone>();
				aN= new ArrayList<Neurone>();
				/*layer splittato per spazi*/
				String[] temp=s1.substring(linee.get(linee.indexOf(s1)).indexOf("n"), linee.get(0).indexOf("}")).split(" ");
				/*controllo se ci sono i pesi*/
				if(s1.contains("weights"))
				{						
					/*Parse dei pesi in double e creazione dei neuroni*/
					for(double[] d:pesi(s1.substring(s1.indexOf("[[")+2, s1.indexOf("]]"))))
					{	
						
						weights=new double[Integer.parseInt(temp[2].substring(temp[2].indexOf("=")+1, temp[2].length()))+1];
						int cnt=0;
						for(double dd:d)
						{
							weights[cnt]=dd;
							cnt++;
						}
						
						aN.add(new Neurone(weights));
						
					}
					for(int i=aN.size()-1; i>=0; i--)
					{
						insieme.add(aN.get(i));
					}
				}
				/*pesi non presenti creo random*/
				else
				{
					for(int i=0; i<Integer.parseInt(temp[3].substring(temp[3].indexOf("=")+1, temp[3].length())); i++)
					{
						weights=new double[Integer.parseInt(temp[2].substring(temp[2].indexOf("=")+1, temp[2].length()))+1];
						for(int j=0; j<Integer.parseInt(temp[2].substring(temp[2].indexOf("=")+1, temp[2].length()))+1; j++) weights[j]=ran.nextDouble();
						insieme.add(new Neurone(weights));
						System.out.println("Interfaccia----->");
						System.out.println("valore creato random :>"+weights[0]+" tresh Old creato random-->"+weights[1]);
						
					}
				}
				String sWeights="";				
				if(temp.length==5)
				{
				/*Creazione degli strati della rete*/
				Class<?> c=Class.forName("it.uniroma1.lcl.funzioniAttivazione."+temp[1].substring(temp[1].indexOf("=")+1, temp[1].length()));
				Class<? extends Fa> ca= c.asSubclass(Fa.class);
				layer.add(new StratoDiNeuroni(insieme,
											temp[0].substring(temp[0].indexOf("=")+1, temp[0].length()),
											ca.getConstructor().newInstance(),Integer.parseInt(temp[2].substring(temp[2].indexOf("=")+1, temp[2].length())),
											Integer.parseInt(temp[3].substring(temp[3].indexOf("=")+1, temp[3].length())),
											temp[4].substring(temp[4].indexOf("[[")+2, temp[4].indexOf("]]"))));
					}
				else
				{
					int cc=1;
					for(double d1:weights)
					{
						if(cc==weights.length)
							sWeights+=d1;
						else sWeights+=d1+",";
						cc++;
					}
					/*Creazione degli strati della rete*/
					Class<?> c=Class.forName("it.uniroma1.lcl.funzioniAttivazione."+temp[1].substring(temp[1].indexOf("=")+1, temp[1].length()));
					Class<? extends Fa> ca= c.asSubclass(Fa.class);
					layer.add(new StratoDiNeuroni(insieme,
												temp[0].substring(temp[0].indexOf("=")+1, temp[0].length()),
												ca.getConstructor().newInstance(),Integer.parseInt(temp[2].substring(temp[2].indexOf("=")+1, temp[2].length())),
												Integer.parseInt(temp[3].substring(temp[3].indexOf("=")+1, temp[3].length())),
												sWeights));
				}
			}
			/*Creazione della Rete Neurale*/
			rN= new ReteNeurale(com.get(0).substring(com.get(0).indexOf("=")+1, 
						com.get(0).length()), layer);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rN;
	}
}