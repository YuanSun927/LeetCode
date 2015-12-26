/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.
*/
public class _42_TrappingRainWater {
    
    public int trap1(int[] height) {
        if (height == null || height.length < 3)
            return 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[max]) {
                max = i;
            }
        }
        int water = 0;
        for (int i = 0, peak = 0; i < max; i++) {
            peak = Math.max(height[i], peak);
            water += peak - height[i];
        }
        for (int i = height.length - 1, peak = 0; i > max; i--) {
            peak = Math.max(height[i], peak);
            water += peak - height[i];
        }
        return water;
    }
}