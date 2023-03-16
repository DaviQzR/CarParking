package View;

import java.util.concurrent.Semaphore;

import Controller.Carro;

public class Estacionamento 
{

	public static void main(String[] args) 
	{
			int permissoes = 3;
			Semaphore semaforo = new Semaphore (permissoes);
			for( int idcarro =0; idcarro<10; idcarro++)
			{
				Thread tcarro = new Carro (idcarro, semaforo);
				tcarro.start();
			}
	}

}
