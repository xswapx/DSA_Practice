import java.util.Stack;

public class Leetcode {
    public static void main(String[] args) {

        System.out.println(removeDuplicates("abbaca"));
//        System.out.println(backspaceCompare("y#fo##f","y#f#o##f"));
//        calPoints(new String[]{"36","28","70","65","C","+","33","-46","84","C"});
//        int ans[] = Leetcode66(new int[]{9,9,9});
//        for(int x : ans)
//        {
//            System.out.print(x+", ");
//        }
//        System.out.println(mySqrt(1));
//        SeiveofEratostenes(40);
//        MinHeap heap = new MinHeap();
//        int arr[] = new int[]{7, 2, 8, 10, 6, 4, 5, 3, 9, 1, 0};
//        for (int i = 0; i < arr.length; i++) {
//            heap.insertNumber(arr[i]);
//        }
//        for (int j = 0; j < arr.length; j++) {
//            System.out.println("Removed Element from Heap -> " + heap.removeMinEement());
//        }
//        heap.displayHeap();
    }

    public static int[] Leetcode66(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void SeiveofEratostenes(int n) {
        boolean[] primes = new boolean[n + 1];
        int size = primes.length;
        for (int i = 2; i * i <= size; i++) {
            if (!primes[i]) {
                int count = 2;
                for (int j = 2 * i; j <= n; j = j + i) {
                    primes[j] = true;
                }
            }
        }
        for (int x = 2; x < primes.length; x++) {
            if (!primes[x]) {
                System.out.print(x + ",");
            }
        }
    }

    public static int mySqrt(int x) {
        int ans = 0;
        for (long i = 1; i <= x; i++) {
            if (i * i <= x) {
                ans = (int) i;
//                System.out.println(ans);
            }
        }
        return ans;
    }

    public static int calPoints(String[] operations)
    {
        Stack<Integer> stk = new Stack<>();
        for(String s : operations)
        {
            if(s.equalsIgnoreCase("D"))
            {
                Integer num = Integer.valueOf(stk.peek() * 2);
                stk.push(num);
            }
            else if(s.equalsIgnoreCase("C"))
            {
                stk.pop();
            }
            else if(s.equalsIgnoreCase("+"))
            {
                int temp = stk.pop();
                int toPush = temp + stk.peek();
                stk.push(temp);
                stk.push(toPush);
            }
            else
            {
                stk.push(Integer.valueOf(s));
            }
        }

        int ans=0;
        while(!stk.isEmpty())
        {
            ans = ans+stk.pop();
        }
        return ans;
    }

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stk1 = new Stack<>();
        Stack<Character> stk2 = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='#')
            {
                if(stk1.isEmpty()) continue;
                stk1.pop();
            }
            else
            {
                stk1.push(ch);
            }
        }
        for(int i=0;i<t.length();i++)
        {
            char ch = t.charAt(i);
            if(ch=='#')
            {
                if(stk2.isEmpty()) continue;
                stk2.pop();
            }
            else
            {
                stk2.push(ch);
            }
        }

        if(stk1.size()!= stk2.size()) return false;

        while(!stk1.isEmpty() && !stk2.isEmpty())
        {
            if(stk1.peek()!=stk2.peek()) return false;
            stk1.pop();
            stk2.pop();
        }
        return true;
    }

    public static String removeOuterParentheses(String s) {
        Stack<Character> stk = new Stack<>();
        stk.push(s.charAt(0));
        String ans="",temp="";
        for(int i=1;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='(')
            {
                stk.push(ch);
                if(stk.size()==1) continue;
            }
            else stk.pop();
            if(!stk.isEmpty()) temp=temp+ch;
            if(stk.isEmpty()){
                ans=ans+temp;
                temp="";
            }
        }
        return ans;
    }
    public static String removeDuplicates(String s)
    {
        String ans="";
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(!stk.isEmpty() && stk.peek() == ch) stk.pop();
            else stk.push(ch);
        }
        while(stk.isEmpty())
        {
            ans=stk.pop()+ans;
        }
        return ans;
    }


}
