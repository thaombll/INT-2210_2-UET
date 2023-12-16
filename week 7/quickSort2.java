import java.io.*;
import java.util.*;

public class quickSort2 {
    static void quicksort(int[] array, int beg, int end)
    {
        if(beg >= end) return;
        
        int pivot = array[end];
        int wall = beg;
        for(int i = beg; i < end; i++)
        {
            if(array[i] < pivot)
            {
                swap(array, i, wall);
                wall++;
            }
        }
        swap(array, end, wall);
        printArray(array);

        quicksort(array, beg, wall-1);
        quicksort(array, wall+1, end);        
    }
    static void swap(int[] array, int index1, int index2)
    {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
    static void printArray(int[] array)
    {
        for(int num : array)
        {
            System.out.print(num+" ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int ar[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            ar[i] = input.nextInt();
        }
        quicksort(ar,0,ar.length-1);
    }
}