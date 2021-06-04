import java.util.*;

class Main {
  public static void main(String[] args) {
    List<String> list1 = Arrays.asList("abc","def","xyz");
    List<String> list2 = Arrays.asList("abc","def");

    stringMinus(list1, list2);

  }

  public static void stringMinus(List<String> list1, List<String> list2) {
    List<String> differences = new ArrayList<>(list1);
    differences.removeAll(list2);
    
    System.out.println(differences);

  }
}