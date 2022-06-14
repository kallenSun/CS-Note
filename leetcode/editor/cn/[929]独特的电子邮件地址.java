package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Scanner;

class Solution929 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toUpperCase();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);
        map.put('G', 16);
        int sum = 0;
        for (int i = str.length() - 1; i >= 2; i--) {
            sum = sum* 10 +  map.get(str.charAt(i));
        }
        System.out.println(sum);

    }


    public int numUniqueEmails(String[] emails) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String email : emails) {
            String[] addressArray = email.split("@");
            String localAddress = addressArray[0];
            String address = addressArray[1];
            localAddress = localAddress.replace(".", "");
            if (localAddress.contains("+")) {
                localAddress = localAddress.substring(0, localAddress.indexOf("+"));
            }

            String totalAddress = localAddress + address;
            map.putIfAbsent(totalAddress, 1);
        }
        return map.size();
    }
}
