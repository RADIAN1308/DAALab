import java.util.Scanner;
public class Quick {
    public static int partition(int[]arr,int l ,int h){
        int pivot = arr[l];
        int i =l,j = h;
        while(i<j){
            //pivot is greater than the left half of the array and lesser than right half.
            while(i<h&&arr[i]<=pivot)i++;//left half lesser
            while(j>l&&arr[j]>pivot)j--;// right half greater
            if(i<j){
                //swaps out terms to positions agreeing to fit the pivot element.
                swap(arr, i, j);
            }
        }
        swap(arr,l,j);//if all elements are in the right positions j will be lesser than i.
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
            //pivot is not inclusive since it is in a fixed position.
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