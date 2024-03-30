import java.util.ArrayList;

public class RecursionString {
    public static void main(String args[]) {
//        char ch = 'a';
//        System.out.println("abc" + (ch+0));
//        System.out.println(missCharacter("bccddee",0,"",'d'));
//        System.out.println(missCharacter1("bccddee",0,'d'));
//        System.out.println(skipString("sexyapple_swapnil",0,"_swap"));
//        printSubstring("","abc");
//        System.out.println(printSubstringReturn("","abc"));
        ArrayList<ArrayList<Integer>> ans = subsequenceIterativeDuplicate(new int[]{1,2,2});
        for(ArrayList<Integer> dummy : ans)
        {
            System.out.println(dummy);
        }
//        ArrayList<ArrayList<Integer>> sample = new ArrayList<>();
//        ArrayList<Integer> first = new ArrayList<>();
//        ArrayList<Integer> sec = new ArrayList<>();
//        ArrayList<Integer> third = new ArrayList<>();
//        ArrayList<Integer> fourth = new ArrayList<>();
//        first.add(1);
//        first.add(2);
//        sec.add(1);
//        sec.add(2);
//        sec.add(3);
//        sample.add(first);
//        System.out.println(sample.contains(sec));
    }

    public static String missCharacter(String s, int index, String ans, char target) {
        if (index >= s.length()) {
            return ans;
        }
        if (s.charAt(index) == target) {
            return missCharacter(s, index + 1, ans, target);
        } else {
            ans = ans + s.charAt(index);
            return missCharacter(s, index + 1, ans, target);
        }
    }

    public static String missCharacter1(String s, int index, char target) {
        if (index >= s.length()) {
            return "";
        }
        if (s.charAt(index) != target) {
            return s.charAt(index) + missCharacter1(s, index + 1, target);
        } else {
            return missCharacter1(s, index + 1, target);
        }
    }

    public static String skipString(String s, int index, String target) {
        if (index >= s.length()) {
            return "";
        }
        if (!(s.substring(index).startsWith(target))) {
            return s.charAt(index) + skipString(s, index + 1, target);
        } else {
            return skipString(s,index+target.length(),target);
        }
    }

    public static void printSubstring(String p,String up)
    {
        if(up.isEmpty())
        {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        printSubstring(p+ch,up.substring(1));
        printSubstring(p,up.substring(1));
    }
    public static ArrayList<String> printSubstringReturn(String p,String up)
    {
        if(up.isEmpty())
        {
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String> left = printSubstringReturn(p+ch,up.substring(1));
        ArrayList<String> right = printSubstringReturn(p,up.substring(1));
        left.addAll(right);
        return left;
    }

    public static ArrayList<ArrayList<Integer>> subsequenceIterative(int[] arr)
    {
        ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<Integer>());
        for(int num : arr)
        {
            int outerListSize = outerList.size();
            for(int i=0;i<outerListSize;i++)
            {
                ArrayList<Integer> internal = new ArrayList<Integer>(outerList.get(i));
                internal.add(num);
                outerList.add(internal);
            }
        }
        return outerList;
    }
    public static ArrayList<ArrayList<Integer>> subsequenceIterativeDuplicate(int[] arr)
    {
        ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<Integer>());
        for(int num : arr)
        {
            int outerListSize = outerList.size();
            for(int i=0;i<outerListSize;i++)
            {
                ArrayList<Integer> internal = new ArrayList<Integer>(outerList.get(i));
                internal.add(num);
                if(!(outerList.contains(internal)))
                {
                    outerList.add(internal);
                }

            }
        }
        return outerList;
    }
}
