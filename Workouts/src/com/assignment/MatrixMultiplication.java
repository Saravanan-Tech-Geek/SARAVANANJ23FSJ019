package com.assignment;

import java.util.Scanner;

public class MatrixMultiplication {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter row value for first matrix..:");
		int row1 = sc.nextInt();
		System.out.println("Enter column value for first matrix..:");
		int col1 = sc.nextInt();

		System.out.println("Enter row value for second matrix..:");
		int row2 = sc.nextInt();
		System.out.println("Enter column value for second matrix..:");
		int col2 = sc.nextInt();

		int matrixOne[][] = new int[row1][col1];
		int matrixTwo[][] = new int[row2][col2];

		if (col1 != row2) {
			System.out.println("Matrix Multiplication not possible..!!");
		} else {

			int result[][] = new int[row1][col2];

			System.out.println("Enter values for MatrixOne..!!\n");
			for (int i = 0; i < row1; i++) {
				for (int j = 0; j < col1; j++) {
					matrixOne[i][j] = sc.nextInt();
				}
			}

			System.out.println("Enter values for MatrixTwo..!!\n");
			for (int i = 0; i < row2; i++) {
				for (int j = 0; j < col2; j++) {
					matrixTwo[i][j] = sc.nextInt();
				}
			}

			System.out.println("Matrix Multiplication...!!\n");
			for (int i = 0; i < row1; i++) {

				for (int j = 0; j < col2; j++) {
					result[i][j] = 0;

					for (int k = 0; k < col1; k++) {
						result[i][j] += matrixOne[i][k] * matrixTwo[k][j];
					}
					System.out.print(result[i][j] + " ");
				}
				System.out.println();
			}
			sc.close();
		}

	}
}
