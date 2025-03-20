class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        List<List<node>> li = new ArrayList<>();
        for(int i = 0;i<n;i++){
            li.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            li.get(edges[i][0]).add(new node(edges[i][1],edges[i][2],i));
            li.get(edges[i][1]).add(new node(edges[i][0],edges[i][2],i));
        }
        Map<Integer,Integer> cc = new HashMap<>();
        List<Integer> v = new ArrayList<>();
        boolean[] vis = new boolean[n];
        int ccn = 0;
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                vis[i] = true;
                boolean[] vise = new boolean[edges.length];
                int k = dfs(li,cc,vis,vise,ccn,i);
                v.add(k);
                ccn++;
            }
        }
        
        int[] ret = new int[query.length];
        for(int i = 0;i<query.length;i++){
            int a = cc.get(query[i][0]);
            int b = cc.get(query[i][1]);
            if(a==b){
                ret[i] = v.get(a);
            }else{
                ret[i] = -1;
            }
        }
        return ret;
    }
    private static int dfs(List<List<node>> li, Map<Integer,Integer> hm, boolean[] visv, boolean[] vise, int ccn, int cn){
        hm.put(cn,ccn);
        visv[cn] = true;
        if(li.get(cn).size()==0) return 0;
        int k = li.get(cn).get(0).w;
        for(int i = 0;i<li.get(cn).size();i++){
            if(visv[li.get(cn).get(i).v]&&vise[li.get(cn).get(i).e]) continue;
            else{
                if(!visv[li.get(cn).get(i).v]){
                    visv[li.get(cn).get(i).v] = true;
                    vise[li.get(cn).get(i).e] = true;
                    k = k & li.get(cn).get(i).w;
                    int l = dfs(li,hm,visv,vise,ccn,li.get(cn).get(i).v);
                    k = k&l;
                }else{
                    vise[li.get(cn).get(i).e] = true;
                    k = k&li.get(cn).get(i).w;
                }
            }
        }
        return k;
    }
}
class node{
    int v,w,e;
    node(int v, int w, int e){
        this.v = v;
        this.w = w;
        this.e = e;
    }
}