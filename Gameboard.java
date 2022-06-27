import java.util.ArrayList;
import java.util.Scanner;

public class Gameboard {
	private int[] arr;
	
	public Gameboard() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i =0; i<9; i++) {
			temp.add(i);
		}
		int m = 8;
		arr = new int[9];
		for(int i =0; i<9; i++) {		
			arr[i] = temp.remove((int)(Math.random()*m));
			m--;
		}
		
	}
	public void switchNums(int moveTo) {
		int find = 0;
		int loc0 = 0;
		while(arr[find] != moveTo) {
			find++;
		}
		while(arr[loc0] != 0) {
			loc0++;
		}
		int temp = arr[loc0];
		arr[loc0] = arr[find];
		arr[find] = temp;
	}
	public int getValue(int i) {
		return arr[i];
	}
	public int getLength() {
		return arr.length;
	}
	public boolean isEqual() {
		int[] correct = {0,1,2,3,4,5,6,7,8};
		if(correct==arr) {
			return true;
		}
		return false;
	}
	public void printBoard() {
		int boardCounter = 0;
		for(int r = 0; r<10; r++) {
			for(int c = 0; c<16; c++){
				if(r%3 ==0 && c%5 == 0) {
					System.out.print(" ");
				}
				else if(r%3 ==0 && c%5 != 0) {
					System.out.print("-");
				}
				else if (r%3 !=0 && c%5 == 0) {
					System.out.print("|");
				}
				else if(((r-1)%3 ==0) && ((c-1)%5 ==0)) {
					if(arr[boardCounter] == 0) {
						System.out.print(" ");
						boardCounter ++;
					}
					else {
						System.out.print(arr[boardCounter]);
						boardCounter ++;
					}
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
	public static void main(String args[]) {
		Gameboard test = new Gameboard();
		Scanner input = new Scanner(System.in);
		System.out.println("Say start");
		String value = input.nextLine();
		while(!test.isEqual()) {
			test.printBoard();
			int num = Integer.parseInt(input.nextLine());
			test.switchNums(num);
		}
		input.close();
	}
}

