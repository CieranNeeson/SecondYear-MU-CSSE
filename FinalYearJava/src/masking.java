/**
 * Created by cieranneeson on 25/10/2016.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class masking {

    public static char a_sign= '@'; public static int a_sym_ascii = (int)a_sign;
    public static char underscore = '_'; public static int underscore_ascii = (int)underscore;
    public static char plus = '+'; public static int plus_ascii = (int)plus;
    public static char leftbracket = '('; public static int lb_ascii = (int)leftbracket;
    public static char rightbracket = ')'; public static int rb_ascii = (int)rightbracket;

    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        Pattern delimiters = Pattern.compile(System.getProperty("line.separator")+"|\\s");
        scan.useDelimiter(delimiters);
        while(scan.hasNext()){
            String string = scan.nextLine();
            if(string.contains("E:")){
                string = string.replaceAll("\\s+","");
                System.out.println(emailMask(string));
            }
            else{
                System.out.println(phoneMask(string));
            }
        }

    }

    public static String emailMask(String email){
        String email_mask = "E:";
        int a_count = 0;
        if(email.contains("..") || email.charAt(2) == '.' || email.charAt(email.length()-1)=='.'){
            return null;
        }

        for(int i = 0; i<email.length(); i++){
            if((int)email.charAt(i) == a_sym_ascii && a_count<1){
                email_mask += email.charAt(2) + "*****" + email.charAt(i-1);
                a_count++;
                for(int j = i; j<email.length(); j++){
                    email_mask += email.charAt(j);
                }
            }
            else{
                return null;
            }

        }

        return email_mask;
    }

    public static String phoneMask(String phone){
        String phone_mask = "P:";
        int num_count = 0;
        phone = phone.replaceAll("\\s+","-");

        for(int r = 1; r<phone.length(); r++){
            if(phone.charAt(r-1) == ':') {
                if (phone.charAt(r) == ' ') {
                    removeCharAt(phone, r);
                }
            }
        }


        for(int i = 0; i<phone.length(); i++){

            if(phone.charAt(i) == '(' && Character.isDigit(phone.charAt(i-1))){
                phone = phone.replace('(', '-');
            }
            if(phone.charAt(i) == '(' && !Character.isDigit(phone.charAt(i-1))){
                phone = phone.replaceAll("\\(", "");
            }
            if(phone.charAt(i) == ')' && Character.isDigit(phone.charAt(i+1))){
                phone.replace(')', '-');
            }else{
                phone = phone.replaceAll("\\)", "-");
            }
            if(i < phone.length()-4) {
                if ((int) phone.charAt(i) == plus_ascii) {
                    phone_mask += phone.charAt(i);
                } else if (phone.charAt(i) == '-') {
                    phone_mask += phone.charAt(i);
                } else if (Character.isDigit(phone.charAt(i))) {
                    phone_mask += '*';
                    num_count++;
                }
            }
            else{
                if(Character.isDigit(phone.charAt(i))) {
                    phone_mask += phone.charAt(i);
                    num_count++;
                }
            }
        }
        phone_mask = phone_mask.replaceAll("--", "-");
        // Check count of numbers, if there's a plus there can be <=13 numbers, else 10
        // Only checking string length for now
        if(num_count <= 13 && phone_mask.contains("+")) {
            return phone_mask;
        }else if(num_count == 10 && !phone_mask.contains("+")) {
            return phone_mask;
        }else{
            return null;
        }


    }

    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
}


