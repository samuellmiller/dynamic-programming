class Solution {
    public int climbStairs(int n){
        //Key: Step in the staircase
        //Value: Total ways to reach to the top
        HashMap<Integer, Integer> map = new HashMap<>();

        //From the top to the top = 1
        map.put(n, 1);
        
        return climbStairs(n, 0, map);
    }

    public int climbStairs(int n, int curr, HashMap<Integer, Integer> map){
        //If we have already been in this step before
        //just return the amount saved in the map
        if(map.containsKey(curr)) return map.get(curr);

        int oneStep = 0;    //If I take one step
        int twoSteps = 0;   //If I take two steps

        //Checking if we haven't arrived to the top limit
        if(curr + 1 <= n){
            oneStep = climbStairs(n, curr+1, map);
        }

        if(curr + 2 <= n){
            twoSteps = climbStairs(n, curr+2, map);
        }

        //Adding the total ways of both together
        int total = oneStep + twoSteps;

        //Adding to the map to re-use it in a future cycle
        map.put(curr, total);

        return total;
    }
}
