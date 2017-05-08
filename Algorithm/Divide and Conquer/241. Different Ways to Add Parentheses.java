public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<>();
        for(int i = 0; i < input.length(); ++i) {
            if(input.charAt(i) == '+' ||
               input.charAt(i) == '-' ||
               input.charAt(i) == '*') {
                   String part1 = input.substring(0, i);
                   String part2 = input.substring(i + 1);
                   List<Integer> part1res = diffWaysToCompute(part1);
                   List<Integer> part2res = diffWaysToCompute(part2);
                   for(Integer p1 : part1res) {
                       for(Integer p2 : part2res) {
                           int c = 0;
                           switch(input.charAt(i)) {
                               case '-': c = p1 - p2;
                                    break;
                               case '+': c = p1 + p2;
                                    break;
                               case '*': c = p1 * p2;
                                    break;
                           }
                           res.add(c);
                       }
                   }
               }
        }
        if(res.size() == 0)
            res.add(Integer.valueOf(input));
        return res;
    }
}
