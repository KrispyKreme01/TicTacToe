
import java.util.Scanner;

/*
 * CHANGELOG
 * +wlcMSG() : displays the welcome message and rules
 * +crdPCK() : allows the players to pick coordinates {
 * CHECKS FOR ALL ERRORS, USES WHILE LOOP AND BOOLEAN FLAG TO LOOP UNTIL IT THE CONDITIONS ARE MET
 * +winCheck() : not working yet at all
 */
public class Testo {
	public static char tttbrd[][] = new char[3][3];
	public static Scanner sc = new Scanner(System.in);
	public static int i = 1;
	public static boolean turn = false;
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tttbrd[i][j] = ' ';
            }
        }
		wlcmMSG();
		while(!winCheck() || !tieCheck()) {
			crdPCK();
			i++;
		}
		if (tieCheck()) {
			System.out.println("issa tie");
			System.exit(1);
		}
		else if (turn) {
			System.out.println("X WINS");
			System.exit(1);
		}
		else {
			System.out.println("O WINS");
			System.exit(1);
		}
	}

		public static void wlcmMSG() {
				System.out.println("WELCOME TO TICTACTOE\n _________________\nRULES:\nGET A PARTNER AND PICK A COORDINATE\n ON THE BOARD WHERE YOU WOULD LIKE "
					+ "TO PLACE AN 'X'\n OR AN 'O'. THE FIRST PERSON TO LINE\n UP THEIR RESPECTIVE SYMBOL IN A HORIZONTAL,\n VERTICAL OR DIAGONAL"
					+ "LINE WINS\n________________ \nGOOD LUCK");
			
		}
		public static void crdPCK (){
			boolean boo = false;
			
				System.out.println("\n\n\nTHIS IS YOUR BOARD");
				brdPRNT();
				System.out.println("PLEASE SELECT A SET OF COORDINATES\n WHERE YOU WOULD LIKE YOUR\nSYMBOL TO BE PLACED\n_______________\n"
						+ "please use a space or comma in between numbers\n for example: 2,2 or 2 2");
				while(!boo){
					String input = sc.nextLine();
					//checks to see if they wrote something readable
					if (input.length() == 3 /*&& input.length() > -1*/) {
						int crdX = Character.getNumericValue(input.charAt(0));
						int crdY = Character.getNumericValue(input.charAt(2));
						crdX--;
						crdY--;
							//if statement where all the conditions are met	
							if ( crdX > -1 && crdX < 3 && crdY < 3 && crdY < 3) {
								if (tttbrd[crdX][crdY] != 'X' && tttbrd[crdX][crdY] != 'O') {
									if (i % 2 == 0) {
										tttbrd[crdX][crdY] = 'X';
										turn = true;
										boo = true;
									}
									else {
										tttbrd[crdX][crdY] = 'O';
										turn = false;
										boo = true;
									}
								}
								else {
									System.out.println("A USER HAS ALREADY SELECTED THAT COORDINATE,\nPLEASE TRY AGAIN");
									boo = false;
								}
							}
						//out of bounds else statement
						else {
							System.out.println("YOUR INPUT WAS NOT IN THE BOUNDS OF YOUR BOARD, PLEASE TRY AGAIN");
							boo = false;
						}
					}
					//invalid input else statement
					else {
						System.out.println("THAT INPUT WAS INVALID PLEASE PUT INPUT IN AGAIN");
						boo = false;
					}
				}
				
				
		}
		public static void brdPRNT() {
	        
	        System.out.println("     " +tttbrd[0][0] + "\t|" + "   " +tttbrd[0][1] + "\t|"
	        		+"   "+ tttbrd[0][2]);
	        System.out.println("    __________________\n");
	        System.out.println("    " +tttbrd[1][0] + "\t|" + "   " +tttbrd[1][1] + "\t|"
	        		+"   "+ tttbrd[1][2]);
	        System.out.println("    __________________\n");
	        System.out.println("    " +tttbrd[2][0] + "\t|" + "   " +tttbrd[2][1] + "\t|"
	        		+"   " + tttbrd[2][2]);
		}

		public static boolean winCheck() {
			
				//checks columns
					if (tttbrd[0][0]== 'X' && tttbrd[0][1]== 'X' && tttbrd[0][2] =='X' || tttbrd[0][0]== 'O' && tttbrd[0][1]== 'O' && tttbrd[0][2] =='O') {
						return true;
					}
					else if (tttbrd[1][0]== 'X' && tttbrd[1][1]== 'X' && tttbrd[1][2] == 'X' || tttbrd[1][0]== 'O' && tttbrd[1][1]== 'O' && tttbrd[1][2] == 'O') {
						return true;
					}
					else if (tttbrd[2][0]== 'X' && tttbrd[2][1]== 'X' && tttbrd[2][2] == 'X' || tttbrd[2][0]== 'O' && tttbrd[2][1]== 'O' && tttbrd[2][2] == 'O') {
						return true;
					}
				//checks rows
					else if (tttbrd[0][0]== 'X' && tttbrd[1][0]== 'X' && tttbrd[2][0] =='X' || tttbrd[0][0]== 'O' && tttbrd[1][0]== 'O' && tttbrd[2][0] =='O') {
						return true;
					}
					else if (tttbrd[0][1]== 'X' && tttbrd[1][1]== 'X' && tttbrd[2][1] =='X' || tttbrd[0][1]== 'O' && tttbrd[1][1]== 'O' && tttbrd[2][1] =='O') {
						return true;				
					}
					else if (tttbrd[0][2]== 'X' && tttbrd[1][2]== 'X' && tttbrd[2][2] =='X' || tttbrd[0][2]== 'O' && tttbrd[1][2]== 'O' && tttbrd[2][2] =='O') {
						return true;
					}
				//checks diagonal and anti-diagonal
					else if (tttbrd[0][0]== 'X' && tttbrd[1][1]== 'X' && tttbrd[2][2] =='X' || tttbrd[0][0]== 'O' && tttbrd[1][1]== 'O' && tttbrd[2][2] =='O') {
						return true;
					}
					else if (tttbrd[0][2]== 'X' && tttbrd[1][1]== 'X' && tttbrd[2][0] =='X' || tttbrd[0][2]== 'O' && tttbrd[1][1]== 'O' && tttbrd[2][0] =='O') {
						return true;
					}
					else {
						return false;
					}
			
			//needs to be implemented, this method will check to see if someone won
		}
		public static boolean tieCheck() {
			boolean flag = false;
			for (int l = 0; l < 3; l++) {
				for (int k = 0; k < 3; k++ ) {
					if (tttbrd[l][k] == 'X' || tttbrd[l][k] == 'O' ) {
						flag = true;
					}
				}
			}
			if (flag) { 
				return false;
		}
			else{
				return true;
			}
		}
}