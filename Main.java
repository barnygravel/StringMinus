import java.util.*;

class Main {
  public static void main(String[] args) {
    List<String> list1 = Arrays.asList("abc","def","xyz");
    List<String> list2 = Arrays.asList("abc","def");

    List<String> differences = new ArrayList<>(list1);
    differences.removeAll(list2);
    
    System.out.println(differences);

  }
}