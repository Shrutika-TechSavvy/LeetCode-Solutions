class Solution {

    class Pair{
        String first;
        int second;

        Pair(String f, int s){
            this.first = f;
            this.second = s;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        Set<String> set=new HashSet<>();
        int lengthOfWordList=wordList.size();

        for(int i=0; i<lengthOfWordList; i++){
            set.add(wordList.get(i));
        }

        if(!set.contains(endWord)) return 0;
        set.remove(beginWord);

        while(!queue.isEmpty()){
            String word=queue.peek().first;
            int steps=queue.peek().second;
            queue.poll();
            if(word.equals(endWord)) return steps;

            //else need to ifnd
            for(int i=0; i<word.length(); i++){
                //for each character of word check for a to z combinations

                for(char ch='a' ; ch<='z' ; ch++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i]= ch;
                    String replacedWord = new String(replacedCharArray);
                    //if newly created word is presented in set, then
                    if(set.contains(replacedWord)){
                        //remove it from set
                        set.remove(replacedWord);  //remove to avoid revisiting
                        queue.offer(new Pair(replacedWord ,steps+1));
                    }
                }
            }
        }

        return 0;
    }
}