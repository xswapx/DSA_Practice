import java.util.ArrayList;

public class SlidingWindow
{
    public static void main(String[] args)
    {
        System.out.println(maxWindowSum(new int[]{1,2,3,9,-9,9,3},3));
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
        return null;
    }
}
