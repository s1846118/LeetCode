import java.util.ArrayList;

class Solution {
    public boolean canTransform(String start, String end) {
        boolean moves = true;
        int counter = 0;
        boolean change_check = false;
        boolean matched = false;
        String temp = start;

        if (start.length() != end.length() || start.length() == 1 || end.length() == 1){
            return false;
        }

        char[] st = start.toCharArray();
        char[] ed = end.toCharArray();
        ArrayList<String> lettersSt = new ArrayList<String>();
        ArrayList<String> lettersEd = new ArrayList<String>();
        for (int i = 0; i < start.length(); i++){
            if (st[i] != 'X'){ lettersSt.add(String.valueOf(st[i]));}
            if (ed[i] != 'X'){ lettersEd.add(String.valueOf(ed[i]));}
        }

        if (lettersSt.size() != lettersEd.size()) {return false;}

        System.out.println(lettersSt);
        System.out.println(lettersEd);


        for (int i = 0; i < lettersSt.size(); i++){
            if (lettersEd.get(i) != lettersSt.get(i)) {return false;}
        }

        // Keep moving through string to check for changes until no changes can be made
        while(moves){

            String base = "" + temp.charAt(counter) + temp.charAt(counter+1);
            String endBase = "" + end.charAt(counter) + end.charAt(counter+1);

            if (does_match(base,"XL") && !(endBase.charAt(1) == 'L') || (does_match(base,"XL")) && (endBase.charAt(0) == 'L')){
                char[] tempArr = temp.toCharArray();
                tempArr[counter] = 'L';
                tempArr[counter+1] = 'X';

                temp = String.valueOf(tempArr);

                change_check = true;
            }
            if (does_match(base,"RX") && !(endBase.charAt(0) == 'R') || does_match(base,"RX") && (endBase.charAt(1) == 'R')){
                char[] tempArr = temp.toCharArray();
                tempArr[counter] = 'X';
                tempArr[counter+1] = 'R';

                temp = String.valueOf(tempArr);
                change_check = true;
            }

            if (does_match(temp, end)){return true;}

            counter+=1;

            // If we reach the end, go to start if we have managed to make a move 
            if (counter == start.length()-1){

                // No changes made on iteration, return false
                if (change_check == false) { moves = false; }

                counter = 0;
                change_check = false;
                
            }
        }

        return false;
    }

    public boolean does_match (String str1, String str2){

        if (str1.length() != str2.length()){ 
            return false;
        }
        else {
            boolean assump = true;
            for (int i = 0; i < str1.length(); i++){
                if (str1.charAt(i) != str2.charAt(i)) {assump = false;}
            }
            return assump;
        }

    }
}