import java.util.*;
public class Kruskals {
    public static void KruskalsMST(int[][]graph){
        int n = graph.length;
        int []parent = new int[n];
        int mincost = 0;
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        int count = 0;
        while(count!=n-1){
            int min = Integer.MAX_VALUE,a=-1,b=-1;
            for(int i = 0;i<n;i++){
                for(int j =0 ;j<n;j++){
                    if(find(i,parent)!=find(j,parent)&&graph[i][j]<min){
                        min = graph[i][j];
                        a = i;
                        b=j;
                    }

                }
            }
            union(a,b,parent);
            System.out.printf("\nEdge %d to %d : %d",a,b,min);
            mincost+=min;
            count++;


        }
        System.out.print("\nMinCost="+mincost);

    }
    static int find(int i,int[] parent){
        while(parent[i]!=i){
            i= parent[i];
        }
        return i;
    }
    static void union(int a,int b,int[]parent){
        int i = find(a,parent);
        int j = find(b,parent);
        parent[i] = j;
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][]graph = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                graph[i][j]=sc.nextInt();
            }
        }
        KruskalsMST(graph);

    }

}
