import java.util.Set;
class Tester{
     public static void main(String args[]){
        
         Set<String> perms = ThirtyQuestions.printPermutations("Dog");
         for(String str : perms){
             System.out.println(str);
         }
        
    }
}