import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;


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
        String replaced = str.replaceAll(chr + "", "");
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
    public static int findSecondHighestNumber(int[] nums){
        int currHighest = Integer.MIN_VALUE;
        int lastHighest = Integer.MIN_VALUE;
        
        for(int num : nums){
            if(num > currHighest){
                lastHighest = currHighest;
                currHighest = num;
            }
        }
        return lastHighest;
    }
    
    
    
    
    
    //Linked List--------------------------------------------------------------
    //10
    public static Integer findMiddleElement(LinkedList<Integer> nums){
        int endPointer = 0;
        int midPointer = 0;
        boolean foundEnd = false;
        
        while(!foundEnd){
            Integer node1 = null;
            Integer node2 = null;
            
            try{
                node2 = nums.get(midPointer);
                node1 = nums.get(endPointer);
                 
            }
            catch(IndexOutOfBoundsException e){
                node1 = null;
                
            }
            
            if(node1 != null){
                endPointer += 2;
                midPointer += 1; 
            }
            else{
                return node2;
            }
        }
        return null;
    }
    
    //11
    public static Integer findThirdLastElement(LinkedList<Integer> nums){
        int endPointer = 0;
        int thirdLastPointer = 0;
        boolean foundEnd = false;
        Integer lastElement = null;
        
        while(!foundEnd){
            if(endPointer < 2){
                endPointer++; //need to lag other pointer 3 spots behind.
            }
            else{
                endPointer++;
                try{
                    lastElement = nums.get(endPointer);
                }
                catch(IndexOutOfBoundsException e){
                    return nums.get(thirdLastPointer);
                }
                thirdLastPointer++;
            }
        }
        return null;
    }
    
    //12
    public static LinkedList<Integer> reverseList(LinkedList<Integer> nums){
        
        LinkedList<Integer> numsReversed = new LinkedList<Integer>();
        
        for(Integer num : nums){
            numsReversed.push(num);
        }
        
        return numsReversed;
    }
    
    
    
    //Searching and Sorting----------------------------------------------------
    //13
    public static void quickSort(int[] arr){
        swapByPivot(arr, 0, arr.length - 1);
    }
    
    private static void swapByPivot(int[] arr, int start, int end){
        int pivot = start + ((end - start) / 2);
        int i = start;
        int j = end;
        
        while(i <= j){
            //find elements to swap
            while(arr[i] < arr[pivot]){ i++; }
            while(arr[j] > arr[pivot]){ j--; }
            
            //swap
            if(i <= j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--; i++;
            }
        }
        
        //recursion with with both sides of pivot. 
        if(start < j) swapByPivot(arr, start, j);
        if(end > i) swapByPivot(arr, i, end);
    }
    
    
    //14
    public static int binarySearch(int[] arr, int target){
       int low = 0;
       int high = arr.length -1;
       
       while(low <= high){
           int mid = low + ((high - low) / 2);

           if(target > arr[mid]) low = mid + 1; 
           else if(target < arr[mid]) high = mid - 1;
           else return target; 
        }
       return -1; 
    }
    
    
    
    //Numbers------------------------------------------------------------------
    //15
    public static boolean isPowerOfTwo(int num){
 
        int currNum = num;
        while(currNum > 1){
            int ans = currNum / 2;
            int remainder = currNum % 2; 
            
            if(remainder != 0){
                return false;
            }
            else if(ans == 1){
                return true;
            }
            else{
                currNum = ans;
            }
        }
        return false; //Keep compiler happy. 
    }
    
    //16
    public static boolean isNumberPalindrome(int num){
        
        String numString = Integer.toString(num);
        int length = numString.length();
        
        for(int start = 0, end = length - 1; start <= (length - 1) / 2; start++, end--){
            if(numString.charAt(start) != numString.charAt(end)){
                return false;
            }
        }
        return true;
    }
    
    //17
    public static void printPrimeNumbers(int limit){
       
        for(int num = 1; num < limit; num++){
            boolean isPrime = true;
            
            //Check that current num isn't divisible by any number up to its square root.
            for(int divCheck = 2; divCheck <= Math.sqrt(num); divCheck++){
                if(num % divCheck == 0){
                    isPrime = false;
                }
            }
            
            if(isPrime){
                System.out.print(num);
                System.out.print(" ");
            }
        }
    }
    
    //18
    public static void printNthFibonaci(int n){
        if(n >= 1){ 
            int lastNum2 = 0;
            System.out.print(0 + " ");
            
            int lastNum1 = 1;
            System.out.print(1 + " ");
            
            while(lastNum1 + lastNum2 < n){
                int nextNum = lastNum1 + lastNum2;
                System.out.print(nextNum);
                System.out.print(" ");
                lastNum2 = lastNum1;
                lastNum1 = nextNum;   
            }
        }
    }
    
    
    //Binary Trees--------------------------------------------------------------
    //19
    public static int getTreeDepth(BinaryTree tree){
        return recursiveTreeDepth(tree.head);
    }
    
    private static int recursiveTreeDepth(Node currNode){
        if(currNode == null){
            return 0;
        }
        return 1 + Math.max(recursiveTreeDepth(currNode.getLeftChild), recursiveTreeDepth(currNode.getRightChild));
    }
    
    
    //20
    public static void printTreeTraversal(BinaryTree tree){
        //TODO
    }
    
    
    //21
    public static void printLeafNodes(BinaryTree tree){
        recursiveLeafPrint(tree.head);
    }
    
    private static void recursiveLeafPrint(Node currNode){
        
        if(currNode != null && currNode.getLeftChild == null && currNode.getRightChild == null){
            System.out.println(currNode.value);
        }
        else if(currNode != null){
            recursiveLeafPrint(currNode.getLeftChild);
            recursiveLeafPrint(currNode.getRightChild);
        }
    }
    
}