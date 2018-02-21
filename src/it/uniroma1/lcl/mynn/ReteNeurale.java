package it.uniroma1.lcl.mynn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ReteNeurale implements IReteNeurale
{
	private String nome;
	private ArrayList<StratoDiNeuroni> sDN;

	/*Costruttore reteNeurale*/
	public ReteNeurale(String nome, ArrayList<StratoDiNeuroni> sDN)
	{
		this.nome=nome;
		this.sDN=sDN;
	}
	
	/*costruttore ReteNeurale senza parametri*/
	public ReteNeurale() {}
	
	/*Process Rete Neurale*/
	@Override
	public double[] process(double[] values)
	{
		
		double[] input=values;
		double[] out;
		for(StratoDiNeuroni s: sDN)
		{
			out=s.esegui(input);
			input=out;
		}		
		return input;
	
	}
	public double trainInstanzia(double[] values, double[] output)
	{
		double errore = output[0]-process(values)[0];
		for(Neurone s: sDN.get(0).s)
		{
			System.out.println("errore --->"+ errore);
			
			System.out.println("tresh prima -->"+s.getT());
			System.out.println("valore prima-->"+s.getV());
			s.setV(s.getV()+0.01*(errore)*values[0]);
			s.setT(s.getT()+0.01*(errore));
			System.out.println("tresh dopo -->"+s.getT());
			System.out.println("valore dopo-->"+s.getV());
		}
		return Math.abs(errore);
	}
	/*Train Istanza*/
	@Override
	public double trainIstanza(double[] values, double[] output) 
	{
		double[] process = process(values);
		double errore = output[0]-process(values)[0];
		double errore2;
		if(output.length>1)
		{
			errore2 = output[1]-process(values)[1];			
			for(Neurone n: sDN.get(0).s)
			{
		
				n.val[0] = n.val[0]+0.01*(errore)*values[0];
				if(n.val.length>1)
				{
					n.val[1]=n.val[1]+0.01*(errore)*values[1];
				}
				n.treshO = n.treshO+0.01*(errore);
			}
			for(Neurone n: sDN.get(0).s)
			{
		
				n.val[0] = n.val[0]+0.01*(errore2)*values[0];
				if(n.val.length>1)
				{
					n.val[1]=n.val[1]+0.01*(errore2)*values[1];
				}
				n.treshO = n.treshO+0.01*(errore2);
			}
			return Math.abs(errore+errore2);
		}
		else
		{
			for(Neurone n: sDN.get(0).s)
			{
		
				n.val[0] = n.val[0]+0.01*(errore)*values[0];
				if(n.val.length>1)
				{
					n.val[1]=n.val[1]+0.01*(errore)*values[1];
				}
				n.treshO = n.treshO+0.01*(errore);
			}
			
		}
		return Math.abs(errore);
	}
	
	
	/*Train della rete perception*/
	@Override
	public void train(double[][] inputs, double[][] outputs) 
	{
		
		// TODO Auto-generated method stub
		double somma_errori;
		do
		{
			
			somma_errori=0.0;
			for(int i=0; i<inputs.length; i++)
			{
				somma_errori+=trainIstanza(inputs[i], outputs[i]);	

				System.out.println("somma errori parziale indice "+i+" somma->"+somma_errori);
			
			}
			System.out.println("Train somma errori finale-->"+somma_errori);
			
		}
		while(somma_errori>0.01);	
	}
	
	/*Funzione di aggiornamento pesi per le reti neurali a uno strato con qualsiasi tipo di funzione di attivazione
	 * da finire.....*/
	public void modificaPesiOneLayer(double[][] inputs, double[][] outputs)
	{
		for(Neurone n:sDN.get(0).s)
		{
			for(int i=0; i< inputs.length; i++)
			{
				for(int j=0; j<n.val.length; j++)
				{
					double[] in=new double[1];
					in[0]=inputs[i][0];
					//aggiornamento dei pesi
					n.val[j]=n.val[j]+0.01
							*(outputs[i][0]-process(in)[0])
							*sDN.get(0).fAtt.derivata(n.esegui(in))*inputs[i][0];
					//aggiornamento del treshOld
					n.treshO=n.treshO+0.01*(outputs[i][0] - process(in)[0])
							*sDN.get(0).fAtt.derivata(n.esegui(in))*inputs[i][0];
				}
			}
		}
	}
	
	/*getNome, serve per il toString della rete*/
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}
	
	/*toString della reteNeurale*/
	public String toString()
	{
		String s="nome="+nome+"\n";		
		for(StratoDiNeuroni ss: sDN)
		{
			if(sDN.indexOf(ss)+1==sDN.size()) s+=ss.toString();
			else s+=ss.toString()+"\n";}
		return s;
	}
}
