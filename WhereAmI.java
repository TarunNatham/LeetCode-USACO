import java.util.*;
import java.io.*;
class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(new File("whereami.in"));
    PrintWriter out = new PrintWriter(new File("whereami.out"));
    sc.nextLine();
    String mailboxes = sc.nextLine();
    int seq = 1;
    boolean badSeq = false;
    while(!badSeq) {
      badSeq = true;
      for(int i = 0; i <= mailboxes.length() - seq; i++) {
        String sub = mailboxes.substring(i, i + seq);
        int count = 0;
        while(count <= mailboxes.length() - seq) {
          if(count == i) {
            count++;
            continue;
          }
          if(mailboxes.substring(count, count + seq).equals(sub)) {
            badSeq = false;
            break;
          }
          count++;
        }
        if(!badSeq) {
          break;
        }
      }
      seq++;
    }
    out.print(seq - 1);
    out.close();
  }
}