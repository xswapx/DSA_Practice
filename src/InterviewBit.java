import java.util.ArrayList;
import java.util.Collections;

public class InterviewBit {
    public int Pick_from_both_sides(ArrayList<Integer> A, int B)
    {
        ArrayList<Integer> preSum = new ArrayList<>(A.size());
        ArrayList<Integer> pstSum = new ArrayList<>(A.size());

        int sum=0;
        for(int x : A)
        {
            sum = sum + x;
            preSum.add(sum);
        }
        sum = 0;
        for(int i = A.size()-1;i>=0;i--)
        {
            sum += A.get(i);
            pstSum.add(sum);
            if(i==0)
            {
                Collections.reverse(pstSum);
            }
        }
        int maxAns=Integer.MIN_VALUE;
        sum = 0;
        for(int i=0;i<B;i++)
        {
            int backSum = (i < (B-1)) ? pstSum.get(pstSum.size() - (B-(i+1))) : 0;
            sum = preSum.get(i) + backSum;
            maxAns = Math.max(maxAns,sum);
            sum=0;
        }
        maxAns = Math.max(maxAns,pstSum.get(pstSum.size()-B));
        return maxAns;
    }
}
