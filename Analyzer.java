import java.io.*;
import java.util.*;
import java.util.stream.*;

class Analyzer {

  public static int min(int x, int y) {
    if (x < y) {
      return x;
    }
    return y;
  }

  public static int change(int denominations[], int n) {
    int[] temp = new int[n + 1];
    temp[0] = 1;

    for (int i = 0; i < denominations.length; i++) {

      for (int j = 0; j < temp.length; j++) {
        if (j >= denominations[i]) {
          temp[j] += temp[j - denominations[i]];
        }
      }

    }
    return temp[n];
  }

  static void printArray(int denominations[]) {
    System.out.print("[ " + denominations[0]);
    for (int i = 1; i < denominations.length; i++) {
      System.out.print(", ");
      System.out.print(denominations[i]);
    }
    System.out.println(" ]");
  }

  public static ArrayList<List<String>> read(String csv) {
    String delimiter = ",";
    ArrayList<List<String>> masterList = new ArrayList<List<String>>();
    try {
      File file = new File(csv);
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line = "";
      String[] array;

      while ((line = br.readLine()) != null) {
        ArrayList<String> list = new ArrayList<String>();
        array = line.split(delimiter);
        for (String str : array) {
          list.add(str.trim());
        }

        masterList.add(list);

      }
      br.close();
    } catch(IOException e) {
      e.printStackTrace();
    }
    return masterList;
  }



  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Please include a file to read.");
    } else {
      ArrayList<List<String>> csv = read(args[0]);
      for(List<String> list : csv) {
        int n = Integer.parseInt(list.get(0));
        int[] denominations = new int[list.size() - 1];
        for(int i = 0; i < denominations.length; i++) {
          denominations[i] = Integer.parseInt(list.get(i + 1));
        }
        //Combinations.printCombinations(denominations, n);
        System.out.print("\nDenominations: ");
        printArray(denominations);
        System.out.println("Solution: " + change(denominations, n) + " ways to make " + n);
      }
    }
  }
}
