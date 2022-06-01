import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.SimpleFormatter;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2022/3/1 <br>
 * @since V9.0 <br>
 */
public class Test {

    public static void main(String[] args) {
        int test = test(10, 20, 5, 4);
        System.out.println(test);
    }


    public static int test(int x, int y, int a, int b) {
        int count = 0;
        if (a < b) {
            return (int) Math.floor((double) Math.max(x, y) / b);
        } else if (a > (2 * b)) {
            return (int) Math.floor((double) Math.max(x, y) / a);
        } else {
            while (x > 0 && y > 0) {
                x -= b;
                y -= b;
                count++;
            }
            while (x > 0 || y > 0) {
                x -= a;
                y -= a;
                count++;
            }
        }
        return count;
    }
}
