import java.util.Arrays;

public class DynamicProgramming {
    public static void main(String[] args) {
//        int height[]={30,10,60 , 10 , 60 , 50};
//        System.out.println(frogJumpBotomDown(height));
//        System.out.println(frogJumpBottomUp(height));

//        int value[] = {1,2,3,1,3,5,8,1,9};
//        int n = value.length;
//        int[] dp = new int[n];
//        Arrays.fill(dp,-1);
//        System.out.println(sumOfNonAdjacentElementsTopDown(n-1, value,dp));
//        System.out.println(sumOfNonAdjacentElementsBottomup( value,dp));

        int value[] = {1,5,2,1,6};
        int n = value.length;
        System.out.println(houseRobber(value,n));
    }

//    A thief needs to rob money in a street. The houses in the street are arranged in a circular manner. Therefore the first and the last house are adjacent to each other. The security system in the street is such that if adjacent houses are robbed, the police will get notified.
//    Given an array of integers “Arr'' which represents money at each house, we need to return the maximum amount of money that the thief can rob without alerting the police.
    public static int houseRobber(int[] values,int n){
        int[] first = new int[n-1];
        int[] second = new int[n-1];
        for(int i=1;i<n;i++){
            first[i-1] = values[i];
        }
        for(int i=0;i<n-1;i++){
            second[i] = values[i];
        }
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int left = sumOfNonAdjacentElementsBottomup(first,dp);
        int right = sumOfNonAdjacentElementsBottomup(second,dp);
        return Math.max(left,right);
    }
//    Given an array of ‘N’  positive integers, we need to return the maximum sum of the subsequence such that no two elements of the subsequence are adjacent elements in the array.
//    Note: A subsequence of an array is a list with elements of the array where some elements are deleted ( or not deleted at all) and the elements should be in the same order in the subsequence as in the array.
    public static int sumOfNonAdjacentElementsTopDown(int n,int[] value,int[] dp){
        if(n<0) return 0;
        if(n==0) return value[n];
        if(dp[n] != -1) return dp[n];
        int pick = value[n] + sumOfNonAdjacentElementsTopDown(n-2,value,dp);
        int nonPick = sumOfNonAdjacentElementsTopDown(n-1,value,dp);
        return dp[n] = Math.max(pick,nonPick);
    }
    public static int sumOfNonAdjacentElementsBottomup(int[] value,int[] dp){
        dp[0]=value[0];
        for(int i=1;i<value.length;i++){
            int pick = value[i];
            if(i>1){
                pick+= dp[i-2];
            }
            int nonPick = dp[i-1];
            dp[i] = Math.max(pick,nonPick);
        }
        return dp[value.length-1];
    }

    //Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair. At a time the frog can climb either one or two steps. A height[N] array is also given. Whenever the frog jumps from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. We need to return the minimum energy that can be used by the frog to jump from stair 0 to stair N-1.
    public static int frogJumpBotomDown(int[] heights) {
        int[] dp = new int[heights.length];
        Arrays.fill(dp,-1);
        return frogJumpDp(heights.length-1,heights,dp);
    }
    static int frogJumpDp(int n, int[] heights, int[] dp) {
        if(dp[n]!=-1) return dp[n];
        if(n==0) return 0;
        int left = frogJumpDp(n-1,heights,dp) + Math.abs(heights[n]-heights[n-1]);
        int right = Integer.MAX_VALUE;
        if(n>1){
            right = frogJumpDp(n-2,heights,dp)+Math.abs(heights[n]-heights[n-2]);
        }
        return dp[n] = Math.min(left,right);
    }
    public static int frogJumpBottomUp(int heights[]){
        int n= heights.length;
        int dp[] = new int[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            int jumpOne = dp[i-1] + Math.abs(heights[i]-heights[i-1]);
            int jumpTwo =Integer.MAX_VALUE;
            if(i>1){
                jumpTwo = dp[i-2] + Math.abs(heights[i]-heights[i-2]);
            }
            dp[i] = Math.min(jumpOne,jumpTwo);
        }
        return dp[n-1];
    }
}
