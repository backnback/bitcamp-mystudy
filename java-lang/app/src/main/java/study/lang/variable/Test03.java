package study.lang.variable;

public class Test03 {

  public static void main(String[] args) {

    int[][] arr = new int[3][];

    arr[0] = new int[] {11, 12};
    arr[1] = new int[] {21, 22, 23};
    arr[2] = new int[] {31, 32, 33, 34};

    System.out.println(arr.length); // 3

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + ", ");
      }
      System.out.println();
    }

    int[][] arr2 = new int[3][4];

    arr2[0] = new int[] {11, 12};
    arr2[1] = new int[] {21, 22, 23};
    arr2[2] = new int[] {31, 32, 33, 34};

    System.out.println(arr2.length); // 3

    for (int i = 0; i < arr2.length; i++) {
      for (int j = 0; j < arr2[i].length; j++) {
        System.out.print(arr2[i][j] + ", ");
      }
      System.out.println();
    }



  }

}
