import java.io.*;
import java.util.*;

public class Main {
	
	private static String ZOAC;
	private static boolean[] array;
	
    public static void main(String[] args) throws IOException {
    	ZOAC = new Scanner(System.in).nextLine();
    	array = new boolean[ZOAC.length()];
    	
    	func(0, ZOAC.length() - 1);
    }
    
    public static void func(int start, int end) {
    	if (start > ZOAC.length() - 1 || end < 0 || start > end)
    		return;
    	
    	//System.out.println("start = " + start + ", end = " + end);
    	int index = start;
    	
    	for (int i = start; i <= end; i++) {
    		if (ZOAC.charAt(i) < ZOAC.charAt(index))
    			index = i;
    	}
    	array[index] = true;
    	
    	for (int i = 0; i < ZOAC.length(); i++) {
    		if (array[i])
    			System.out.print(ZOAC.charAt(i));
    	}
    	System.out.println();
    	
    	func(index + 1, end);
    	func(start, index - 1);
    }
}