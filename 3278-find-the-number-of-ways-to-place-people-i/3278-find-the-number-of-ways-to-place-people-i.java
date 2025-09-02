class Solution {
    public int numberOfPairs(int[][] points) {
        int n=points.length;
        int cnt=0;


        // Sort points by x ascending, then y descending
        // This helps prioritize upper-left candidates
        Arrays.sort(points, (a,b)->{ if(a[0]!=b[0]){ return a[0]-b[0];} else{ return b[1]-b[0];}  } );
        
        // Iterate through all unique pairs of points
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                //Check UPPER left
                boolean check=false;

                int[] A=new int[2];
                int[] B=new int[2];

                // Check if either point is upper-left of the other
                if(checkUpperLeft(points[i], points[j])){
                    A=points[i];
                    B=points[j];
                    check=true;
                }
                
                if(checkUpperLeft(points[j], points[i])){
                    A=points[j];
                    B=points[i];
                    check=true;
                }

                // If a valid upper-left pair is found
                if( check ){
                    
                    int tmp=0;
                    // Check if any other point lies inside the rectangle formed by A and B
                    for(int k=0; k<n; k++){
                        if(k==i || k==j) continue;

                        // Point[k] lies inside or on the boundary of rectangle A-B
                        if( (A[0]<=points[k][0] && points[k][0]<=B[0]) && (A[1]>=points[k][1] && points[k][1]>=B[1]) ){
                            tmp++;
                            break;
                        }
                    }


                    // If rectangle is empty, count the pair
                    if(tmp==0) { 
                        cnt++;
                    }

                }
            }
        }


        return cnt;
    }



    // Helper method to check if point A is upper-left of point B
    boolean checkUpperLeft(int[] A, int[] B){

        if(A[0]<=B[0] && A[1]>=B[1]){
            return true;
        }

        return false;
    }
}