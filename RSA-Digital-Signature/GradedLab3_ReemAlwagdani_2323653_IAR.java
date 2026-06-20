
package gradedlab3_reemalwagdani_2323653_iar;

import java.security.*;
import java.util.Arrays;
import java.util.Scanner;

public class GradedLab3_ReemAlwagdani_2323653_IAR {

    public static void main(String[] args) throws Exception {
         Scanner input = new Scanner(System.in);

        // Ask the user to enter the original message
        System.out.print("Enter the message to be signed: ");
        String originalMessage = input.nextLine();

        // Ask the user to enter a tampered message for testing
        System.out.print("Enter a modified/tampered message for testing: ");
        String tamperedMessage = input.nextLine();

        // Generate RSA public and private keys
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();

        // Create Signature object using SHA256withRSA
        Signature signature = Signature.getInstance("SHA256withRSA");

        // Sign the original message using the private key
        signature.initSign(keyPair.getPrivate());
        signature.update(originalMessage.getBytes());
        byte[] signatureBytes = signature.sign();

        // Verify the original message using the public key
        signature.initVerify(keyPair.getPublic());
        signature.update(originalMessage.getBytes());
        boolean originalVerified = signature.verify(signatureBytes);

        // Verify the tampered message using the same signature
        signature.initVerify(keyPair.getPublic());
        signature.update(tamperedMessage.getBytes());
        boolean tamperedVerified = signature.verify(signatureBytes);

        // Display results
        System.out.println("\n--- Digital Signature Results ---");
        System.out.println("Signature Algorithm: SHA256withRSA");
        System.out.println("Signature (Hex): " + bytesToHex(signatureBytes));
        System.out.println("Signature (Bytes): " + Arrays.toString(signatureBytes));
        System.out.println("Length: " + signatureBytes.length + " bytes / " + (signatureBytes.length * 8) + " bits");

        System.out.println("\n--- Verification Results ---");
        System.out.println("Original Message: " + originalMessage);
        System.out.println("Verification using the original message: " + originalVerified);
        System.out.println("Tampered Message: " + tamperedMessage);
        System.out.println("Verification using the tampered message: " + tamperedVerified);

        input.close();
    }

    // Convert byte array to hexadecimal string
    public static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();

        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }

        return hexString.toString();
        
        
        
    }
    
}
