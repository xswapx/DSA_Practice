public class Leetcode {
    public static void main(String[] args) {
//        int ans[] = Leetcode66(new int[]{9,9,9});
//        for(int x : ans)
//        {
//            System.out.print(x+", ");
//        }
//        System.out.println(mySqrt(1));
//        SeiveofEratostenes(40);
        MinHeap heap = new MinHeap();
        int arr[] = new int[]{7, 2, 8, 10, 6, 4, 5, 3, 9, 1, 0};
        for (int i = 0; i < arr.length; i++) {
            heap.insertNumber(arr[i]);
        }
        for (int j = 0; j < arr.length; j++) {
            System.out.println("Removed Element from Heap -> " + heap.removeMinEement());
        }
        heap.displayHeap();
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

}
