/**
Basic Programm for Fibonacci Numbers (using Recursion)
@author parveenkumar
*/
public class FibonacciNumbers{
	public int find(int number){
		if(number == 0)
			return 1;
		if(number == 1)
			return 1;
		return find(number - 1) + find(number - 2);
	}
}
