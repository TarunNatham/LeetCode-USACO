import java.util.*;
import java.io.*;
public class Main {
  static int min = 0;
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int i = 0; i < t; i++) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      ArrayList<Integer> arr = new ArrayList<Integer>();
      for(int j = 0; j < n; j++) {
        arr.add(sc.nextInt());
      }
      Collections.sort(arr);
      findMin(arr, x);
      System.out.println(min);
      min = 0;
    }
  }

  static void findMin(ArrayList<Integer> arr, int x) {
    if(arr.size() == 0) {
      return;
    }
    int multi = arr.get(0) * x;
    if(arr.contains(multi)) {
      arr.remove(0);
      arr.remove(arr.indexOf(multi));
    } else {
      arr.remove(0);
      min++;
    }
    findMin(arr, x);
  }
}