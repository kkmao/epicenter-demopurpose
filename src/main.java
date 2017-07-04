import java.util.ArrayList;
import java.util.Scanner;


public class main {
	static Integer[][] locate = new Integer[100][100];
	static ArrayList<Integer> sixpoint = new ArrayList<Integer>();
	static ArrayList<Integer> addpoint = new ArrayList<Integer>();

	static int count = 0;
	
	public static void main(String[] args) throws Exception
	{
		 initArray();
		 basicrandom();
		 for (int i = 2; i < sixpoint.size(); i+=2) {
			 for (int j = i+2; j < sixpoint.size(); j+= 2) {
					closeorfar(sixpoint.get(i), sixpoint.get(i+1), sixpoint.get(j), sixpoint.get(j+1));
//					System.out.println(i+" "+(i+1)+" "+j+" "+(j+1));
			}
		}
		 check();
		 
    }
	
	public static void initArray() {
		for (int x = 0; x < locate.length; x++) {
			for (int y = 0; y < locate.length; y++) {
				locate[x][y] = 0;
			}
		}
	}
	
	public static void basicrandom() {
		for (int i = 0; i < 14; i = i + 2) {
			sixpoint.add((int)(Math.random() * 100 + 1));
			sixpoint.add((int)(Math.random() * 100 + 1));
			for (int j = 0; j < i; j = j + 2) {
				if (sixpoint.get(i) == sixpoint.get(j)
						&& sixpoint.get(i + 1) == sixpoint.get(j+1)) {
					i = i - 2;
					break;
				}
			}
		}
	}
	
	public static void closeorfar(double a, double b, double c, double d) {
		if (Math.pow(sixpoint.get(0) - a, 2) + Math.pow(sixpoint.get(1) - b, 2) > Math
				.pow(sixpoint.get(0) - c, 2) + Math.pow(sixpoint.get(1) - d, 2)) {
			for (int x = 0; x < 100; x++) {
				for (int y = 0; y < 100; y++) {
					if (Math.pow(x - a, 2) + Math.pow(y - b, 2) <= Math
				.pow(x - c, 2) + Math.pow(y - d, 2)) {
						locate[x][y] = 1;
					}
				}
			}
		}else if (Math.pow(sixpoint.get(0) - a, 2) + Math.pow(sixpoint.get(1) - b, 2) < Math
				.pow(sixpoint.get(0) - c, 2) + Math.pow(sixpoint.get(1) - d, 2)) {
			for (int x = 0; x < 100; x++) {
				for (int y = 0; y < 100; y++) {
					if (Math.pow(x - a, 2) + Math.pow(y - b, 2) >= Math
				.pow(x - c, 2) + Math.pow(y - d, 2)) {
						locate[x][y] = 1;
					}
				}
			}
		}
			
		}
			
	public static void check() {
		count = 0;
		for (int x = 0; x < locate.length; x++) {
			for (int y = 0; y < locate.length; y++) {
				if (locate[x][y] == 0) {
					count += 1;
				}
			}
		}
		if (count>50) {
			addpoint.add((int) (Math.random() * 100 + 1));
			addpoint.add((int) (Math.random() * 100 + 1));
			for (int i = 2; i < sixpoint.size(); i+=2) {
				closeorfar(sixpoint.get(i), sixpoint.get(i+1), addpoint.get(0), addpoint.get(1));
			}
			for (int i = 0; i < 2; i++) {
				sixpoint.add(addpoint.get(0));
				addpoint.remove(0);
			}
			check();
		}else {
			for (int x = 0; x < 100; x++) {
				for (int y = 0; y < 100; y++) {
					if (y == 99) {
						System.out.println(locate[x][y]);
					} else {
						System.out.print(locate[x][y]);
					}
				}
		}
			System.out.println("收斂後剩餘格數" + count);
//			if (locate[(int)sixpoint.get(0)][(int)sixpoint.get(1)] == 0) {
//				System.out.println("true");
//			}else {
//				System.out.println("false");
//			}
//			System.out.println(sixpoint);
			System.out.println("使用手機數" + sixpoint.size()/2);
	}	
	}
	}
	


