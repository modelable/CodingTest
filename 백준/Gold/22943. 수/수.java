import java.util.*;
import java.io.*;

public class Main {
	
	private static int size, answer;
	private static boolean[] array;
	private static ArrayList<Integer> plist;
	private static HashSet<Integer> set1;
	private static HashSet<Integer> set2;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int K = scanner.nextInt();
		int M = scanner.nextInt();
		size = (int)Math.pow(10, K); 
		answer = 0;
		plist = new ArrayList<>();
		
		eratos();
		plus();
		mul();
		
		int answer = 0;
		HashSet<Character> set;
		for (int i = size / 10; i < size; i++) {
			set = new HashSet<>();
			int num = i;
			String str = String.valueOf(num);
			
			int j;
			for (j = 0; j < str.length(); j++) {
				if (set.contains(str.charAt(j)))
					break;
				set.add(str.charAt(j));
			}
			
			if (j != str.length()) {
				continue;
			}
			
			if (set1.contains(num)) {
				while (num % M == 0)
					num /= M;
					
				if (set2.contains(num))
					answer++;		
			}
		}
		System.out.println(answer);
	}
	
	public static void eratos() {
		array = new boolean[size];
		array[0] = true;
		array[1] = true;
		
		for (int i = 2; i < size; i++) {
			if (array[i] == false) {
				plist.add(i);
					
				for (int j = 2; i * j < size; j++) {
					array[i * j] = true;
				}
			}
		}
	}
	
	public static void plus() {
		set1 = new HashSet<>();
		
		for (int i = 0; i < plist.size(); i++) {
			for (int j = 0; j < plist.size(); j++) {
				int plus = plist.get(i) + plist.get(j);
				if (i == j || plus >= size)
					break;
				set1.add(plus);	
			}
		}
	}
	
	public static void mul() {
		set2 = new HashSet<>();
		
		for (int i = 0; i < plist.size(); i++) {
			for (int j = i; j < plist.size(); j++) {
				long mul = (long)(plist.get(i)) * (long)(plist.get(j));
				if (mul >= size)
					break;
				set2.add((int)mul);
			}
		}
	}
	
}
