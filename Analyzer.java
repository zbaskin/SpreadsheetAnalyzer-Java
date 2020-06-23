class Analyzer {

  static final int INFINITY = 1000000;

  public static int min(int x, int y) {
    if (x < y) {
      return x;
    }
    return y;
  }

  public static int change(int denominations[], int make, int numberOf) {
    int[] temp = new int[make + 1];
    temp[0] = 0;

    for (int i = 1; i <= make; i++) {
      int minimum = INFINITY;

      for (int j = 0; j <= numberOf; j++) {
        if (i >= denominations[j]) {
          minimum = min(minimum, 1 + temp[i - denominations[j]]);
        }
      }

      temp[i] = minimum;
    }
    return temp[make];
  }

  public static void main(String[] args) {
    int denoms[] = {0, 1, 2, 3};
    int n = Integer.parseInt(args[0]);
    int k = Integer.parseInt(args[1]);
    System.out.println(change( denoms, n, k ));
  }
}
