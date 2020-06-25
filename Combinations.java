import java.io.*;
import java.util.*;
import java.util.stream.*;

class Combinations {
  public static void recur(int[] denoms, int i, int n, int[] out, int index) {
    if (n == 0) {
      System.out.println(Arrays.stream(out).limit(index).boxed().collect(Collectors.toList()));
    }

    for (int j = denoms[i % denoms.length]; j <= n; j += 1) {// denoms[index % denoms.length]) {
      out[index] = j;
      recur(denoms, j, n - j, out, index + 1);
    }
  }
  
  //account for incorrect file in CLI

  public static void printCombinations(int[] denominations, int n) {
    int[] out = new int[n];
    recur(denominations, 1, n, out, 0);
  }
}
