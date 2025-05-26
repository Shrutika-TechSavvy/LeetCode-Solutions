class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] edge:edges) adj.get(edge[0]).add(edge[1]);
        int[] indegree=new int[n];
        int[][] dp=new int[n][26];
        for(int i=0;i<n;i++) for(Integer it:adj.get(i)) indegree[it]++;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            dp[i][colors.charAt(i)-'a']++;
            if(indegree[i]==0) q.offer(i);
        }
        int vis=0,ans=0;
        while(!q.isEmpty()){
            int u=q.poll();
            vis++;
            for(Integer v:adj.get(u)){
                for(int i=0;i<26;i++) dp[v][i]=Math.max(dp[v][i],dp[u][i]+(colors.charAt(v)-'a'==i?1:0));
                indegree[v]--;
                if(indegree[v]==0) q.offer(v);
            }
            for(int i=0;i<26;i++) ans=Math.max(ans,dp[u][i]);
        }
        return vis==n?ans:-1;
    }
}