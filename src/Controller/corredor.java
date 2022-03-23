package Controller;

import java.util.concurrent.Semaphore;

public class corredor extends Thread {
	
	private Semaphore semaforo;
	private int idthread;
	static int Colocacao = 0;
	int DT;
	int DP = 0;
	int per;
	
	
	public corredor (int idthread, int DT, Semaphore semaforo) {
		this.idthread = idthread;
		this.semaforo = semaforo;
		this.DT = DT;
	}
	
		public void Situação() {
			System.out.println("O User #" + idthread + " andou " + per + " cm" + "\t e já percorreu: " + DP + " cm");   
		}
		
		public void Andando() {
			
			per = (int) ((int) ((Math.random()*2.5)+4));
			DP += per; 
			if (DP > DT) { 
				DP = DT;	
		}
		}
				
		public void run () {
			while (DP < DT) {
				Situação();
				Andando();
			}
			if (DP >= DT) {
				AbrirPorta();
				try {
					sleep (100);	
					}catch (InterruptedException e) {}
	
				} 
			
		}
		
		public void AbrirPorta() {
			Colocacao++;
			System.out.println("O user #" + idthread + " foi o " + Colocacao + "º colocado a chegar em " + DP + "m" + "\t e chegou na porta");
			try {
			int t = 0;
			sleep(t);
			t = (int) ((int) ((Math.random()*1)+1));
				semaforo.acquire();
				System.out.println("O user #" + idthread + " Atravessar a porta!");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
				
			}

			}
}




