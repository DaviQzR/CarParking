package Controller;

import java.util.concurrent.Semaphore;

public class Carro extends Thread
{
	private int idcarro;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo; 
	public Carro (int idcarro, Semaphore semaforo)
	{
		this.idcarro = idcarro;
		this.semaforo= semaforo;
	}
	public void run ()
	{
		CarroAndando();
		//----> Inicío da seção critica <----
		try
		{
			semaforo.acquire();
			CarroEstacionando();
		}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			 finally
			 {
				 semaforo.release();
			 }
			 //----> Fim seção critica <----
				CarroSaindo();
	   }
	private void CarroAndando()
	{
		int DistanciaTotal =(int)((Math.random()*1001)+1000);
		int DistanciaPercorrida = 0;
		int Deslocamento=100;
		int Tempo = 1000;
		while(DistanciaPercorrida < DistanciaTotal)
		{
			DistanciaPercorrida += Deslocamento;
			try
			{
				Thread.sleep(Tempo);
			}catch(InterruptedException e)
			  {
				e.printStackTrace();
			  }
			System.out.println("#" + idcarro+ " ja andou " + DistanciaPercorrida+ " m.");
		}
		posChegada++;
		System.out.println("# "+idcarro +"Foi o " + posChegada + "° a chegar ");
	}
	private void CarroEstacionando()
	{
		System.out.println("#" + idcarro + " Estacionou");
		int tempo = (int)((Math.random()*2001)+1000);
		try
		{
			Thread.sleep(tempo);
		}catch(InterruptedException e)
		  {
			e.printStackTrace();
		  }
	}
	private void CarroSaindo()
	{
		posSaida++;
		System.out.println("#" + idcarro + "Foi o " + posSaida +"°. a sair");
	}
}
	


