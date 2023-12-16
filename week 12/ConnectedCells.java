import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */
     public static int max = 0 ;
     public static int connectedCell(List<List<Integer>> matrix) {
    // Write your code here
int n = matrix.size(), m = matrix.get(0).size(); 
      for(int i=0; i < n; i++){
        for(int j=0; j < m; j++){
          if(matrix.get(i).get(j)==1){
             dfs(matrix, i, j,0);
          }        
        }     
     }     
    return max;    
    }
    
   static void dfs(List<List<Integer>>mt, int i,int j, int curr){
    if(i >= mt.size() || i < 0 || j >= mt.get(0).size() || j < 0)return;
    if(mt.get(i).get(j) == 0)return;
    
    mt.get(i).set(j, 0);
    curr++;
    max = Math.max(max, curr);
    dfs(mt, i, j+1 , curr); 
    dfs(mt, i, j-1, curr); 
    dfs(mt, i+1, j, curr); 
    dfs(mt, i-1, j, curr); 
    dfs(mt, i-1, j+1, curr); 
    dfs(mt, i+1, j+1, curr); 
    dfs(mt, i+1, j-1, curr); 
    dfs(mt, i-1, j-1, curr);  
    mt.get(i).set(j , 1);
    }
}

public class ConnectedCells {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
