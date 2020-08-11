class Solution {
    public int rob(int[] nums){
        //Key: House position
        //Value: Amount of money from robbing that house and all the possible ones
        HashMap<Integer, Integer> map = new HashMap<>();

        //Initialize the max total
        int total = 0;

        //Loop through all the houses starting from the house in the position i
        for(int i = 0; i < nums.length; i++){
            total = Math.max(total, rob(nums, i, map));
        }

        return total;
    }

    public int rob(int[] nums, int curr, HashMap<Integer, Integer> map){
        //If we have already calculated how much money we could make
        //by robbing that house, then just return the amount saved in the map
        if(map.containsKey(curr)) return map.get(curr);

        int aux = 2;    //Initialize by robbing the house 2 positions ahead
        int total = 0;  //Initialize the max total

        while(curr + aux < nums.length){
            total = Math.max(total, rob(nums, curr+aux, map));
            aux++;
        }

        //Add the amount of money stashed in the current house to the total
        total += nums[curr];

        //Add the total amount to the map to re-use it in a future cycle
        map.put(curr, total);

        return total;
    }
}
