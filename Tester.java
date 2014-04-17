import java.util.Set;
import java.util.Random;
class Tester{
     public static void main(String args[]){
        
         //STRINGS 
         System.out.println("***********String Questions***********");
         
         //1
         System.out.println("1:");
         System.out.println(InterviewQuestions.isPalindrome("racecar"));
         System.out.println(InterviewQuestions.isPalindrome("people"));
         System.out.println();
         
         //2
         System.out.println("2:");
         System.out.println(InterviewQuestions.removeAll("people", 'p'));
         System.out.println();
         
         //3
         System.out.println("3:");
         Set<String> perms = InterviewQuestions.printPermutations("Dog");
         for(String str : perms){
             System.out.print(str);
             System.out.print(" ");
         }
         System.out.println();
         System.out.println();
        
         //4
         System.out.println("4:");
         System.out.println(InterviewQuestions.longestPalindrome("wwwellracecarpougy"));
         
         System.out.println();
         System.out.println();
         
         
         //Arrays
         System.out.println("***********Array Questions***********");
         
         System.out.println("5:");
         test5(); 
         System.out.println();
         
         System.out.println("6:");
         test6();
         System.out.println();
         
         System.out.println("7:");
         test7();
         System.out.println();
         
         System.out.println("7:");
         test8();
         System.out.println();
         
    }
     
    public static void test5(){
        Random gen = new Random();
        int excludedNum = gen.nextInt(100) + 1; //from 1-100
        System.out.println("Number to be excluded is: " + excludedNum);
        int[] arr = new int[99]; //will be missing 1 num
        int index = 0;

        for(int number = 1; number <= 100; number++){
            if(number != excludedNum){
              arr[index] = number;  
              index++;
            }
        }
        
        System.out.println("The excluded number is: " + 
                InterviewQuestions.findMissingNumber(arr));
    }
    
    public static void test6(){
        Random gen = new Random();
        int duplicateNum = gen.nextInt(100) + 1; //from 1-100
        System.out.println("Number to be duplicated is: " + duplicateNum);
        
        int[] arr = new int[101]; //has an additional number
        int index = 0;

        for(int number = 1; number <= 100; number++){
            if(number != duplicateNum){
              arr[index] = number;  
              index++;
            }
            else{
                arr[index] = number;
                arr[index + 1] = number;
                index += 2;
            }
        }

        System.out.println("Duplicate number was found to be: " +
                InterviewQuestions.findDuplicateNumber(arr));
    }
    
    public static void test7(){
        Random gen = new Random();
        int[] arr = new int[100];
        
        for(int counter = 0; counter < arr.length; counter++){
            arr[counter] = gen.nextInt(100) + 1; //add rand num between 1-100
        }
        
        int[] occuranceCounts = InterviewQuestions.findDuplicateNumbers(arr);
        
        int number = 0;
        for(int numCount : occuranceCounts){
            System.out.println("Number: " + number + "  Count: "+ numCount);
            number++;
        }

        System.out.println();
    }
    
    public static void test8(){
        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
        int[] arr2 = {1,2,3,4,5,22,7,8,9,10};
        
        System.out.println("Number in first array that isn't in second is: " + 
                InterviewQuestions.findNumberNotInSecondArray(arr1, arr2));
    }
}