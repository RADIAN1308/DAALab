import java.util.Scanner;
public class Merger {
    public static void mergeSort(int [] arr,int l, int h){
       if(l<h){
            int m= (l+h)/2;
            //left half
            mergeSort(arr,l,m);
            //right half
            mergeSort(arr,m+1,h);
            //merge after reaching end elements
            merge(arr,l,m,h);
        }
    }
    public static void merge(int [] arr,int l,int m, int h){
        //
        int n1= m+1-l;
        int n2 = h-m;
        int []L = new int[n1];
        int []R = new int[n2];

        //copy left and right half of the section being sorted.
        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr,m+1,R,0,n2);

        //compare and insert the elements.
        int i = 0 ,j = 0,k=l;
        while(i<n1&&j<n2){
            if(L[i]<=R[j]){
                arr[k++]= L[i++];
            }
            else
                arr[k++]=R[j++];
        }

        //extra elements to be inserted.
        while(i<n1)
            arr[k++] = L[i++];
        while(j<n2)
            arr[k++]=R[j++];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //accept array size and array elements
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i = 0 ; i < n;i++){
            arr[i] =sc.nextInt();
        }
        //begin mergesort
        mergeSort(arr,0,n-1);

        //output
        for (int x:arr){
            System.out.print(x+" " );
        }
    }

}
