import java.util.*;
import java.util.LinkedList;

public class Graphs {
    static class Edge {
        int src;
        int des;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.des = d;
            this.wt = w;
        }
    }
    //un-directed Graph
    // public static void createGraph(ArrayList<Edge> graph[]) {

    //     for (int i = 0; i < graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }

    //     // 0- vertex
    //     graph[0].add(new Edge(0, 1, 1));
    //     graph[0].add(new Edge(0, 2, 1));

    //     // 1- vertex
    //     graph[1].add(new Edge(1, 0, 1));
    //     graph[1].add(new Edge(1, 3, 1));

    //     // 2- vertex
    //     graph[2].add(new Edge(2, 0, 1));
    //     graph[2].add(new Edge(2, 4, 1));

    //     // 3- vertex
    //     graph[3].add(new Edge(3, 1, 1));
    //     graph[3].add(new Edge(3, 4, 1));
    //     graph[3].add(new Edge(3, 5, 1));

    //     // 4- vertex
    //     graph[4].add(new Edge(4, 2, 1));
    //     graph[4].add(new Edge(4, 3, 1));
    //     graph[4].add(new Edge(4, 5, 1));

    //     graph[5].add(new Edge(5, 3, 1));
    //     graph[5].add(new Edge(5, 4, 1));
    //     graph[5].add(new Edge(5, 6, 1));

    //     graph[6].add(new Edge(6, 5, 1));

    // }

    //directed graph
    public static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
         graph[0].add(new Edge(0, 2, 4));

         graph[1].add(new Edge(1, 2, 1));
          graph[1].add(new Edge(1, 3, 7));
        // 2- vertex
        graph[2].add(new Edge(2, 4,3));

        // 3- vertex
        graph[3].add(new Edge(3, 5, 1));


        // 4- vertex
        graph[4].add(new Edge(4, 3, 2));
         graph[4].add(new Edge(4, 5, 5));




    }

    public static void bfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsUtils(graph, vis);
            }
        }
    }

    public static void bfsUtils(ArrayList<Edge> graph[], boolean vis[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.des);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfsUtil(graph, vis, i);
            }
        }

    }

    public static void dfsUtil(ArrayList<Edge> graph[], boolean vis[], int curr) {

        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.des]) {
                dfsUtil(graph, vis, e.des);
            }
        }
    }

    public static boolean hasPathBFS(ArrayList<Edge> graph[], int src, int des) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        boolean isDes = false;
        q.add(src);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                if (curr == des) {
                    isDes = true;
                    break;
                }
                vis[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);

                    q.add(e.des);
                }
            }

        }

        return isDes;
    }

    public static boolean hasPathDFS(ArrayList<Edge> graph[], int src, int des, boolean[] vis) {

        if (src == des) {
            return true;
        }
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);

            if (!vis[e.des]) {
                return hasPathDFS(graph, e.des, des, vis);
            }
        }

        return false;
    }

    public static boolean isCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                return isCycleUtil(graph, vis, i, 0);
            }
        }

        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {

        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.des]) {
                if (isCycleUtil(graph, vis, e.des, curr)) {
                    return true;
                }
            }

            if (vis[e.des] && e.des != par) {
                return true;
            }
        }

        return false;

    }

    public static boolean isBaiPitite(ArrayList<Edge> graph[]) {
        int col[] = new int[graph.length];

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();

                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);

                        if (col[e.des] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.des] = nextCol;
                            q.add(e.des);
                        }

                        else if (col[e.des] == col[curr]) {
                            return false;
                        }
                    }
                }

            }
        }

        return true;
    }

    public static boolean isCycleDirectedGraph(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                return isCycleDirectedGraphUtil(graph, i, vis, stack);
            }
        }

        return false;
    }

    public static boolean isCycleDirectedGraphUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (stack[e.des]) {
                return true;
            }

            if (!vis[e.des]) {
                return isCycleDirectedGraphUtil(graph, e.des, vis, stack);
            }
        }

        stack[curr] = false;
        return false;
    }

    public static void topologicalSortDFS(ArrayList<Edge> graph[]){
       boolean vis[] = new boolean[graph.length];
       Stack<Integer> s = new Stack<>();

       for(int i=0;i<graph.length;i++){
         if(!vis[i]){
            topologicalSortDFSUtil(graph,i,vis,s);
         }
       }

       while(!s.isEmpty()){
        System.out.print(s.pop()+" ");
       }
    }

    public static void topologicalSortDFSUtil(ArrayList<Edge> graph[],int curr, boolean vis[],Stack<Integer> s){
 
            vis[curr] = true;

            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);

                if(!vis[curr]){
                    topologicalSortDFSUtil(graph, e.des, vis, s);
                }

            }

            s.push(curr);
    }

    public static void calIndeg(ArrayList<Edge> graph[],int inDeg[]){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                inDeg[e.des]++;
            }
        }
    }

    public static void topologicalSortBFS(ArrayList<Edge> graph[]){
        int inDeg[] = new int[graph.length];

        calIndeg(graph, inDeg);

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<inDeg.length;i++){
          
            if(inDeg[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " ");

            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);

                inDeg[e.des]--;

                if(inDeg[e.des] == 0){
                    q.add(e.des);
                }
            }
        }

        System.out.println();

    }

    public static void printAllPaths(ArrayList<Edge> graph[],int src , int des,String str){

       if(src == des){
         System.out.println(str+des+ " ");
       }

       for(int i=0;i<graph[src].size();i++){
         Edge e = graph[src].get(i);
         printAllPaths(graph, e.des, des, str+src);
       }
       

    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n,int path){
            this.n = n;
            this.path = path;
        }

          @Override
    public int compareTo(Pair p2) {
        return this.path - p2.path; // min-heap
    }
    }

    public static void dijkstra(ArrayList<Edge> graph[],int src){
        int dist[] = new int[graph.length];

        for(int i=0;i<dist.length;i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();

            if(!vis[curr.n]){
                vis[curr.n] = true;

                for(int i=0;i<graph[curr.n].size();i++){
                    Edge e = graph[curr.n].get(i);

                    int u = e.src;
                    int v = e.des;
                    int wt = e.wt;

                    if(dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for(int i :dist){
            System.out.print(i + " ");
        }
    }

    public static void bellmanFord(ArrayList<Edge> graph[],int src){
        int dist[] = new int[graph.length];
        Arrays.fill(graph, Integer.MAX_VALUE);
        dist[src] = 0;

        int V = graph.length;

        for(int i=0;i<V-1;i++){
            for(int j=0;j<graph.length;i++){
                for(int k=0;k<graph[j].size();i++){
                    Edge e = graph[j].get(k);

                    int s = e.src;
                    int d = e.des;
                    int w = e.wt;

                    if(dist[s] != Integer.MAX_VALUE && dist[s] + w < dist[d]){
                        dist[d] = w + dist[s];
                    } 
                }
            }
        }

        for(int i: dist){
            System.out.print(i + " ");
        }
    }

    static class PairPrism implements Comparable<PairPrism> {
    int v;
    int cost;

    public PairPrism(int v,int c){
        this.v = v;
        this.cost = c;
    }

    @Override
    public int compareTo(PairPrism p2){
        return this.cost - p2.cost;
    }
}

    public static void prims(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<PairPrism> pq = new PriorityQueue<>();

        pq.add(new PairPrism(0, 0));
        int maxCost = 0;

        while(!pq.isEmpty()){
            PairPrism curr = pq.remove();

            if(!vis[curr.v]){
                vis[curr.v] = true;
                maxCost += curr.cost;

                for(int i=0;i<graph[curr.v].size();i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new PairPrism(e.des, e.wt));
                }
            }
        }

        System.out.println(maxCost);
    }

    public static class InfoCheapFlight {
       int v;
       int cost;
       int stops;

       public InfoCheapFlight(int v,int cost,int stops){
         this.v = v;
         this.cost = cost;
         this.stops = stops;
       }
    }

    public static void createFlightGraph(int flights[][], ArrayList<Edge> graph[],int n){

        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<flights.length;i++){
            int src = flights[i][0];
            int des = flights[i][1];
            int cost = flights[i][2];

            Edge e = new Edge(src, des, cost);

            graph[src].add(e);
        }

    }

   public static int cheapestFlight(int flights[][], int n, int src, int des, int k) {
    ArrayList<Edge> graph[] = new ArrayList[n];
    createFlightGraph(flights, graph, n);

    Queue<InfoCheapFlight> q = new LinkedList<>();
    q.add(new InfoCheapFlight(src, 0, 0));

    int dist[] = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);

    while (!q.isEmpty()) {
        InfoCheapFlight curr = q.remove();

        if (curr.stops > k) continue;

        for (Edge e : graph[curr.v]) {
            int v = e.des;
            int wt = e.wt;

            if (curr.cost + wt < dist[v]) {
                dist[v] = curr.cost + wt;
                q.add(new InfoCheapFlight(v, dist[v], curr.stops + 1));
            }
        }
    }

    return dist[des] == Integer.MAX_VALUE ? -1 : dist[des];
}
    

    public static void main(String[] args) {
        // int V = 6;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);

        int n = 4;
        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src=0, des=3, k=1;
 
        System.out.println(cheapestFlight(flights, n, src, des, k));
    }
}
