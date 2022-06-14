package leetcode.editor.cn;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] numArr = str.split("\\.");
        int first = Integer.parseInt(numArr[0]);


        int y = Integer.parseInt(String.valueOf(numArr[1].charAt(0)));

        if (y >= 5) {
            System.out.println(first + 1);
        } else {
            System.out.println(first);
        }
    }
}
