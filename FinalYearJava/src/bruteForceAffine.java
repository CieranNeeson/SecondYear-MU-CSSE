/**
 * Created by cieranneeson on 01/10/2016.
 */
import java.*;


public class bruteForceAffine {

    public static void main(String[] args){
        FileIO reader = new FileIO();
        String[] cipher = reader.load("../../16cipherText_1_2.txt");

        /**
         *
         *         System.out.println("Original CipherText: ");
                     for(int i=0; i<cipher.length;i++){
                     System.out.println(cipher[i]);
                     }
         */

        int odd = 0, even = 0;

        for(int i=0; i<cipher.length; i++){
            if(cipher[i].charAt(cipher[i].length()-1) == '2'
               || cipher[i].charAt(cipher[i].length()-1) == '4'
                    || cipher[i].charAt(cipher[i].length()-1) == '6'
                        || cipher[i].charAt(cipher[i].length()-1) == '8'
                            || cipher[i].charAt(cipher[i].length()-1) == '0'){
                even++;
            }
            else{
                odd++;
            }
        }
        System.out.println("Evens: " + even);
        System.out.println("Odds: " + odd);

        long a;
        long b;
        //long n = 998001L;
        long n = 1000000L;
        int count = 0;
        for(int i=1; i<=65535; i++){
            for(int j=1; j<=65535; j++) {
                a = i;
                b = j;
            if (((26990 * a + b) % n == 39518) && (gcd(a, n)==1) && ((a%2==0 && b%2==0) ||(a%2!=0 && b%2!=0))) {
            if (((29285 * a + b) % n ==706280 ) && (gcd(a, n) == 1) && ((a % 2 == 0 && b % 2 != 0) || (a % 2 != 0 && b % 2 == 0))) {

                count++;
                System.out.println(a + ", " + b);

        }
        }


            }
        }
        System.out.println("Possibilities: " + count);

    }

    public static long gcd(long x, long y){
        return (y == 0) ? x : gcd(y, x % y);
    }


}
