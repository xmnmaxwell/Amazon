给定两个array of int，返回在两个array里都出现过的int，并且去掉重复的，比如[1,2,3,4], [2,2,3,4] 输出[2,3,4] 
********************************************************************************
 public List<Integer> findDuplicate(int[] nums1, int[] nums2){
         Set<Integer> set = new HashSet<>();
         List<Integer> list = new ArrayList<>();
         for (int num : nums1){
             set.add(num);
         }
         for (int num : nums2){
             if (set.contains(num)){
                 list.add(num);
                 set.remove(num);
             }
         }
        return list;
     } 
 *******************************************************************************
 给定一个input string，判断每个char出现的次数是否为连续+1的sequence。比如 banana, 应该返回true因为b出现1次，n 2次，a 3次。若input为bandana应该返回false，因为sequence为[1,1,2,3]，出现了两个连续的1
  public static boolean pyramidString(String str){
         if (str.length() == 0 || str == null) return true;
        int[] charFreq = new int[26];
        
        for (char c : str.toCharArray()){
            charFreq[c - 'a']++; 
        }
        Arrays.sort(charFreq);
        for (int i = 25; i >= 1; i--){
            if (charFreq[i-1] != 0 && charFreq[i] - 1 != charFreq[i-1]) {
                return false;
            }
        }
        return true;
     } 
  ********************************************************************************
  public int maxTurbulenceSize(int[] A) {
        if (A.length <= 2)
            return A.length;
        
        int max = 1, current = 2;
        for (int i = 1; i < A.length - 1; i++) {
            if ((A[i - 1] < A[i] && A[i] > A[i + 1]) || (A[i - 1] > A[i] && A[i] < A[i + 1]))
                current += 1;
            else
                current = 2;
           max = Math.max(max, current);
        }
        return max;
    }
    *********************************************************************************
     public List<List<Integer>> twoSum(int[] arr, int target){
        int i = 0, j = arr.length - 1;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        while (i < j) {
            if (arr[i]+arr[j] == target) {
                res.add(Arrays.asList(arr[i], arr[j]));
                i++;
                j--;
            } else if (arr[i]+arr[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;
     } 
