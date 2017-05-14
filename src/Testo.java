
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
	
	public static void main (String[][] args) {
		for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tttbrd[i][j] = ' ';
            }
        }
		wlcmMSG();
		while(!winCheck()) {
			crdPCK();
		}
		}

		public static void wlcmMSG() {
				System.out.println("WELCOME TO TICTACTOE\n ________\nRULES:\nGET A PARTNER AND PICK A COORDINATE\n ON THE BOARD WHERE YOU WOULD LIKE "
					+ "TO PLACE AN 'X' OR AN 'O'.\n THE FIRST PERSON TO LINE UP THEIR RESPECTIVE SYMBOL\n IN A HORIZONTAL, VERTICAL OR DIAGONAL"
					+ "LINE WINS\n________ \nGOOD LUCK");
			
		}
		public static void crdPCK (){
			boolean boo = false;
				System.out.println("\n\n\nTHIS IS YOUR BOARD");
				brdPRNT();
				System.out.println("PLEASE SELECT A SET OF COORDINATES WHERE YOU WOULD LIKE YOUR\nSYMBOL TO BE PLACED\n______\n"
						+ "please use a space or comma in between numbers\n for example: 2,2 or 2 2");
				while(!boo){
					String input = sc.nextLine();
					//checks to see if they wrote something readable
					if (input.length() == 2) {
						int crdX = Character.getNumericValue(input.charAt(0));
						int crdY = Character.getNumericValue(input.charAt(2));
							//if statement where all the conditions are met	
							if ( crdX > -1 && crdX < 3 && crdY < 3 && crdY < 3) {
									if (i % 2 == 0) {
										tttbrd[crdX][crdY] = 'X';
									}
									else {
										tttbrd[crdX][crdY] = 'O';
									}
									boo = true;
									i++;
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
				brdPRNT();
				
		}
		public static void brdPRNT() {
	        System.out.println(" 1 2 3");
	        System.out.println("A" + tttbrd[0][0] + "|" + tttbrd[0][1] + "|"
	                + tttbrd[0][2]);
	        System.out.println("-----");
	        System.out.println("B" + tttbrd[1][0] + "|" + tttbrd[1][1] + "|"
	                + tttbrd[1][2]);
	        System.out.println("-----");
	        System.out.println("C" + tttbrd[2][0] + "|" + tttbrd[2][1] + "|"
	                + tttbrd[2][2]);
		}

		public static boolean winCheck() {
			return false;
			//needs to be implemented, this method will check to see if someone won
		}
}