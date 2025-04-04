package Graphs;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUParent(int node){
        if(node == parent.get(node)) return node;
        int p = findUParent(parent.get(node));
        parent.set(node,p);
        return parent.get(node);
    }
    public void unionByRank(int node1 , int node2){
        int upNode1 = findUParent(node1);
        int upNode2 = findUParent(node2);
        if(upNode1 == upNode2) return;
        if(rank.get(upNode1) < rank.get(upNode2)){
            parent.set(upNode1,upNode2);
        }
        else if(rank.get(upNode1) > rank.get(upNode2)){
            parent.set(upNode2,upNode1);
        }
        else{
            parent.set(upNode1,upNode2);
            int rank2 = rank.get(upNode2)+1;
            rank.set(upNode2,rank2+1);
        }
    }

    public void unionBySize(int node1,int node2){
        int upNode1 = findUParent(node1);
        int upNode2 = findUParent(node2);
        if(upNode1==upNode2) return;
        if(size.get(upNode1) < size.get(upNode2)){
            parent.set(upNode1,upNode2);
            size.set(upNode2,size.get(upNode1)+size.get(upNode2));
        }
        else{
            parent.set(upNode2,upNode1);
            size.set(upNode1,size.get(upNode1)+size.get(upNode2));
        }
    }
    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet(7);
        disjointSet.unionBySize(1,2);
        disjointSet.unionBySize(2,3);
        disjointSet.unionBySize(4,5);
        disjointSet.unionBySize(6,7);
        disjointSet.unionBySize(5,6);
        if(disjointSet.findUParent(3) == disjointSet.findUParent(7)){
            System.out.println("Same");
        }
        else{
            System.out.println("Not Same");
        }
        disjointSet.unionBySize(3,7);
        if(disjointSet.findUParent(3) == disjointSet.findUParent(7)){
            System.out.println("Same");
        }
        else{
            System.out.println("Not Same");
        }
    }
}
