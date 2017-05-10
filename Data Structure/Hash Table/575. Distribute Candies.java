//My Solution
public class Solution {
    public int distributeCandies(int[] candies) {
        if(candies.length % 2 != 0)
            return 0;
        
        Set<Integer> set = new HashSet<>();
        for(Integer candie : candies)
            set.add(candie);
        
        return set.size() > candies.length/2 ? candies.length/2 : set.size();
    }
}
