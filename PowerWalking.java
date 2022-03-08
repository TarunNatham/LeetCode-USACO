import java.util.*;
import java.io.*;
public class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int i = 0; i < t; i++) {
      int n = sc.nextInt();
      ArrayList<Long> types = new ArrayList<Long>();
      HashMap<Long, Integer> freq = new HashMap<Long, Integer>();
      for(int j = 0; j < n; j++) {
        long s = sc.nextLong();
        types.add(s);
        if(freq.containsKey(s)) {
          freq.put(s, freq.get(s) + 1);
        } else {
          freq.put(s, 1);
        }
      }
      for(int c = 1; c <= n; c++) {
        if(c <= freq.size()) {
          System.out.print(freq.size() + " ");
        } else {
          System.out.print(c + " ");
        }
      }
      System.out.println();
    }
  }
}