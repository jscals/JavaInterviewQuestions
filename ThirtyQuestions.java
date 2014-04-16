import java.util.HashSet;
import java.util.Set;

class ThirtyQuestions{

    //Strings
    
    //1
    public static boolean isPalindrome(String str){
        for(int i = 0, j = str.length() - 1; i <= str.length()/2; i++, j--){
            if(str.charAt(i) != str.charAt(j)){
                return false;        
            }
        }
        return true;
    }    
    
    
    //2
    public static String removeAll(String str, char chr){
        String replaced = str. replaceAll(chr + "", "");
        return replaced;
    }
    
    
    //3
    public static Set<String> printPermutations(String str){
        Set<String> perms = new HashSet<String>();
        
        if(str.length() == 1){
            perms.add(str);
            return perms;
        }
        
        String firstLetter = str.charAt(0) + ""; 
        String lastPart = str.substring(1);
        Set<String> lowerOrderPerms = printPermutations(lastPart);
        
        for(String perm : lowerOrderPerms){
            //insert first letter in each spot of lower order perm.
            for(int i = 0; i <= perm.length(); i++){
                perms.add(insert(firstLetter, perm, i));
            }
        }  
        return perms;
    }
    
    private static String insert(String letter, String word, int index){
        StringBuilder newString = new StringBuilder(); 
        //put at end
        if(index == word.length()){
            newString.append(word);
            newString.append(letter);
            return newString.toString(); 
        }
        //put at beginning/middle
        newString.append(word.substring(0, index));
        newString.append(letter);
        newString.append(word.substring(index));
        return newString.toString();
    }
    
    
    //4
    public static String longestPalindrome(String str){
        
        int longestStart = 0;
        int longestEnd = 0;
        char[] letters = str.toCharArray();
        
        for(int midPoint = 0; midPoint < letters.length; midPoint++){
            
            //Odd length words
            int left = midPoint - 1;
            int right = midPoint + 1;
            
            while(left >= 0 && right < letters.length && letters[left] == letters[right]){
                
                if((right - left) > (longestEnd - longestStart) ){
                    longestStart = left;
                    longestEnd = right;
                }
                
                left--;
                right++;
            }
            
   
            //Even length words
            left = midPoint;
            right = midPoint + 1;
            
            while(left >= 0 && right < letters.length && letters[left] == letters[right]){
                if((right - left) > (longestEnd - longestStart) ){
                    longestStart = left;
                    longestEnd = right;
                }
                left--;
                right++;
            }
        }
        
        return str.substring(longestStart, longestEnd + 1);
    }
    
    
    
   //Arrays
   
   //5
    public static int findMissingNumber(int[] nums){
        int sum = (100 * (100+1)) / 2;
        int actualSum = 0;
        for(int num : nums){
            actualSum += num; 
        }
        return sum - actualSum;   
    }
    
    //6
    public static int findDuplicateNumber(int[] nums){
        int[] duplicateCheck = new int[100];
        
        for(int num : nums){
            if(duplicateCheck[num] != 0){
                return num; //return the double
            }
            duplicateCheck[num] = num;
        }
        
        return -1; //no doubles
    }
    
    //7
    
    
    
    
    
}