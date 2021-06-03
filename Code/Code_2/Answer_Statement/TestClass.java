import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         int M = Integer.parseInt(br.readLine().trim());
         int[][] A = new int[N][M];
         for(int i_A = 0; i_A < N; i_A++)
         {
         	String[] arr_A = br.readLine().split(" ");
         	for(int j_A = 0; j_A < arr_A.length; j_A++)
         	{
         		A[i_A][j_A] = Integer.parseInt(arr_A[j_A]);
         	}
         }
         int Q = Integer.parseInt(br.readLine().trim());
         int S = Integer.parseInt(br.readLine().trim());
         long[][] Queries = new long[Q][2];
         for(int i_Queries = 0; i_Queries < Q; i_Queries++)
         {
         	String[] arr_Queries = br.readLine().split(" ");
         	for(int j_Queries = 0; j_Queries < arr_Queries.length; j_Queries++)
         	{
         		Queries[i_Queries][j_Queries] = Long.parseLong(arr_Queries[j_Queries]);
         	}
         }

         int[] out_ = solve(N, M, A, Q, S, Queries);
         System.out.print(out_[0]);
         for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
         {
         	System.out.print(" " + out_[i_out_]);
         }

         wr.close();
         br.close();
    }
    static int[] solve(int N, int M, int[][] A, int Q, int S, long[][] Queries){
       Set<Integer> a=new HashSet<>();
       for(int i=0;i<N;i++)
       {
           int sum=0;
           for(int j=0;j<M;j++)
           {
            sum=sum+A[i][j];
           }
           a.add(sum);
       }
       for(int i=0;i<N;i++)
       {
           int sum=0;
           for(int j=0;j<M;j++)
           {
            sum=sum+A[j][i];
           }
           a.add(sum);
       }
       ArrayList<Integer> a1=new ArrayList<>(a);
       int x=(int)Queries[0][0];
       int y=(int)Queries[0][1];
       int arr1[]=new int [Queries.length];
       int count=0;
       for(int i=0;i<a1.size();i++)
       {
           if(a1.get(i)>=x&&a1.get(i)<=y)
           {
               count++;
           }
       }
       arr1[0]=count;
        x=(int)Queries[1][0];
        y=(int)Queries[1][1];
        count=0;
       for(int i=0;i<a1.size();i++)
       {
           if(a1.get(i)>=x&&a1.get(i)<=y)
           {
               count++;
           }
       }
       arr1[1]=count;

       return arr1;
       
       
    
    }
}