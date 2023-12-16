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
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        Set<Integer> adj[] = new HashSet[n];
    int[] dist = new int[n];
    for(int i=0;i<n;i++){
        adj[i] = new HashSet<>();
        dist[i] = -1;
    }


    for(int i=0;i<m;i++){
        int v = edges.get(i).get(0);
        int w = edges.get(i).get(1);
        adj[v-1].add(w-1);
        adj[w-1].add(v-1);
    }

    boolean visited[] = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();
    visited[s-1] = true;
    queue.add(s-1);


    while(queue.size()!=0){
        s = queue.poll();
        //sysout
        if(dist[s]<0)
            dist[s] = 0;

        // Iterator<Integer> i = adj[s].listIterator();
        Iterator<Integer> i = adj[s].iterator();
        while(i.hasNext()){
            int k = i.next();
            if(!visited[k]){
                visited[k] = true;
                queue.add(k);
                dist[k] = dist[s]+6;
            }
        }
    }
    List<Integer> res = new ArrayList<>();
    for(int i=0;i<n;i++){
        if(dist[i]!=0)
            res.add(dist[i]);
    }

    return res;
        

    }

}

public class BreadthFirstSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.bfs(n, m, edges, s);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
