import java.util.Arrays;
import IsItTheFlag;

public class BruteForce {

  final int min; // 48 for min numbers
  final int mid_max1 = 57; // 57 for max numbers (for skip)
  final int mid_min1 = 65; // 65 for min upper case (first skip)
  final int mid_max2 = 90; // 90 for max upper-case
  final int mid_min2 = 97; // 97 for min lower-case letters
  final int max; // 122 for max lower-case letters
  final int stringLength;
  boolean found;

  /**
   * One more element than <i>stringLength</i>,
   * to efficiently check for overflow.
   */
  private final int[] chars;

  public BruteForce(char min, char max, int len) {
    this.min = min;
    this.max = max;
    this.stringLength = len;
    this.found = false;

    chars = new int[stringLength + 1];
    Arrays.fill(chars, 1, chars.length, min);
  }

  public void run() {
    while (chars[0] == 0) {
      check();
      increment();
    }
  }

  private void increment() {
    for (int i = chars.length - 1; i >= 0; i--) {
      if (chars[i] < max) {
        if(chars[i]==mid_max1) // skip #1
          chars[i]=mid_min1;
        else if(chars[i]==mid_max2) // skip #2
          chars[i]=mid_min2;
        else
          chars[i]++; // normal increment
        return;
      }
      chars[i] = min;
    }
  }

  String str;
  private void check() {
    str = "";
    for (int i = 1; i < chars.length; i++) {
      str += (char) chars[i];
    }
    if(IsItTheFlag.isFlag(str))
    {
        System.out.println("Flag: " + str);
        this.found = true;
    }
  }

  public static void main(String[] args) {
    BruteForce bf =new BruteForce('0', 'z', 6);
    bf.run();
    if(bf.found==false)
        System.out.println("Not found flag");
  }
}