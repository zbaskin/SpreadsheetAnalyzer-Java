class Analyzer {

  //static final int INFINITY = 1000000;

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
      //int minimum = INFINITY;

      for (int j = 0; j < temp.length; j++) {
        if ( /*(j < denominations.length) &&*/ (j >= denominations[i]) ) {
          temp[j] += temp[j - denominations[i]];
        }
      }

      //temp[i] = minimum;
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

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Please include one number.");
    } else {
      int denoms[] = {1, 5, 10};
      int n = Integer.parseInt(args[0]);
      //int k = Integer.parseInt(args[1]);
      System.out.print("The Coins Array: ");
      printArray(denoms);

      System.out.print("Solution: ");
      System.out.println(change( denoms, n ));
    }
  }
}
