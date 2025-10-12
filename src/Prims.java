import java.util.Arrays;
import java.util.Scanner;
public class Prims
{
  public static void primsMST(int [][]graph){
      int V = graph.length;
      int[]parent = new int[V];//parents of the next node
      int[]key = new int[V];//mst weights
      boolean[]visited = new boolean[V];//are nodes visited or not

      //initial values
      Arrays.fill(key,Integer.MAX_VALUE);
      Arrays.fill(visited,false);

      //0 is the first node
      parent[0] = -1;//no parent
      key[0] = 0;//no edges so weight to 0 is 0

      //construct the MST
      for(int i = 0 ; i < V-1;i++){
          int smallest=minkey(key,visited);
          visited[smallest]=true;
          for(int j = 0;j<V;j++){
              if(graph[smallest][j]!=0&&!visited[j]&&graph[smallest][j]<key[j]){
                  key[j]= graph[smallest][j];
                  parent[j]=smallest;
              }
          }
      }
      //print the MST
      printMST(parent,graph);
  }
  static int minkey(int[]key,boolean[] visited){
      int minindex =-1,min =Integer.MAX_VALUE;
      for(int i =0;i<key.length;i++){
          if(!visited[i]&&key[i]<min){
              min=key[i];
              minindex=i;
          }
      }
      return minindex;
  }
  static void printMST(int[] parent,int[][]graph){
      System.out.println("Edge\t\tWeight");
      for(int i = 1;i<parent.length;i++){
          System.out.println(parent[i]+"-->"+i+": "+graph[parent[i]][i]);
      }
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
      primsMST(graph);
  }
}
