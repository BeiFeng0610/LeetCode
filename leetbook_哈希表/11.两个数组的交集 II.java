class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;

        int index1 = 0;
        int index2 = 0;
        int count = 0;
        int[] temp = new int[Math.min(len1,len2)];

        while(index1 < len1 && index2 < len2){
            if(nums1[index1] < nums2[index2]){
                index1++;
            }else if(nums1[index1] > nums2[index2]){
                index2++;
            }else{
                temp[count] = nums1[index1];
                count++;
                index1++;
                index2++;
            }

        }
        return Arrays.copyOfRange(temp,0,count);
    }
}
