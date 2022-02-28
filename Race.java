import java.util.*;
import java.io.*;
class Race {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(new File("race.in"));
    PrintWriter out = new PrintWriter(new File("race.out"));
    int dist = sc.nextInt();
    int N = sc.nextInt();
    for(int i = 0; i < N; i++) {
      int minSpeed = sc.nextInt();
      out.println(calcTime(minSpeed, dist));
    }
    out.close();
  }

  static int calcTime(int minSpeed, int dist) {
    int speed = 1;
    int travel = 1;
    int time = 1;
    while(travel < dist) {
      if(speedWorks(speed + 1, travel, dist, minSpeed)) {
        speed++;
        travel += speed;
      } else if (speedWorks(speed, travel, dist, minSpeed)) {
        travel += speed;
      } else {
        speed--;
        travel += speed;
      }
      time++;
    }
    return time;
  }

  static boolean speedWorks(int speed, int travel, int dist, int minSpeed) {
    //2, 6, 10, 1
    if(speed < minSpeed) {
      return true;
    }
    double calc = ((double) speed)/2 * (double) (speed + 1);
    double minCalc = ((double) minSpeed)/2 * (double) (minSpeed + 1);
    calc -= minCalc;
    travel += (int) calc;
    return travel < dist;
  }
}


/*while(speed > minSpeed) {
      travel += speed;
      if(travel >= dist) {
        break;
      }
      speed--;
    }
    return speed == minSpeed;*/