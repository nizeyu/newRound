public class Solution
{
    public int[][] reconstructQueue(int[][] people)
    {   
        for(int i = 0; i < people.length; i++)
        {
            for(int j = i + 1; j < people.length; j++)
            {
                if(people[i][0] < people[j][0])
                    swap(people, i, j);
                else if(people[i][0] == people[j][0] && people[i][1] > people[j][1])
                    swap(people, i, j);
            }
        }
        
        List<Integer> l0 = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        for(int i = 0; i < people.length; i++)
        {
            l0.add(people[i][1], people[i][0]);
            l1.add(people[i][1], people[i][1]);
        }
        
        for(int i = 0; i < people.length; i++)
        {
            people[i][0] = l0.get(i);
            people[i][1] = l1.get(i);
        }
        return people;
    }
    
    private void swap(int[][] people, int i, int j)
    {
        int temp1 = people[i][0];
        int temp2 = people[i][1];
        people[i][0] = people[j][0];
        people[j][0] = temp1;
        people[i][1] = people[j][1];
        people[j][1] = temp2;
    }
}
