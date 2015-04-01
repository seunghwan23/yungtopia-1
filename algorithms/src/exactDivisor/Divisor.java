package exactDivisor;

public class Divisor {
	public static void main(String[] args) {
		// https://www.acmicpc.net/problem/1037
		int number = 0;
		int[] exactDivisors = {3};
		int size = exactDivisors.length;
		if(size % 2 == 0){
			number =  exactDivisors[0] * exactDivisors[size-1];
		}else{
			int index = size / 2 + 1 / 2;  
			number =  exactDivisors[index] * exactDivisors[index];
		}
		System.out.println(number);
	}
}
