import java.util.ArrayList;
import java.util.Collections;

class SmallestInfiniteSet {

    ArrayList<Integer> inf_set = new ArrayList<>();

    public SmallestInfiniteSet() {
        this.inf_set.add(1);
    }
    
    public int popSmallest() {

        // If inf list is of length  1 we simply add next num to end & pop
        if (this.inf_set.size()==1){
            int elem = this.inf_set.get(0);
            this.inf_set.add(elem+1);
            this.inf_set.remove(0);

            return elem;
        }
        // pop smallest, clean up any -1 flags that may exist, then return smallest
        else {
            int smallest = this.inf_set.get(0);
            this.inf_set.remove(0);

            // Now we must remove any -1 flags
            Integer[] clone = this.inf_set.toArray(new Integer[0]);
            for (int x = 0; x < clone.length; x++){
                int i = clone[x];
                if (i > 0){break;}
                if (i == -1){this.inf_set.remove(0);}
            }

            return smallest;
        }
    }
    
    public void addBack(int num) {
        
        // case 1: num is greater than current largest in our list (do nothing)
        if (num > this.inf_set.get(this.inf_set.size()-1)){
            String h = "h";
        }
        // case 2: num needs binded to front inf set, adding -1 flags where required
        else if(num < this.inf_set.get(0)) {
            int spaces = this.inf_set.get(0) - num;
            
            ArrayList<Integer> newblock = new ArrayList<>();

            for (int i = 1; i<=spaces; i++){
                if (i != 1) {newblock.add(-1);}
                else {newblock.add(num);}
            }

            newblock.addAll(this.inf_set);
            this.inf_set = newblock;
            
        }
        // case 3: num needs added within inf_set, may already exist, replace regardles
        else {
            int smallest = this.inf_set.get(0);
            int index = num - smallest;
            this.inf_set.set(index,num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */

 // This can be done by 

// Ensuring smallest is always at index 0 also when we pop we must add to the end 
// So that we never get an empty list

// add back does linear search to find where the number should be added in the list

// number inserted into sorted place in arrayList OR number in ArrayList (do nothing)