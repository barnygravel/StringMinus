import java.util.*;

class Main {
  public static void main(String[] args) {
    List<String> trainA = Arrays.asList("CHN", "SLM", "BLR", "KRN", "HYB", "NGP", "ITJ", "BPL", "AGA", "NDL");
    List<String> trainB = Arrays.asList("TVC", "SRR", "MAQ", "PNE", "HYB", "NGP", "ITJ", "BPL", "PTA", "NJP", "GHY");
    List<String> trainAStationsTillTrainABStartStation;
    List<String> trainBStationsTillTrainABStartStation;
    List<String> trainABStations;
    List<String> trainAStationsFromTrainABEndStation;
    List<String> trainBStationsFromTrainABEndStation;

    String TRAIN_A_START_STATION = "CHN";
    String TRAIN_B_START_STATION = "TVC";
    String TRAIN_AB_START_STATION = "HYB";
    String TRAIN_AB_STOP_STATION = "BPL";
    String TRAIN_A_STOP_STATION = "NDL";
    String TRAIN_B_STOP_STATION = "GHY";

    Map<String, Integer> trainARouteDistance = new HashMap<String, Integer>();
    Map<String, Integer> trainBRouteDistance = new HashMap<String, Integer>(); 

    trainARouteDistance.put("CHN", 0);
    trainARouteDistance.put("SLM",350);
    trainARouteDistance.put("BLR",550);
    trainARouteDistance.put("KRN",900);
    trainARouteDistance.put("HYB",1200);
    trainARouteDistance.put("NGP",1600);
    trainARouteDistance.put("ITJ",1900);
    trainARouteDistance.put("BPL",2000);
    trainARouteDistance.put("AGA",2500);
    trainARouteDistance.put("NDL",2700);

    trainBRouteDistance.put("TVC",0);
	  trainBRouteDistance.put("SRR",300);
	  trainBRouteDistance.put("MAQ",600);
	  trainBRouteDistance.put("MAO",1000);
	  trainBRouteDistance.put("PNE",1400);
	  trainBRouteDistance.put("HYB",2000);
	  trainBRouteDistance.put("NGP",2400);
	  trainBRouteDistance.put("ITJ",2700);
	  trainBRouteDistance.put("BPL",2800);
	  trainBRouteDistance.put("PTA",3800);
	  trainBRouteDistance.put("NJP",4200);
	  trainBRouteDistance.put("GHY",4700);

    Map<String, Integer> distanceFromtrainABStartStation = new HashMap<String, Integer>();
    //distanceFromtrainABStartStation.put()


    trainAStationsTillTrainABStartStation = getStationsBetween(TRAIN_A_START_STATION, TRAIN_AB_START_STATION,trainA);
    trainBStationsTillTrainABStartStation = getStationsBetween(TRAIN_B_START_STATION, TRAIN_AB_START_STATION,trainB);
    trainAStationsFromTrainABEndStation = getStationsBetween(TRAIN_AB_STOP_STATION, TRAIN_A_STOP_STATION,trainA);
    trainBStationsFromTrainABEndStation = getStationsBetween(TRAIN_AB_STOP_STATION, TRAIN_B_STOP_STATION,trainB);

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
