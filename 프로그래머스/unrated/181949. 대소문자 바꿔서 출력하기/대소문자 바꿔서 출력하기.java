import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        String result = "";
        
        for (int i = 0; i < a.length(); i++) {
            char temp = a.charAt(i);
            
            if ((temp >= 65) && (temp <= 90)) {
                result += String.valueOf(temp).toLowerCase();
            } else {
                result += String.valueOf(temp).toUpperCase();
            }
        }
        
        System.out.println(result);
    }
}