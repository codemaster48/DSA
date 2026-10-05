class Solution {
    public int thirdMax(int[] nums) {

        Long largest = null;
        Long second = null;
        Long third = null;

        for (int i = 0; i < nums.length; i++) {

            // duplicate ko ignore karo
            if ((largest != null && nums[i] == largest) ||
                (second != null && nums[i] == second) ||
                (third != null && nums[i] == third)) {
                continue;
            }

            // largest
            if (largest == null || nums[i] > largest) {
                third = second;
                second = largest;
                largest = (long) nums[i];
            }

            // second largest
            else if (second == null || nums[i] > second) {
                third = second;
                second = (long) nums[i];
            }

            // third largest
            else if (third == null || nums[i] > third) {
                third = (long) nums[i];
            }
        }

        // 3 distinct values nahi hain
        if (third == null) {
            return largest.intValue();
        }

        return third.intValue();
    }
}