package View;

import java.util.concurrent.Semaphore;
import Controller.corredor;

public class Main {
static int DT = 200;	

	public static void main(String[] args) {
		
 Semaphore semaforo = new Semaphore (1);
 
 for (int idthread = 1; idthread <= 4; idthread++) {
	 new corredor (idthread, DT, semaforo).start();
 }
	}

}
