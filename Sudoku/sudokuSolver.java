import java.util.*;
import java.lang.*;
import java.io.*;
class sudokuSolver
 {  static boolean issafe(int[][] a,int row,int col,int num)
    {
        for(int i=0;i<9;i++)
        if(a[row][i]==num)return false;
        
        for(int i=0;i<9;i++)
        if(a[i][col]==num)return false;
        
        int row_start=row-row%3;
        int col_start=col-col%3;
        for(int i=row_start;i<row_start+3;i++)
            for(int j=col_start;j<col_start+3;j++)
            if(a[i][j]==num)return false;
        return true;    
    }
    static boolean solvesudoku(int[][] a,int n)
    {   boolean empty=true;
        int row=-1;
        int col=-1;
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(a[i][j]==0)
                {
                    empty=false;
                    row=i;
                    col=j;
                    break;
                }
            }
            if(empty)
            return true;
        }
        for(int num=1;num<=9;num++)
        {
            
            if(issafe(a,row,col,num))
            {
             a[row][col]=num;
             if(solvesudoku(a,n))
             {
                 return true;
             }
             else
             {
                 a[row][col]=0;
             }
            }
        }
        return false;
    }
    static void print (int [][] a)
    {
        for(int i=0;i<9;i++)
        {   System.out.println();
            System.out.println("------------------------------");
            System.out.println();
        for(int j=0;j<9;j++)
        System.out.print(a[i][j]+"|");
        }
    }
	public static void main (String[] args)
	 {
	 //code
	   Scanner sc=new Scanner(System.in);
	 
        int a[][]=new int[9][9];
        System.out.println("Enter the number of elements known");
        int n=sc.nextInt();
        System.out.println("Enter the elements along with their row and column number");
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                a[i][j]=0;
        for(int i=0;i<n;i++)
        {
            int x,y;
            System.out.println("Enter number");
            int num=sc.nextInt();
            System.out.println("Enter x and y");
            x=sc.nextInt();
            y=sc.nextInt();
            a[x-1][y-1]=num;
        }
            if(solvesudoku(a,9))
                {print(a);
                System.out.println();}
            else
            System.out.println("The given matrix does not satisfy the sudoku constraints");
	 
}
}