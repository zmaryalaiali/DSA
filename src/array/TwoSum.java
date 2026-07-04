package array;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.deepToString(twoSum.nums));
        System.out.println(twoSum.rotateMitrix(twoSum.nums));
        System.out.println(Arrays.deepToString(twoSum.nums));

    }

    public int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    public int[] nums1 = {5, 1, 1, 4, 2, 2};

    public boolean rotateMitrix(int mitrix[][]) {
        if (mitrix.length == 0 || mitrix.length != mitrix[0].length)
            return false;
        int n = mitrix.length;
        for (int i = 0; i < n / 2; i++) {
            int first = i;
            int last = n - i - 1;
            for (int j = first; j < last; j++) {
                int offeSet = j - first;
                int top = mitrix[first][j];
                mitrix[first][j] = mitrix[last - offeSet][first];
                mitrix[last - offeSet][first] = mitrix[last][last - offeSet];
                mitrix[last][last - offeSet] = mitrix[i][last];
                mitrix[i][last] = top;


            }
        }
        return true;
    }

//    public int[] towSum(int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (target == nums[i] + nums[j]) {
//                    return new int[]{nums[i], nums[j]};
//                }
//            }
//        }
//        throw new IllegalArgumentException("no solution found");
//    }

//    public String pairMulti() {
//        int multi = 0;
//        String result = null;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] * nums[j] > multi) {
//                    multi = nums[i] * nums[j];
//                    result = Integer.toString(nums[i]) + "  " + Integer.toString(nums[j]);
//                }
//            }
//        }
//        return result;
//    }

    public boolean isUnique() {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1 + i; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean permutaion(int[] array1, int[] array2) {
        if (array2.length != array2.length)
            return false;
        int sum1 = 0, sum2 = 0, mul1 = 1, mul2 = 1;
        for (int i = 0; i < array1.length; i++) {
            sum2 += array2[i];
            sum1 += array1[i];
            mul1 *= array1[i];
            mul2 *= array2[i];

        }

        if (sum2 == sum1 && mul1 == mul2)
            return true;
        return false;
    }

    public int[] towCommon(int[] array2, int[] array1) {
        int[] common = new int[array1.length];
        int size = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    common[size] = array1[i];
                    size++;
                    break;
                }
            }
        }
        if (common[0] != 0) {
            return common;
        }
        return null;
    }
}
