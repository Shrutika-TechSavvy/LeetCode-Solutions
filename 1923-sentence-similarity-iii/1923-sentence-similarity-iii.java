class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        int n1 = sentence1.length();
        int n2 = sentence2.length();
        if(n1>n2) return areSentencesSimilar(sentence2,sentence1);

        String s[] = sentence1.split(" ");
        String l[] = sentence2.split(" ");
        int st = 0;
        int end1 = s.length-1;
        int end2 = l.length-1;
        while(st<=end1 && s[st].equals(l[st])){
            st++;
        }
        while(st<=end1 && s[end1].equals(l[end2])){
            end1--;
            end2--;
        }
        return (st>end1);
    }
}