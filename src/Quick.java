import java.util.Scanner;
public class Quick {
    public static int partition(int[]arr,int l ,int h){
        int pivot = arr[l];
        int i =l,j = h;
        while(i<j){
            while(i<=h&&arr[i]<pivot)i++;
            while(j>l+1&&arr[j]>pivot)j--;

            if(i<j){
                swap(arr, i, j);
            }

        }
        swap(arr,l,j);
        return j;
    }

    public static void swap(int[]arr,int i , int j ){
        int temp = arr[i];
        arr[i] =arr[j];
        arr[j] = temp;
    }
    public static void quickSort(int[]arr,int l,int h){
        if(l<h){
            int pivot=partition(arr,l,h);
            quickSort(arr,l,pivot-1);
            quickSort(arr,pivot+1,h);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int []arr =new int[n];
        for(int i =0 ;i < n ; i++)
            arr[i] = sc.nextInt();
        quickSort(arr,0,n-1);
        for(int i:arr)
            System.out.print(i+" ");
    }
}
