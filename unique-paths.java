class Solution {
    public int uniquePaths(int m, int n){
        //Key: Position in the grid -> (x, y) -> x:y
        //Value: Total ways to reach to the bottom-right corner
        HashMap<String, Integer> map = new HashMap<>();

        //Getting x and y to make a 0-indexed grid
        int x = m - 1;
        int y = n - 1;

        //From to bottom-right to the bottom-right = 1
        map.put(x + ":" + y, 1);

        return uniquePaths(m, n, 0, 0, map);
    }

    public int uniquePaths(int m, int n, int x, int y, HashMap<String, Integer> map){
        //If we have already been in this position before
        //just return the amount saved in the map
        if(map.containsKey(x + ":" + y)) return map.get(x + ":" + y);

        int right = 0;  //Total ways going right (moving in the X-axis)
        int down = 0;   //Total ways going down (moving in the Y-axis)

        //Checking if we haven't arrived to a limit in the grid
        if(x + 1 < m){
            right = uniquePaths(m, n, x+1, y, map);
        }
        if(y + 1 < n){
            down = uniquePaths(m, n, x, y+1, map);
        }

        //Adding total was of both together
        int total = right + down;

        //Adding to the map to re-use it in a future cycle
        map.put(x + ":" + y, total);

        return total;
    }
}
