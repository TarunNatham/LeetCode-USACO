import java.util.*;
import java.io.*;
class TransitiveDice {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[4];
    int[] B = new int[4];
    int[] C = new int[4];

    outer:
    for(int c = 0; c < N; c++) {
      for(int i = 0; i < 4; i++) {
        A[i] = sc.nextInt();
      }
      for(int i = 0; i < 4; i++) {
        B[i] = sc.nextInt();
      }

      for(int i = 1; i <= 10; i++) {
        C[0] = i;
        for(int j = 1; j <= 10; j++) {
          C[1] = j;
          for(int k = 1; k <= 10; k++) {
            C[2] = k;
            for(int l = 1; l <= 10; l++) {
              C[3] = l;
              if(doesWork(A, B, C)) {
                System.out.println("yes");
                ;
                continue outer;
              }
            }
          }
        }
      }
      System.out.println("no");
    }
  }

  static boolean doesWork(int[] A, int[] B, int[] C) {
    double CvsA = 0;
    double AvsC = 0;
    double CvsB = 0;
    double BvsC = 0;
    double AvsB = 0;
    double BvsA = 0;
    for(int i : C) {
      for(int j : A) {
        if(i > j) {
          CvsA += 0.0625;
        }
      }
    }
    for(int i : A) {
      for(int j : C) {
        if(i > j) {
          AvsC += 0.0625;
        }
      }
    }
    for(int i : C) {
      for(int j : B) {
        if(i > j) {
          CvsB += 0.0625;
        }
      }
    }
    for(int i : B) {
      for(int j : C) {
        if(i > j) {
          BvsC += 0.0625;
        }
      }
    }
    for(int i : A) {
      for(int j : B) {
        if(i > j) {
          AvsB += 0.0625;
        }
      }
    }
    for(int i : B) {
      for(int j : A) {
        if(i > j) {
          BvsA += 0.0625;
        }
      }
    }
    if((CvsA > AvsC && CvsB < BvsC && AvsB > BvsA) || (CvsA < AvsC && CvsB > BvsC && AvsB < BvsA)) {
      return true;
    }
    return false;
  }
}