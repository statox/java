package chess;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

public class testAffichage {

	public static void main(String[] args){
		
		System.out.println("CACA");
		
		Terminal terminal = TerminalFacade.createTerminal();
		
		terminal.enterPrivateMode();
		
//		terminal.moveCursor(3, 3);
//		terminal.putCharacter('H');
//		terminal.putCharacter('E');
//		terminal.putCharacter('Y');
//		
//		Key pressedKey;
//		char k='a';
//		int x=0;
//		int y=0;
//		terminal.moveCursor(y, x);
//		do{
//			k++;
//			if (k=='z'){
//				k='a';
//				y+=27;
//				if (y>90){
//					x++;
//					y=0;
//				}
//				terminal.moveCursor(y, x);
//			}
//	
//			terminal.putCharacter(k);
//			
//		}while (k<100000);
		
		int k=0;
		
		terminal.moveCursor(0, 0);
		terminal.putCharacter('H');
		
		while (k<50){
			k++;
			System.out.println(terminal.readInput().getKind());
		}
		
		
		terminal.exitPrivateMode();


	}
}