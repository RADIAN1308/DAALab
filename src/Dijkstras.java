import java.util.Arrays;
import java.util.Scanner;



public class Dijkstras {
public static void main(String []args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int [][]C= new int[n][n];
    //cost matrix
    for(int i = 0;i<n;i++){
        for(int j =0;j<n;j++){
            C[i][j] =sc.nextInt();
        }
    }
    //initialize the arrays distance and visited
    int[]d = new int[n];
    int[]v = new int [n];
    Arrays.fill(d,Integer.MAX_VALUE);
    Arrays.fill(v,0);
    //obtain source;
    int src = sc.nextInt();
    d[src] = 0;
    for(int i = 0;i< n;i++){
        //find the smallest weight in the distance array
        int m = smallest(d,v);
        for(int j = 0 ;j<n;j++){
            if(v[m]!=1&&C[m][j]!=0&&d[m]+C[m][j]<d[j]){
                d[j] = d[m]+C[m][j];
            }
        }
        v[m] = 1;
    }

    System.out.println("from\t\tto\t\tweight");
    for(int i= 0 ; i <n;i++){
        System.out.print(src+"\t\t"+i+"\t\t"+d[i]);
        System.out.println();
    }

}

    private static int smallest(int[] d,int[]v) {
    int m =Integer.MAX_VALUE;
    int index = -1;
        for (int j =0;j<d.length;j++) {
            if (d[j]<m&&v[j]==0) {
                m = d[j];
                index = j;
            }
        }
    return index;
    }
}
