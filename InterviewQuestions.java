import java.util.HashSet;
import java.util.Set;

class InterviewQuestions{

    //Strings------------------------------------------------------------------
    
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
    
    
    
   //Arrays--------------------------------------------------------------------
   
   //5
   /* @param nums -- array of size 99, contains integers 1-100 with one value
    *                missing. 
   */
    public static int findMissingNumber(int[] nums){
        int sum = (100 * (100 + 1)) / 2; //sum of a sequence
        int actualSum = 0;
        
        for(int num : nums){
            actualSum += num; 
        }
        
        return sum - actualSum;  
    }
    
    //6
    /* Could have also done with a hashset
     * @param nums -- array of size 101, contains integers 1-100 with one value
     *                repeated once. 
    */
    public static int findDuplicateNumber(int[] nums){
        int[] duplicateCheck = new int[101];
        
        for(int num : nums){
            if(duplicateCheck[num] != 0){
                return num; //return the duplicate
            }
            duplicateCheck[num] = num;
        }
        
        return -1; //no doubles
    }
    
    //7
    /* Could have also used treeset with values as number counts.
     * @param nums -- array containing integers with values 1-100. Size is irrelevant. 
    */
    public static int[] findDuplicateNumbers(int[] nums){
        int[] numberCounts = new int[101];
        
        for(int num : nums){
            numberCounts[num] += 1;
        }
        
        //Each index of array contains the count for that indices' value. 
        return numberCounts;
    }
    
    //8
    /* @param a -- array of integers 
     * @param b -- array of integers contained in 'a' but with one different value.
    */
    public static int findNumberNotInSecondArray(int[] a, int[] b){
        HashSet<Integer> nums = new HashSet<Integer>();
        int sumA = 0;
        int sumB = 0;
        boolean inA;
        
        for(int num : a){
            nums.add(num);
            sumA += num;
        }
        
        for(int num : b){
            inA = nums.add(num); //returns false if already there
            if(!inA){
                sumB += num;
            }
        }
        return sumA - sumB; //The difference will be the missing value since we
                           // didn't include the different value.
    }
    
    //9
    
    
    
    
    
    
    
    
    
    
    
}