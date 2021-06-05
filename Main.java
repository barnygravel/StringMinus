import java.util.*;

class Main {
  public static void main(String[] args) {
    List<String> trainA = Arrays.asList("CHN", "SLM", "BLR", "KRN", "HYB", "NGP", "ITJ", "BPL", "AGA", "NDL");
    List<String> trainB = Arrays.asList("TVC", "SRR", "MAQ", "PNE", "HYB", "NGP", "ITJ", "BPL", "PTA", "NJP", "GHY");
    List<String> trainAStationsTillTrainABStartStation;
    List<String> trainBStationsTillTrainABStartStation;

    String TRAIN_A_START_STATION = "CHN";
    String TRAIN_B_START_STATION = "TVC";
    String TRAIN_AB_START_STATION = "HYB";

    trainAStationsTillTrainABStartStation = getStationsBetween(TRAIN_A_START_STATION, TRAIN_AB_START_STATION,trainA);
    trainBStationsTillTrainABStartStation = getStationsBetween(TRAIN_B_START_STATION, TRAIN_AB_START_STATION,trainB);

    String inputTrainA = "TRAIN_A ENGINE NDL NDL KRN GHY SLM NJP NGP BLR";
    String inputTrainB = "TRAIN_B ENGINE NJP GHY AGA PNE MAO BPL PTA";

    List<String>  inputTrainA1 = cleanInput(inputTrainA);
    List<String>  inputTrainB1 = cleanInput(inputTrainB);

    List<String> outputTrainA = stringMinus(inputTrainA1, trainAStationsTillTrainABStartStation);
    List<String> outputTrainB = stringMinus(inputTrainB1, trainBStationsTillTrainABStartStation);

    System.out.println(outputTrainA);
    System.out.println(outputTrainB);

    List<String>  bogiesFromTrainABStartStation = bogiesFromTrainABStartStation(outputTrainA, outputTrainB);
    System.out.println(bogiesFromTrainABStartStation);

    Set<String> stationsFromTrainABStartStation = new HashSet<String>(bogiesFromTrainABStartStation);
    System.out.println(stationsFromTrainABStartStation);

  }

  // TODO rename
  static List<String> stringMinus(List<String> list1, List<String> list2) {
    List<String> differences = new ArrayList<>(list1);
    differences.removeAll(list2);
    return differences;
  }

  static List<String> getStationsBetween(String s1, String s2, List<String> train) {
    return train.subList(train.indexOf(s1), train.indexOf(s2)+ 1);
  }

  static List<String> cleanInput(String input) {
    String[] input1 = input.split(" ");
    List<String> output = Arrays.asList(input1);
    //List<String> output = Arrays.asList(Arrays.copyOfRange(input1, 2, (input1.length -1)));
    return output;
  }

  static List<String> bogiesFromTrainABStartStation(List<String> outputTrainA, List<String> outputTrainB) {
    List<String> joined = new ArrayList<String>();
    joined.addAll(outputTrainA.subList(2, outputTrainA.size()));
    joined.addAll(outputTrainB.subList(2, outputTrainB.size()));
    return joined;
  }
}
