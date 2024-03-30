import java.util.ArrayList;
import java.util.List;

public class RecursionPermutation
{
    public static void main(String[] args)
    {
//        int print =printStringPermutationsInteger("","abcdef");
//        System.out.println(print);
        permutationMobilePhoneLeetcode("","234");
    }
    public static void printStringPermutations(String up,String p)
    {
        if(p.isEmpty())
        {
            System.out.println(up);
            return;
        }
        int n= up.length();
        for(int i=0;i<=n;i++)
        {
            printStringPermutations(up.substring(0,i)+p.charAt(0)+up.substring(i,n),p.substring(1));
        }
    }
    public static List<String> printStringPermutationsList(String up,String p)
    {
        List<String> ans = new ArrayList<String>();
        if(p.isEmpty())
        {
            ans.add(up);
            return ans;
        }
        int n= up.length();
        for(int i=0;i<=n;i++)
        {
            List<String> dummy = printStringPermutationsList(up.substring(0,i)+p.charAt(0)+up.substring(i,n),p.substring(1));
            ans.addAll(dummy);
        }
        return ans;
    }
    public static int printStringPermutationsInteger(String up,String p)
    {
        int ans =0;
        if(p.isEmpty())
        {
            ans++;
            return ans;
        }
        int n= up.length();
        for(int i=0;i<=n;i++)
        {
            int size = printStringPermutationsInteger(up.substring(0,i)+p.charAt(0)+up.substring(i,n),p.substring(1));
            ans=ans+size;
        }
        return ans;
    }
    public static void permutationMobilePhoneLeetcode(String p,String up)
    {
        if(up.isEmpty())
        {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        for (int i = (digit-1)*3; i < (digit*3); i++)
        {
            char ch = (char)('a'+i);
            permutationMobilePhoneLeetcode(p+ch,up.substring(1));
        }
    }
    public static void DigitsLeetcodeProblem(String p,int up,int target)
    {

    }
}

