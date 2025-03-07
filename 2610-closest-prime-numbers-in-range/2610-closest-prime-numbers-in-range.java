class Solution {
    public int[] closestPrimes(int left, int right) {
        
        int[] res=new int[2];
        Arrays.fill(res, -1);


        //Approach 1.
        //1.Get the array of all the prime numbers
        //2. Then find the first pair whose difference is minimum

        List<Integer> primes = getPrimes(left, right); // Get all primes in range [left, right]
        int diff = Integer.MAX_VALUE;

        for(int i=1; i<primes.size(); i++){
            if(primes.get(i) - primes.get(i-1) < diff){
                diff=primes.get(i) - primes.get(i-1);
                res[0]=primes.get(i-1);
                res[1]=primes.get(i);
            }
        }
        return res;
    }

    private List<Integer> getPrimes(int left, int right) {

        List<Integer> primes=new ArrayList<>();
        boolean isPrime[]=new boolean[right+1];

        for(int i=2; i<=right; i++){
            isPrime[i]=true;

        }

        for(int i=2; i*i <=right; i++){
            if(isPrime[i]){
                for(int j=i*i ; j<=right ;j+=i){
                    isPrime[j]=false;
                }
            }
        }

            for (int i = Math.max(2, left); i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

}