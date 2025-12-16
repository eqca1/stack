package e;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class U2 {

	static Stack<Integer> laimigSk = new Stack<>();
	
	private static Date pedejIzlozesLaiks = null;
	public static void main(String[]args) {
		
		String izvele;
		Stack<Integer> gameSteks = new Stack<>();
		
		String[] darb = {"Veikt izlozi", "Apskatīt laimīgos skaitļus", "Apturēt"};
		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Izvēlies darbību~", "Loterijas sistēma", 
					JOptionPane.QUESTION_MESSAGE, null, darb, darb[0]);
			if(izvele == null) izvele = "Apturēt";
			switch(izvele) {
			case "Veikt izlozi": 
				Date tagad = new Date();
				if(pedejIzlozesLaiks != null) {
					long starpibaMS = tagad.getTime() - pedejIzlozesLaiks.getTime();
					if(starpibaMS < 60000) {
						long palikusSek = (60000 - starpibaMS) / 1000;
						JOptionPane.showMessageDialog(null, "Izlozi var atkārtot tikai pēc "+palikusSek+" sek~", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
						break;
					}
				}
				laimigSk.clear();
				Random rand = new Random();
				
				for(int i=0; i<3; i++){
					Stack<Integer> bumbSteks = new Stack<>();
					for(int j=0; j<10; j++) {
						bumbSteks.push(rand.nextInt(10));
					}
					int laimigaisSk = bumbSteks.pop();
					laimigSk.push(laimigaisSk);
				}
				
				pedejIzlozesLaiks = tagad;
				JOptionPane.showMessageDialog(null, "Izloze veiksmīgi pabeigta~", "Veikmse", JOptionPane.INFORMATION_MESSAGE);
			break;
			case "Apskatīt laimīgos skaitļus":
				
				if(laimigSk.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Izloze vēl nav veikta~", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
					break;
				}
				SimpleDateFormat formats = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
				String laiksStr = formats.format(pedejIzlozesLaiks);
				
				String rez = "Izlozes laiks: "+ laiksStr + "~\nLaimīgie skaitli: " + laimigSk.toString()+"~";
				JOptionPane.showMessageDialog(null, rez, "Rezultats", JOptionPane.INFORMATION_MESSAGE);
			break;
			
			case "Apturēt":
				JOptionPane.showMessageDialog(null, "Programma apturēta~", "Izeja", JOptionPane.PLAIN_MESSAGE);
			break;
			default: izvele = "Apturēt";
			}
			
		}while(izvele != "Apturēt");
		
	}
}

