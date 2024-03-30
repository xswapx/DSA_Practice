import java.util.ArrayList;

public class Recursion
{
    public static void main(String args[])
    {
//        System.out.println(sortArrayRecursion(new int[]{1,2,3,4,5,9,3},0));
//        System.out.println(linearSearchRecursion(new int[]{1,2,3,4,5,9,3},3,0));
        System.out.println(rotatedBinarySearch(new int[]{5,6,7,1,2,3,4},3,0,6));
    }
    static boolean checkSortArrayRecursion(int arr[],int index)
    {
        if(index == arr.length-1) return true;

        return arr[index] < arr[index+1] && checkSortArrayRecursion(arr,index+1);
    }

    static boolean linearSearchRecursion(int arr[],int target,int i)
    {
        if(i >= arr.length) return false;

        return (arr[i]==target) || linearSearchRecursion(arr,target,i+1);
    }

    static int rotatedBinarySearch(int arr[],int target,int s,int e)
    {
        if(s > e) return -1;

        int mid  = s + (e-s) / 2;
        if(arr[mid] == target) return mid;

        if(arr[s] <= arr[mid])
        {
            if(target >= arr[s] && target <= arr[mid]) return rotatedBinarySearch(arr,target,s,mid-1);
            else return rotatedBinarySearch(arr,target,mid+1,e);
        }
        if(target >= arr[mid] && target <= arr[e]) return rotatedBinarySearch(arr,target,mid+1,e);
        return rotatedBinarySearch(arr,target,s,mid-1);
    }
}
