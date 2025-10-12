//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Merger {
    public static void mergeSort(int [] arr,int l, int h){
       if(l<h){
            int m= (l+h)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,h);
            merge(arr,l,m,h);
        }
    }
    public static void merge(int [] arr,int l,int m, int h){
        int n1= m+1-l;
        int n2 = h-m;
        int []L = new int[n1];
        int []R = new int[n2];

        System.arraycopy(arr, l, L, 0, n1);

        System.arraycopy(arr,m+1,R,0,n2);

        int i = 0 ,j = 0,k=l;
        while(i<n1&&j<n2){
            if(L[i]<=R[j]){
                arr[k++]= L[i++];
            }
            else
                arr[k++]=R[j++];
        }

        while(i<n1)
            arr[k++] = L[i++];
        while(j<n2)
            arr[k++]=R[j++];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i = 0 ; i < n;i++){
            arr[i] =sc.nextInt();
        }
        mergeSort(arr,0,n-1);
        for (int x:arr){

            System.out.print(x+" " );
        }
    }

}
