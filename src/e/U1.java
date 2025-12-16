package e;

import java.util.Stack;

import javax.swing.JOptionPane;

public class U1 {


		public static void main(String[]args) {
		String izvele, vards = "";
		Stack<String> stak = new Stack<>();
		String[] darb = {"Ievadīt vārdu", "Noteikt vārda garumu", "Apskatīt pēdējo burtu", "Apgriezt vārdu", "Apturēt"};
		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Izvēlies darbību~", "Izvelne", 
					JOptionPane.QUESTION_MESSAGE, null, darb, darb[0]);
			if(izvele == null) izvele = "Apturēt";
			switch(izvele) {
			case "Ievadīt vārdu":
				if(stak.isEmpty()) {
					do {
				vards = JOptionPane.showInputDialog(null, "Ievadiet vārdu~", "~Ievadīt vārdu", JOptionPane.PLAIN_MESSAGE);
				if(izvele == null) break;
					}while(vards.contains(" "));
					if(izvele == null) break;

					for(int i=0; i<vards.length(); i++) {
						stak.push(Character.toString(vards.charAt(i)));
					}
				}else JOptionPane.showMessageDialog(null, "Viens vārds jau ir sarakstā.", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
			break;
			case "Noteikt vārda garumu":
				if(!stak.isEmpty()) {
					
				JOptionPane.showMessageDialog(null, "Vārdu garums ir "+stak.size()+" simboli.", "~Noteikt vārda garumu", JOptionPane.INFORMATION_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "Steks ir tukšs.", "Brīdinājums", JOptionPane.WARNING_MESSAGE);

			break;
			case "Apskatīt pēdējo burtu":
				if(!stak.isEmpty()) {

				JOptionPane.showMessageDialog(null, "Vārda pēdējais burts ir \""+stak.peek()+"\"!", "~Apskatīt pēdējo burtu", JOptionPane.INFORMATION_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "Steks ir tukšs.", "Brīdinājums", JOptionPane.WARNING_MESSAGE);

			break;
			case "Apgriezt vārdu":
				if(!stak.isEmpty()) {
					int gar = stak.size();
					for(int i=0; i<gar; i++) {
						vards += stak.pop();
					}
				JOptionPane.showMessageDialog(null, "Apgriezsts vārds ir \""+vards+"\"!", "~Apgriezt vārdu", JOptionPane.INFORMATION_MESSAGE);
			}else JOptionPane.showMessageDialog(null, "Steks ir tukšs.", "Brīdinājums", JOptionPane.WARNING_MESSAGE);

			break;
			case "Apturēt":
				JOptionPane.showMessageDialog(null, "Programma apturēta", "Izeja", JOptionPane.PLAIN_MESSAGE);
			break;
			default: izvele = "Apturēt";
			}
			
		}while(izvele != "Apturēt");
		
	}

}
