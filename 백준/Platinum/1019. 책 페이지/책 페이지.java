//package recursive_function;
import java.util.Scanner;

public class Main {
	static int[] count;
	static int start, end, digit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		digit = 1;
		start = 1;
		end = sc.nextInt();
		count = new int[10];
		
		while(start <= end) {
			while(start % 10 != 0 && start <= end) {
				counting(start, digit);
				start++;
			}
			
			while(end % 10 != 9 && start <= end) {
				counting(end, digit);
				end--;
			}
			
			if(start > end)
                break;
			
			start /= 10;
			end /= 10;
			
			for(int i = 0 ; i < 10 ; ++i) {
				count[i] += (end - start + 1) * digit;
			}
			
			digit *= 10;
		}
		
		for(long i : count) {
			System.out.print(i + " ");
		}
	}

	private static void counting(int num, int digit) {
		while(num > 0) {
			count[num % 10] += digit;
			num /= 10;
		}
	}
}