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
