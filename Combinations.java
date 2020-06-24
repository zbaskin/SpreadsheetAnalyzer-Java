import java.io.*;
import java.util.*;
import java.util.stream.*;

class Combinations {
  public static void recur(int[] denoms, int i, int n, int[] out, int index) {
    if (n == 0) {
      System.out.println(Arrays.stream(out).limit(index).boxed().collect(Collectors.toList()));
    }

    for (int j = i; j <= n; j++) {
      out[index] = denoms[j];
      recur(denoms, j, n - j, out, index + 1);
    }

  }
}
