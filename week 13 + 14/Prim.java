import java.io.*;
import java.util.*;
import java.util.stream.*;

class Cost implements Comparable<Cost> {
    int v, cost;

    public Cost(int cost, int v) {
        this.cost = cost;
        this.v = v;
    }

    @Override
    public int compareTo(Cost other) {
        return Integer.compare(this.cost, other.cost);
    }
}

class Result {
    public static int prims(int n, List<List<Integer>> edges, int start) {
        List<List<Cost>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.size(); i++) {
            List<Integer> edge = edges.get(i);
            adj.get(edge.get(0)).add(new Cost(edge.get(2), edge.get(1)));
            adj.get(edge.get(1)).add(new Cost(edge.get(2), edge.get(0)));
        }

        int res = 0;
        boolean[] mark = new boolean[n + 1];

        PriorityQueue<Cost> q = new PriorityQueue<>();
        q.add(new Cost(0, start));

        while (!q.isEmpty()) {
            Cost u = q.poll();
            if (mark[u.v]) continue;
            mark[u.v] = true;
            res += u.cost;

            for (int i = 0; i < adj.get(u.v).size(); ++i) {
                Cost neighbor = adj.get(u.v).get(i);
                if (!mark[neighbor.v]) {
                    q.add(neighbor);
                }
            }
        }

        return res;
    }
}

public class Prim {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                edges.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

