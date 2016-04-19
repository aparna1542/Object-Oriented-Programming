package Algo.DS;
import java.util.Scanner;


public class InsertionSort {

	
	public int [] insertionSort(int a[])
	{
		int i,key=0;
		
		for (int j=1;j<a.length;j++) //j=1 starting from second postion
		{
			key=a[j];
			i=j-1;
			while(i>=0 && a[i]>key)
			{
				a[i+1]=a[i];
				i--;
			}
			a[i+1]=key; //inserting the element in correct position
		}
		return a;
	}
	
	private static void printArray(int b[])
	
	{
		for(int i=0;i<b.length;i++)
		{
			System.out.print(b[i] + " ");
		}
	}
	
	
	public static void main(String args[])
	{
		InsertionSort s=new InsertionSort();
		System.out.println("enter the number of ele \n");
	Scanner in =new Scanner(System.in);

	int count= in.nextInt();
	int ar[]=new int[count];
	System.out.println("enter the elements \n");
	for(int i=0;i<count;i++)
	{
		ar[i]=in.nextInt();
	}
	System.out.println("unsorted array is \n");
	printArray(ar);
		
		System.out.println("\n The sorted array is ");
		printArray(s.insertionSort(ar));
	}
	
}
