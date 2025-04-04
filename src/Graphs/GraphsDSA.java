package Graphs;

import java.util.*;

class Pair {
    int nodeValue, weigth;

    Pair(int nodeValue, int weigth) {
        this.nodeValue = nodeValue;
        this.weigth = weigth;
    }
}

class GraphsDSA {
    public static void main(String[] args) {
//        int n = 6, m = 7;
//        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
//        int n = 10, m = 24;
//        int[][] edge = {
//                {0, 2, 6}, {0, 3, 7}, {0, 4, 9}, {0, 6, 8}, {0, 7, 6},
//                {1, 2, 6}, {1, 3, 7}, {1, 5, 10}, {1, 6, 1}, {1, 7, 4},
//                {2, 3, 3}, {2, 6, 10}, {2, 8, 8}, {2, 9, 10},
//                {3, 5, 3}, {3, 6, 10}, {3, 7, 5},
//                {5, 6, 9}, {5, 7, 7},
//                {6, 7, 7}, {6, 8, 8}, {6, 9, 8},
//                {7, 9, 1},
//                {8, 9, 6}
//        };
//        int[] dist = new GraphsDSA().shortestPathInDAG(n, m, edge);
//        for (int i = 0; i < n; i++) {
//            System.out.print(dist[i] + " ");
//        }
//        int V = 5;
//        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
//        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
//
//        for (int i = 0; i < V; i++) {
//            adj.add(new ArrayList<ArrayList<Integer>>());
//        }
//
//        for (int i = 0; i < 6; i++) {
//            int u = edges[i][0];
//            int v = edges[i][1];
//            int w = edges[i][2];
//
//            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
//            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
//            tmp1.add(v);
//            tmp1.add(w);
//
//            tmp2.add(u);
//            tmp2.add(w);
//
//            adj.get(u).add(tmp1);
//            adj.get(v).add(tmp2);
//        }
//        System.out.println(primsAlgorithm(V,adj));

    }


    public int[] shortestPathInDAG(int N, int M, int[][] edges) { 
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[N];
        int[] distance = new int[N];
        ArrayList<ArrayList<Pair>> adj = createAdjacentListWithPair(edges,N);
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                topoSort(i, adj, vis, stack);
            }
        }
        for (int i = 0; i < N; i++) {
            distance[i] = (int) (1e9);
        }
        distance[0] = 0;
        while (!stack.isEmpty()) {
            int node = stack.peek();
            stack.pop();
            for (Pair pair : adj.get(node)) {
                int dest = pair.nodeValue;
                int wt = pair.weigth;
                if (distance[node] + wt < distance[dest]) {
                    distance[dest] = distance[node] + wt;
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == (1e9)) {
                distance[i] = -1;
            }
        }
        return distance;
    }

    public int[] shortestPathInUndirectedGraph(ArrayList<ArrayList<Integer>> adj, int src){
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[adj.size()];
        for(int i=0;i<adj.size();i++){
            distance[i] = (int)1e9;
        }
        distance[src]=0;
        queue.add(src);
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.remove();
            for(int x : adj.get(node)){
                if(distance[node]+1 < distance[x]){
                    distance[x] = distance[node]+1;
                    queue.add(x);
                }
            }
        }
        for(int i=0;i<distance.length;i++){
            if(distance[i] == (int)1e9){
                distance[i]=-1;
            }
        }
        return distance;
    }

    public ArrayList<Integer> dijkstra(ArrayList<ArrayList<Pair>> adj, int src) {
        ArrayList<Integer> distance = new ArrayList<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> a.weigth - b.weigth);
        for(int i=0;i<adj.size();i++) distance.add(i,(int)1e9);
        minHeap.add(new Pair(src,0));
        distance.set(src,0);
        while (!minHeap.isEmpty()){
            int node = minHeap.peek().nodeValue;
            int dist = minHeap.peek().weigth;
            minHeap.remove();
            for(Pair pair : adj.get(node)){
                if(distance.get(node) + pair.weigth < distance.get(pair.nodeValue)){
                    distance.set(pair.nodeValue,distance.get(node) + pair.weigth);
                    minHeap.add(new Pair(pair.nodeValue,distance.get(pair.nodeValue)));
                }
            }
        }
        return distance;
    }

    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] distance = new int[V];
        for(int i=0;i<V;i++) distance[i] = (int)1e8;
        distance[src] = 0;
        for(int i=0;i<V-1;i++){
            for(int[] edge : edges){
                int sr = edge[0];
                int dt = edge[1];
                int wt = edge[2];
                if(distance[sr] != 1e8 && distance[sr] + wt < distance[dt]){
                    distance[dt] = distance[sr] + wt;
                }
            }
        }
        for(int[] edge : edges){
            int sr = edge[0];
            int dt = edge[1];
            int wt = edge[2];
            if(distance[sr] != 1e8 && distance[sr] + wt < distance[dt]){
                return new int[]{-1};
            }
        }

        return distance;
    }

    public static int primsAlgorithm(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj){
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>((a,b) -> a.weigth - b.weigth);
        int sum = 0;
        int[] vis = new int[V];
        minHeap.add(new Pair(0,0));
        while(!minHeap.isEmpty()){
            int node = minHeap.peek().nodeValue;
            int wt = minHeap.peek().weigth;
            minHeap.remove();
            if(vis[node] == 1) continue;
            vis[node]=1;
            sum = sum+wt;
            for(List<Integer> pairs : adj.get(node)){
                int n = pairs.get(0);
                int w = pairs.get(1);
                minHeap.add(new Pair(n,w));
            }
        }
        return sum;
    }
    public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> stk = new Stack<>();
        int[] vis = new int[V];
        Arrays.fill(vis,0);
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                dfs(i,adj,stk,vis);
            }
        }
        //Reversal of Adjacency List
        ArrayList<ArrayList<Integer>> reversedAdj = new ArrayList<>();
        for(int i=0;i<V;i++){
            reversedAdj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<V;i++){
            vis[i] = 0;
            for(Integer x : adj.get(i)){
                reversedAdj.get(x).add(i);
            }
        }
        int scc = 0;
        while (!stk.isEmpty()){
            int node = stk.peek();
            stk.pop();
            if(vis[node] == 0){
                dfs2(node,reversedAdj,vis);
                scc++;
            }
        }
        return scc;
    }

    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj , Stack<Integer> stk,int vis[]){
        vis[node] =1;
        for(Integer i : adj.get(node)){
            if(vis[i] == 0){
                dfs(i,adj,stk,vis);
            }
        }
        stk.push(node);
    }

    public static void dfs2(int node,ArrayList<ArrayList<Integer>> adj,int vis[]){
        vis[node] = 1;
        for(Integer it : adj.get(node)){
            dfs2(it,adj,vis);
        }
    }

    private void topoSort(int node, ArrayList<ArrayList<Pair>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;
        for (Pair pair : adj.get(node)) {
            if (!vis[pair.nodeValue]) {
                topoSort(pair.nodeValue, adj, vis, st);
            }
        }
        st.add(node);
    }


    private ArrayList<ArrayList<Pair>> createAdjacentListWithPair(int[][] edges, int N){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Pair>());
        }
        for (int[] arr : edges) {
            int node = arr[0];
            int dest = arr[1];
            int wt = arr[2];
            adj.get(node).add(new Pair(dest, wt));
        }
        return adj;
    }
}