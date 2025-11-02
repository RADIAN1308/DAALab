import java.util.Arrays;
import java.util.Scanner;
public class TopoSort {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices ");
        int n = sc.nextInt();
        int []indeg = new int[n];
        int [][]graph = new int [n][n];
        int []result = new int[n];
        Arrays.fill(indeg,0);
        System.out.println("Enter the adjacency matrix representing te graph:");
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                graph[i][j] = sc.nextInt();
                if(graph[i][j]!=0){
                    indeg[j]++;
                }
            }
        }
        System.out.println("\nIn-degree array:");
        for(int i :indeg){
            System.out.print("|"+i+"|");
        }
        System.out.println();
        int k=0;//result array pointer

        for(int i = 0;i<n;i++){
           if(indeg[i]==0){
               //update indeg array and reduce
               for(int j =0;j<n;j++){
                   //reduce from matrix and indeg data
                   if(graph[i][j]!=0){
                       graph[i][j]--;
                       indeg[j]--;
                   }
               }

                   result[k++]=i;
               indeg[i]--;//set to -1 hence deleted
           }
        }
        System.out.print("Topological Sort order: ");
        int i;
        for(i = 0;i<n-1;i++){
            System.out.print(result[i]+"-->");
        }
        System.out.print(result[i]);
    }
}
