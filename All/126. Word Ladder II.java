public class Solution
{
    Map<String,List<String>> map;
	List<List<String>> results;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList)
    {
        results= new ArrayList<List<String>>();
        if (wordList.size() == 0)
			return results;
        
        int min=Integer.MAX_VALUE;
        
        Queue<String> queue= new ArrayDeque<String>();
        queue.add(beginWord);
        
		map = new HashMap<String,List<String>>();
		
		Map<String,Integer> ladder = new HashMap<String,Integer>();
		for (String string:wordList)
		    ladder.put(string, Integer.MAX_VALUE);
		ladder.put(beginWord, 0);
				
		wordList.add(endWord);
		//BFS: Dijisktra search
		while (!queue.isEmpty()) {
		   
			String word = queue.poll();
			
			int step = ladder.get(word)+1;//'step' indicates how many steps are needed to travel to one word. 
			
			if (step>min) break;
			
			for (int i = 0; i < word.length(); i++){
			   StringBuilder builder = new StringBuilder(word); 
				for (char ch='a';  ch <= 'z'; ch++){
					builder.setCharAt(i,ch);
					String new_word=builder.toString();				
					if (ladder.containsKey(new_word)) {
							
					    if (step>ladder.get(new_word))//Check if it is the shortest path to one word.
					    	continue;
					    else if (step<ladder.get(new_word)){
					    	queue.add(new_word);
					    	ladder.put(new_word, step);
					    }else;// It is a KEY line. If one word already appeared in one ladder,
					          // Do not insert the same word inside the queue twice. Otherwise it gets TLE.
					    
					    if (map.containsKey(new_word)) //Build adjacent Graph
					    	map.get(new_word).add(word);
					    else{
					    	List<String> list= new LinkedList<String>();
					    	list.add(word);
					    	map.put(new_word,list);
					    	//It is possible to write three lines in one:
					    	//map.put(new_word,new LinkedList<String>(Arrays.asList(new String[]{word})));
					    	//Which one is better?
					    }
					    
					    if (new_word.equals(endWord))
					    	min=step;

					}//End if dict contains new_word
				}//End:Iteration from 'a' to 'z'
			}//End:Iteration from the first to the last
		}//End While

    	//BackTracking
		LinkedList<String> result = new LinkedList<String>();
		backTrace(endWord,beginWord,result);

		return results;  
    }
    
    private void backTrace(String word,String start,List<String> list){
    	if (word.equals(start)){
    		list.add(0,start);
    		results.add(new ArrayList<String>(list));
    		list.remove(0);
    		return;
    	}
    	list.add(0,word);
    	if (map.get(word)!=null)
    		for (String s:map.get(word))
    			backTrace(s,start,list);
    	list.remove(0);
    }
}
