Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]
**********************************************************************************
public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long prev = (long)lower - 1; // int -> long
        long curr = 0;
        for(int i = 0; i <= nums.length; i++) {
            curr = i == nums.length ? (long)upper + 1: (long)nums[i]; // int -> long
            if(prev + 2 == curr) {
                res.add((prev + 1) + "");
            } else if(prev + 2 < curr) {
                res.add((prev + 1) + "->" + (curr - 1));
            }
            prev = curr;
        }
        return res;
    }
