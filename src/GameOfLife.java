/*
The universe of the Game of Life is an infinite, two-dimensional orthogonal grid of square cells, 
each of which is in one of two possible states, alive or dead, (or populated and unpopulated, respectively). 
Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent. 
At each step in time, the following transitions occur:

1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
2. Any live cell with two or three live neighbours lives on to the next generation.
3. Any live cell with more than three live neighbours dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.


The application will take in one parameter a filename

The file is attached to this email and will serve as the initial state for the application. 

 

The input file is ascii characters and has the following format:

Line 1: width height

Line 2+:space separated values of 0 or 1

 
The game's world is sized by the width and height. 


*/



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GameOfLife 
{ 
	public static void main(String[] args)  throws FileNotFoundException
	{ 
		Scanner input = new Scanner(System.in);
		System.out.print("Please Enter the File Name: ");
		String File = input.nextLine();
		BufferedReader br = null;
		Scanner s = new Scanner (new File (File));
		
		int Lenght = s.nextInt();
		int weidth = s.nextInt();
		
		int a[][] = new int [Lenght][weidth];
		
		for (int i = 0 ; i < Lenght ; i++) {
			for (int j=0 ; j < weidth; j++) {
				a[i][j] = s.nextInt();			
			}
		}

		int M = Lenght, N = weidth;
		int [][] grid = new int [Lenght][weidth];
		for (int i = 0 ; i < Lenght ; ++i) {
			for (int j=0 ; j < weidth; ++j) {
				grid [i][j] = a[i][j] ;
			}
		}
				// Displaying the grid 
		System.out.println("Original Generation"); 
		for (int i = 0; i < M; i++) 
		{ 
			for (int j = 0; j < N; j++) 
			{ 
				if (grid[i][j] == 0) 
					System.out.print(". "); 
				else
					System.out.print("! "); 
			} 
			System.out.println(); 
		} 
		System.out.println(); 
		
		nextGeneration(grid, M, N); 
		
	}
	// Function to print next generation 
	static void nextGeneration(int grid[][], int M, int N) { 
		
		int[][] future = new int[M][N];
		
		// Loop through every cell 
		
		for (int i = 1; i < M - 1; i++) { 
			for (int j= 1; j < N - 1; j++) { 
		
				// finding no Of Neighbours that are alive 
				
				int aliveNeighbours = 0; 
			    aliveNeighbours += grid[i-1][j-1];
				aliveNeighbours += grid[i][j-1];
				aliveNeighbours += grid[i+1][j-1];
				aliveNeighbours += grid[i+1][j];
				aliveNeighbours += grid[i+1][j+1];
				aliveNeighbours += grid[i][j+1];
				aliveNeighbours += grid[i-1][j+1];
				aliveNeighbours += grid[i-1][j];		
				
				// Implementing the Rules of Life 
				
				//1. Cell is lonely and dies 
				
				if ((grid[i][j] == 1) && (aliveNeighbours < 2)) 
					future[i][j] = 0; 
				
				//2. Cell dies due to over population 
				
				else if ((grid[i][j] == 1) && (aliveNeighbours > 3)) 
					future[i][j] = 0; 
				
				//3. A new cell is born 
				
				else if ((grid[i][j] == 0) && (aliveNeighbours == 3)) 
					future[i][j] = 1; 
				//4. Remains the same 
				else
					future[i][j] = grid[i][j]; 
				}
			} 	
		
		System.out.println("Next Generation"); 
		for (int i = 0; i < M; i++) 
		{ 
			for (int j = 0; j < N; j++) 
			{ 
				if (future[i][j] == 0) 
					System.out.print(". "); 
				else
					System.out.print("! "); 
			} 
			System.out.println(); 
		} 
	}
	
	
} 
