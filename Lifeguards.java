import java.util.*;
import java.io.*;
class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(new File("lifeguards.in"));
    PrintWriter out = new PrintWriter(new File("lifeguards.out"));
    int N = sc.nextInt();
    int[] shifts = new int[1000];
    int[] starts = new int[N];
    int[] ends = new int[N];
    for(int i = 0; i < N; i++) {
      int start = sc.nextInt();
      starts[i] = start;
      int end = sc.nextInt();
      ends[i] = end;
      for(int j = start; j < end; j++) {
        shifts[j]++;
      }
    }
    int maxTime = 0;
    for(int i = 0; i < N; i++) {
      int start = starts[i];
      int end = ends[i];
      int[] shiftsCopy = shifts.clone();
      for(int j = start; j < end; j++) {
        shiftsCopy[j]--;
      }
      maxTime = Math.max(maxTime, calculateTime(shiftsCopy));
    }
    out.print(maxTime);
    out.close();
  }
  static int calculateTime(int[] shifts) {
    int total = 0;
    for(int i : shifts) {
      if(i > 0) {
        total++;
      }
    }
    return total;
  }
}