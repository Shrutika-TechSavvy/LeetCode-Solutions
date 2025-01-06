class Solution {
    class Pair{
        String first;
        int second;

        public Pair(String _first, int _second){
            this.first=_first;
            this.second=_second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        //The queue is required 
        Queue<Pair> queue=new LinkedList<>();

        // Initialize BFS with the beginWord
        queue.offer(new Pair(beginWord, 1));


        Set<String> set=new HashSet<>();
        int lengthOfWordlist=wordList.size();


        //Adding all the wordsin the set
        for(int i=0; i<lengthOfWordlist; i++){
            set.add(wordList.get(i));
        }

         if (!set.contains(endWord)) {
            return 0;
        }

        set.remove(beginWord);

        while(!queue.isEmpty()){
            String word=queue.peek().first;
            int steps=queue.peek().second;

            queue.poll();

            if(word.equals(endWord)) return steps;

            //else we need to find
            for(int i=0; i<word.length(); i++){

                //for each character of the word check for the a to z combinations
                for(char ch='a'; ch<='z' ;ch++){
                    char replacedCharArray[]=word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedWord= new String(replacedCharArray);

                    //If the newly created word is presented in set, then
                    if(set.contains(replacedWord)){

                        //remove it from the set
                        set.remove(replacedWord);    // Remove to avoid re-visiting
                        queue.offer(new Pair(replacedWord, steps+1));
                    }
                }
            }

        }

        return 0;
    }
}