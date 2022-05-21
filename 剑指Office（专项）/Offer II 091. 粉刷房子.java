class Solution {
    public int minCost(int[][] costs) {
        int red = costs[0][0];
        int green = costs[0][1];
        int blue = costs[0][2];

        for (int i = 1; i < costs.length; i++) {
            int redNext = costs[i][0] + Math.min(green, blue);
            int greenNext = costs[i][1] + Math.min(red, blue);
            int blueNext = costs[i][2] + Math.min(green, red);
            red = redNext;
            green = greenNext;
            blue = blueNext;
        }
        return Math.min(Math.min(red, green), blue);
    }
}
