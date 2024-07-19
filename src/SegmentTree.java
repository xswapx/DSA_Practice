public class SegmentTree {
    private static class Node{
        int data;
        int start;
        int end;
        Node left;
        Node right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    Node root;

    public SegmentTree(int[] arr) {
        root = constructSegmentTree(arr,0,arr.length-1);
    }

    public static void main(String[] args) {
        int arr[] = {3,8,6,7,-2,-8,4,9};
        SegmentTree tree = new SegmentTree(arr);
        System.out.println(tree.query(tree.root,0,1));
        tree.updatingValue(tree.root,0,2);
        System.out.println(tree.query(tree.root,0,1));
    }

    public Node constructSegmentTree(int[] arr,int start,int end){
        if(start==end){
            Node node = new Node(start,end);
            node.data = arr[start];
            return node;
        }
        Node node = new Node(start,end);
        int mid = (start+end)/2;
        node.left = constructSegmentTree(arr,start,mid);
        node.right = constructSegmentTree(arr,mid+1,end);
        node.data = node.left.data + node.right.data;
        return node;
    }

    public int query(Node node,int s,int e)
    {
        if(node.start > e || node.end < s ) return 0;
        if(node.start >= s && node.end <=e) return node.data;
        int left = query(node.left,s,e);
        int right = query(node.right,s,e);
        return left+right;
    }

    public int updatingValue(Node node,int index,int newVal)
    {
        if(node.start <= index && node.end >= index ) {
            if (node.start == index && node.end == index) {
                node.data = newVal;
                return node.data;
            } else {
                int left = updatingValue(node.left, index, newVal);
                int right = updatingValue(node.right, index, newVal);
                node.data = left + right;
                return node.data;
            }
        }
        return node.data;
    }
}
