//Kyle Riedemann
//CS 2133

/*
Fibonacci numbers (30 points)

The Fibonacci sequence is a famous mathematical sequence where each successive term is the sum
of the two preceding ones. This can be expressed mathematically as Fn = Fn−1 + Fn−2, where
F1 = 1 and F2 = 1. The sequence, therefore, goes 1, 1, 2 (1+1), 3 (1+2), 5 (2+3), 8 (3+5),
13 (5+8), 21, 34, 55, 89, 144... Write a program called Fib.java which allows a user to enter a
number n as a command-line argument. The program will print out the nth Fibonacci number.
Hint: you will have to change the argument in the variable arg[0] from a String to an int using
Integer.parseInt().

$ java Fib 4
3
$ java Fib 7
13
$ java Fib 11
89
*/

import java.util.Scanner;

public class FibonacciNumbers {
	public static void main(String[] args) {
		int input = 0;

		if(args.length ==1) input = Integer.parseInt(args[0]);
		else System.exit(0);

		System.out.println(fibonacci(input));
	}

	public static int fibonacci(int n) {
		if(n == 0) return 0;
		else if(n == 1) return 1;
		else return fibonacci(n-1) + fibonacci(n-2);
	}
}