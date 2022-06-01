package leetcode.editor.cn;


import java.nio.charset.Charset;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution468 {

    public static void main(String[] args) {
        Solution468 solution468 = new Solution468();
        solution468.isIPv4("1.0.1.");
    }

    public String validIPAddress(String queryIP) {
        if (isIPv4(queryIP)) {
            return "IPv4";
        }
        if (isIPv6(queryIP)) {
            return "IPv6";
        }
        return "Neither";
    }

    public boolean isIPv4(String s) {
        String[] ipArr = s.split("\\.",-1);
        if (ipArr.length != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (ipArr[i].length() > 3 || ipArr[i].length() < 1) {
                return false;
            }
            if (ipArr[i].length() > 1 && ipArr[i].charAt(0) == '0') {
                return false;
            }
            int sum = 0;
            for (char c : ipArr[i].toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
                sum =  (sum * 10) + c - '0';
            }
            if (sum > 255) {
                return false;
            }
        }
        return true;
    }

    public boolean isIPv6(String s){
        s=s.toLowerCase();
        String t[]=s.split(":",-1);
        if(t.length!=8){return false;}
        for(int i=0;i<8;i++){
            if(t[i].length()==0||t[i].length()>4){return false;}
            for(char c:t[i].toCharArray()){if(!(c>='0'&&c<='9')&&!(c>='a'&&c<='f')){return false;}}
        }
        return true;
    }
}