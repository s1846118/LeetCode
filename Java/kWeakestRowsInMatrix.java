class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        int[] weakest = new int[k];

        return findWeakest(mat, k);
    }

    public int[] findWeakest(int[][] arr, int k){

        int counter = 0;
        int soldier_count = 0;
        int[] weakest = new int[k];

        // We will run until everything is full 
        while (counter < k){
            for (int wall = 0; wall < arr.length; wall++){

                // Set soldier counter
                int soldiers = 0;
                
                // Counts soldiers in a given wall
                for (int piece = 0; piece < arr[wall].length; piece++){
                    if (arr[wall][piece] == 1){soldiers +=1;}
                }

                //If soldiers are at current counter then add to array!
                if (soldier_count == soldiers){

                    //If we reach max before next counter break
                    if(counter == k) {break;}

                    weakest[counter] = wall;

                    counter +=1;
                    }
                // If we get to the end of the array and no wall has given number of pieces move
                if ((wall == arr.length - 1)){
                    soldier_count+=1;
                }
            }
        }

        return weakest;
    }
}