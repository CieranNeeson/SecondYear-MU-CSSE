import com.sun.xml.internal.fastinfoset.util.StringArray;

/**
 * Created by cieranneeson and dylandrein on 02/10/2016.
 */
public class newAffine {

    public static void main(String[] args) {
        FileIO reader = new FileIO();
        String[] cipher = reader.load("../../16cipherText_1_2.txt");
        int ac;
        int p;
        int n = 999*999;
        int[] a_array = new int[42509];
        int count=0;
        for(ac=1; ac<=65535; ac++){
            if(gcd(ac, n) == 1){
                a_array[count] = ac;
                count++;
            }
        }
        /*      P*A+B mod N = Ciphertext
         *      P = Plaintext from 24929 to 31354
         *      A = All values from 1 to 65535 where GCD(a, n) = 1
         *      B = 1 to 65535
         *      N = 999 squared
         *
         */
        int a = 0;
        int i = 0;
        int b = 1;
        for(p=24929;p<=31354;p++)
        {
            for(int cipher_index=0; cipher_index<cipher.length; cipher_index++){
                int cipher_as_int = Integer.parseInt(cipher[cipher_index]);
                if((cipher_as_int%2==0) && (p%2==0)){
                    if(b%2==0){
                        for(i=0;i!=a_array.length;i++){
                            a=a_array[i];
                            for(;b<=65535;b+=2){
                                long equation = p*a+b % (n);
                                //System.out.println("CHECKING c:"
                                //        + cipher[cipher_index] + ", p: "
                                //        + p + ", a: " + a + ", b: " + b);
                                if (Long.toString(equation).equals(cipher[cipher_index])) {
                                    System.out.println("FOUND c:"
                                            + cipher[cipher_index] + ", p: "
                                            + p + ", a: "
                                            + a + ", b: "
                                            + b);
                                }
                                break;
                            }
                        }
                    }

                }
                if((cipher_as_int%2!=0) && (p%2==0)){
                    if(b%2!=0){
                        for(i=0;i!=a_array.length;i++){
                            a=a_array[i];
                            for(;b<=65535 && b%2!=0;b++){
                                long equation = p*a+b % (n);
                                //System.out.println("CHECKING c:"
                                //        + cipher[cipher_index] + ", p: "
                                //        + p + ", a: " + a + ", b: " + b);
                                if (Long.toString(equation).equals(cipher[cipher_index])) {
                                    System.out.println("FOUND c:"
                                            + cipher[cipher_index] + ", p: "
                                            + p + ", a: "
                                            + a + ", b: "
                                            + b);
                                }
                                break;
                            }
                        }
                    }

                }
                if((cipher_as_int%2!=0) && (p%2!=0)){
                    if((b%2!=0 && a%2==0) || (b%2==0 && a%2!=0)){
                        for(i=0;i!=a_array.length;i++){
                            a=a_array[i];
                            for(;b<=65535;b+=2){
                                long equation = p*a+b % (n);
                                //System.out.println("CHECKING c:"
                                //        + cipher[cipher_index] + ", p: "
                                //        + p + ", a: " + a + ", b: " + b);
                                if (Long.toString(equation).equals(cipher[cipher_index])) {
                                    System.out.println("FOUND c:"
                                            + cipher[cipher_index] + ", p: "
                                            + p + ", a: "
                                            + a + ", b: "
                                            + b);
                                }
                                break;
                            }
                        }
                    }

                }
                if((cipher_as_int%2==0) && (p%2!=0)){
                    if((b%2!=0 && a%2!=0) || (b%2==0 && a%2==0)){
                        for(i=0;i!=a_array.length;i++){
                            a=a_array[i];
                            for(;b<=65535;b++){
                                long equation = p*a+b % (n);
                                //System.out.println("CHECKING c:"
                                //        + cipher[cipher_index] + ", p: "
                                //        + p + ", a: " + a + ", b: " + b);
                                if (Long.toString(equation).equals(cipher[cipher_index])) {
                                    System.out.println("FOUND c:"
                                            + cipher[cipher_index] + ", p: "
                                            + p + ", a: "
                                            + a + ", b: "
                                            + b);
                                }
                                break;
                            }
                        }
                    }

                }

            }
        }

    }

    private static long gcd(long x, long y){
        return (y == 0) ? x : gcd(y, x % y);
    }
}

