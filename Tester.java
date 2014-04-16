import java.util.Set;
class Tester{
     public static void main(String args[]){
        
         //STRINGS 
         System.out.println("***********String Questions***********");
         
         //1
         System.out.println("1:");
         System.out.println(ThirtyQuestions.isPalindrome("racecar"));
         System.out.println(ThirtyQuestions.isPalindrome("people"));
         System.out.println();
         
         //2
         System.out.println("2:");
         System.out.println(ThirtyQuestions.removeAll("people", 'p'));
         System.out.println();
         
         //3
         System.out.println("3:");
         Set<String> perms = ThirtyQuestions.printPermutations("Dog");
         for(String str : perms){
             System.out.print(str);
             System.out.print(" ");
         }
         System.out.println();
         System.out.println();
        
         //4
         System.out.println("4:");
         System.out.println(ThirtyQuestions.longestPalindrome("wwwellracecarpougy"));
         
         System.out.println();
         System.out.println();
         
         //Arrays
         System.out.println("***********Array Questions***********");
         
         System.out.println("1:");
         
    }
}