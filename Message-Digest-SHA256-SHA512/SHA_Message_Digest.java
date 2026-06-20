
package gradedlab4_reemalwagdani_2323653_iar;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class SHA_Message_Digest {
/**
 * Message Digest using SHA-256 and SHA-512
 * 
 * This program accepts three strings from the user
 * and computes their hash values using SHA-256 and SHA-512.
 * 
 * It displays:
 * - Hash as Hex String
 * - Hash as Byte Array
 * - Digest length in bytes and bits
 */
    
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);

        // Accept three strings from the user
        System.out.print("Enter first string: ");
        String str1 = input.nextLine();

        System.out.print("Enter second string: ");
        String str2 = input.nextLine();

        System.out.print("Enter third string: ");
        String str3 = input.nextLine();

        // Store strings in array
        String[] messages = {str1, str2, str3};

        // SHA-256 Results
        System.out.println("\n--- SHA-256 Results ---");
        for (String message : messages) {
            generateHash(message, "SHA-256");
        }

        // SHA-512 Results
        System.out.println("\n--- SHA-512 Results ---");
        for (String message : messages) {
            generateHash(message, "SHA-512");
        }

        input.close();
    }

    /**
     * This method generates and displays the hash value
     * using the specified algorithm.
     */
    public static void generateHash(String text, String algorithm) {

        try {

            // Create MessageDigest object
            MessageDigest md = MessageDigest.getInstance(algorithm);

            // Generate hash as byte array
            byte[] hashBytes = md.digest(text.getBytes());

            // Convert byte array to hex string
            String hexHash = bytesToHex(hashBytes);

            // Display results
            System.out.println("\n[" + text + "]");
            System.out.println("Digest (Hex): " + hexHash);
            System.out.println("Digest (Bytes): " + Arrays.toString(hashBytes));
            System.out.println("Length: " 
                    + hashBytes.length + " bytes / "
                    + (hashBytes.length * 8) + " bits");

        } catch (NoSuchAlgorithmException e) {

            System.out.println("Error: Algorithm not found.");
        }
    }

    /**
     * This method converts byte array into hexadecimal string.
     */
    public static String bytesToHex(byte[] bytes) {

        StringBuilder sb = new StringBuilder();

        for (byte b : bytes) {

            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }
        
        
    }
    

