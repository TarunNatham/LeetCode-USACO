import java.util.*;
import java.io.*;
class Main {
  static int combs = 0;
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(new File("stdin"));
    int N = sc.nextInt();
    ArrayList<Integer> cows = new ArrayList<Integer>();
    ArrayList<Integer> stalls = new ArrayList<Integer>();
    for(int i = 0; i < N; i++) {
      cows.add(sc.nextInt());
    }
    for(int i = 0; i < N; i++) {
      stalls.add(sc.nextInt());
    }
    Collections.sort(stalls);
    combCows(cows, stalls);
    System.out.println(combs);
  }

  static void combCows(ArrayList<Integer> cows, ArrayList<Integer> stalls) {
    if(cows.size() == 0) {
      combs++;
      return;
    }
    for(int i = cows.size() - 1; i >= 0; i--) {
      for(int j = stalls.size() - 1; j >= 0; j--) {
        ArrayList<Integer> copyCows = new ArrayList<Integer>(cows);
        ArrayList<Integer> copyStalls = new ArrayList<Integer>(stalls);
        if(cows.get(i) <= stalls.get(j)) {
          copyCows.remove(i);
          stalls.remove(j);
          combCows(copyCows, stalls);
        }
      }
    }
    return;
  }
}