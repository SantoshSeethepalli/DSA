package DynamicProgramming.Striver.Basics;

import java.util.*;

import java.util.Scanner;

public class Fibonacci {

    // Dynamic Programming
    public int getNthFibonacciNumberMemoization(int n, int[] dp) {

        if(n <= 1) {
            dp[n] = n;
            return n;
        }

        if(dp[n] != -1) return dp[n];

        return getNthFibonacciNumberMemoization(n - 1, dp) + getNthFibonacciNumberMemoization(n - 2, dp);
    }

    // Recurssion
    public int getNthFibonacciNumberRecursively(int n) {

        if(n <= 1) {
            return n;
        }

        return getNthFibonacciNumberRecursively(n - 1) + getNthFibonacciNumberRecursively(n - 2);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner((System.in));
        System.out.print("Enter n value: ");
        int n = scan.nextInt();

        System.out.println(new Fibonacci().getNthFibonacciNumberRecursively(n));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.print(new Fibonacci().getNthFibonacciNumberMemoization(n, dp));
    }
}
