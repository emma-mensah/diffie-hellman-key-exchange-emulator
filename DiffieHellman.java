import java.util.*;

public class DiffieHellman {
    public static void main (String args[]) {
        Scanner kbd = new Scanner(System.in);

        System.out.println("Enter 2 prime numbers, p and g: ");
        int p = kbd.nextInt();
        int g = kbd. nextInt();

//      randomly pick a secret key, SA and SB
        int max = 100; int min = 0;
        int SA = (int) Math.floor(Math.random()*(max-min+1)+min);
        int SB = (int) Math.floor(Math.random()*(max-min+1)+min);
        System.out.println("\nRandom number(SA): "+ SA + " Random number(SB): " + SB);

        /**
         * Finding TA and TB = g^SA*modp and g^SB*modp respectively
         * Using the fast exponential modular arithmetic technique
         * **/
        int TA = 0; int TB = 0;
        long binaryForm = Long.parseLong(Integer.toBinaryString(SA));

        int val = 1;
        for(int i = 0; i < String.valueOf(binaryForm).length(); i++) {
            if (String.valueOf(binaryForm).charAt(i) == '0') {
                val = (int) Math.pow(val,2);
                if ( val > p) {
                    val = val % p;
                }
            }
            else if (String.valueOf(binaryForm).charAt(i) == '1') {
                val = (int) Math.pow(val,2);
                if ( val > p) {
                    val = val % p;
                }
                val = (val * g);
                if ( val > p) {
                    val = val % p;
                }
            }
        }
        TA = val;

        binaryForm = Long.parseLong(Integer.toBinaryString(SB));

        val = 1;
        for(int i = 0; i < String.valueOf(binaryForm).length(); i++) {
            if (String.valueOf(binaryForm).charAt(i) == '0') {
                val = (int) Math.pow(val,2);
                if ( val > p) {
                    val = val % p;
                }
            }
            else if (String.valueOf(binaryForm).charAt(i) == '1') {
                val = (int) Math.pow(val,2);
                if ( val > p) {
                    val = val % p;
                }
                val = (val * g);
                if ( val > p) {
                    val = val % p;
                }
            }
        }
        TB = val;

        System.out.println("TA: " + TA + ", TB: " + TB+ "\n");
        System.out.println("Calculating Secret Key...\n");

        /**
         * Finding the secret key using formula TB^SA*modp and TA^SB*modp
         * and the fast exponential modular algorithm
         * **/
        int K1 = 0; int K2 = 0; int secretKey = 0;

        binaryForm = Long.parseLong(Integer.toBinaryString(SA));

        val = 1;
        for(int i = 0; i < String.valueOf(binaryForm).length(); i++) {
            if (String.valueOf(binaryForm).charAt(i) == '0') {
                val = (int) Math.pow(val,2);
                if ( val > p) {
                    val = val % p;
                }
            }
            else if (String.valueOf(binaryForm).charAt(i) == '1') {
                val = (int) Math.pow(val,2);
                if ( val > p) {
                    val = val % p;
                }
                val = (val * TB);
                if ( val > p) {
                    val = val % p;
                }
            }
        }
        K1 = val;

        binaryForm = Long.parseLong(Integer.toBinaryString(SB));

        val = 1;
        for(int i = 0; i < String.valueOf(binaryForm).length(); i++) {
            if (String.valueOf(binaryForm).charAt(i) == '0') {
                val = (int) Math.pow(val,2);
                if ( val > p) {
                    val = val % p;
                }
            }
            else if (String.valueOf(binaryForm).charAt(i) == '1') {
                val = (int) Math.pow(val,2);
                if ( val > p) {
                    val = val % p;
                }
                val = (val * TA);
                if ( val > p) {
                    val = val % p;
                }
            }
        }
        K2 = val;

//        comparing keys
        if (K1 == K2) {
            secretKey = K1;
            System.out.println("Secret Key: " + secretKey);
        }
        else{
            System.out.println("Error in calculation. Try Again");
        }

    }
}
