

class Trie {
    class TrieNode{
        TrieNode links[] = new TrieNode[26];
        boolean flag = false;
    }
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for(int i=0 ; i<word.length(); i++){
            char ch = word.charAt(i);
            if(current.links[ch-'a'] == null){
                //Insert here the character;
                current.links[ch-'a'] = new TrieNode();
            }
            current = current.links[ch-'a'];
        }
        current.flag=true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for(int i=0 ; i<word.length(); i++){
            char ch = word.charAt(i);
            if(current.links[ch-'a'] == null){
                return false;
                
            }
            current = current.links[ch-'a'];
        }
        return current!=null && current.flag;
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i=0 ; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(current.links[ch-'a'] == null){
                return false;
                
            }
            current = current.links[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */