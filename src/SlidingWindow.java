import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindow
{
    public static void main(String[] args)
    {
//        System.out.println(maxWindowSum(new int[]{1,2,3,9,-9,9,3},3));
//        System.out.println(firstNegNumInEveryWin(new int[]{2,3,-3,-5,-8,10,-9,-12,-13,14},3));
//        System.out.println(countAnagram("forxxforxforxxxfor","for"));
    }

    public static int maxWindowSum(int[] arr,int B)
    {
        int maxSum = Integer.MIN_VALUE;
        int i=0,j=1;
        int sum = arr[i];
        while(j<arr.length)
        {
            sum += arr[j];
            if((j-i+1)==B)
            {
                maxSum = Math.max(sum,maxSum);
                sum -= arr[i];
                i++;
            }
            j++;
        }
        return maxSum;
    }
    public static ArrayList<Integer> firstNegNumInEveryWin(int[] arr,int B)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int i=0,j=i;
        while(j<arr.length)
        {
            if(arr[j] < 0)
            {
                queue.add(arr[j]);
            }
            if((j-i+1)==B)
            {
                if(!queue.isEmpty())
                {
                    if(queue.peek() != arr[i])
                    {
                        ans.add(queue.peek());
                    }
                    else
                    {
                        ans.add(queue.peek());
                        queue.remove();
                    }
                }
                i++;
            }
            j++;
        }
        return ans;
    }

//    TO BE WORKED................................
//    public static int countAnagram(String s, String p)
//    {
//        int ans=0;
//        HashMap<Character,Integer> map = new HashMap<>();
//        int i=0,j=i;
//        for(char ch : p.toCharArray())
//        {
//            map.put(ch,map.getOrDefault(ch,0)+1);
//        }
//        int count = map.size();
//        while(j < s.length())
//        {
//            char ch = s.charAt(j);
//            if(map.containsKey(ch))
//            {
//                map.put(ch,map.get(ch)-1);
//                count = map.get(ch) == 0 ? --count : count;
//            }
//
//            if((j-i+1)==p.length())
//            {
//                if(map.containsKey(ch))
//                {
//                    if(count==0) ans++;
//                    i++;
//                    if((j+1<s.length()) && map.containsKey(s.charAt(j + 1)) ) {
//                        map.put(s.charAt(j + 1), map.getOrDefault(s.charAt(j + 1), 0) + 1);
//                        count++;
//                    }
//                }
//            }
//            j++;
//        }
//        return ans;
//    }
}
