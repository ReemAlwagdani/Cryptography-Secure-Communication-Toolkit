
//Student Name: Reem Rakan Alwagdani
//ID: 2323653
//Section: IAR
//-----------------------------------

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import javax.swing.JOptionPane;

public class AES_ECB_CBC_Encryption {
    
    // AES block size = 16 bytes (128 bits)
    private static final int BLOCK_SIZE = 16;

    public static void main(String[] args) {
        try {
            // Read message from user 
            String message = JOptionPane.showInputDialog(null, "Enter a message:");

            if (message == null) {
                // user pressed Cancel
                return;
            }

           
            byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);

            // Validate message length multiple of 16 bytes (AES block size)
            if (messageBytes.length == 0 || (messageBytes.length % BLOCK_SIZE != 0)) {
                JOptionPane.showMessageDialog(
                        null,
                        "Error: Message length must be a multiple of 16 bytes.\n" +
                        "Tip: Use repeated blocks and ensure total length is multiple of 16.\n" +
                        "Example: hernameisjasmineababababababababhernameisjasmine",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            //  Generate AES key
           
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();

            // Prepare IV for CBC
           
            byte[] iv = new byte[BLOCK_SIZE];
            SecureRandom random = new SecureRandom();
            random.nextBytes(iv);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);

            //  Setup Ciphers 
            Cipher ecbEncrypt = Cipher.getInstance("AES/ECB/NoPadding");
            Cipher ecbDecrypt = Cipher.getInstance("AES/ECB/NoPadding");

            Cipher cbcEncrypt = Cipher.getInstance("AES/CBC/NoPadding");
            Cipher cbcDecrypt = Cipher.getInstance("AES/CBC/NoPadding");

            ecbEncrypt.init(Cipher.ENCRYPT_MODE, secretKey);
            ecbDecrypt.init(Cipher.DECRYPT_MODE, secretKey);

            cbcEncrypt.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
            cbcDecrypt.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

            // Encrypt block-by-block and print Base64 per block 
            StringBuilder ecbOutput = new StringBuilder();
            StringBuilder cbcOutput = new StringBuilder();

          
            byte[] ecbCiphertextAll = new byte[messageBytes.length];
            byte[] cbcCiphertextAll = new byte[messageBytes.length];

            ecbOutput.append("Encryption Using ECB Mode:\n");
            ecbOutput.append("Message: ").append(message).append("\n");

            cbcOutput.append("Encryption Using CBC Mode:\n");
            cbcOutput.append("Message: ").append(message).append("\n");

            // ECB: each block encrypted independently -> repeated plaintext blocks => repeated ciphertext blocks
            // CBC: each block depends on previous (and IV) -> repeated plaintext blocks usually produce different outputs
            for (int blockIndex = 0; blockIndex < messageBytes.length / BLOCK_SIZE; blockIndex++) {
                int offset = blockIndex * BLOCK_SIZE;

                byte[] plainBlock = new byte[BLOCK_SIZE];
                System.arraycopy(messageBytes, offset, plainBlock, 0, BLOCK_SIZE);

                // Encrypt ONE block (16 bytes) at a time
                byte[] ecbEncryptedBlock = ecbEncrypt.update(plainBlock);
                byte[] cbcEncryptedBlock = cbcEncrypt.update(plainBlock);

                // Store in full ciphertext arrays
                System.arraycopy(ecbEncryptedBlock, 0, ecbCiphertextAll, offset, BLOCK_SIZE);
                System.arraycopy(cbcEncryptedBlock, 0, cbcCiphertextAll, offset, BLOCK_SIZE);

                // Convert each block separately to Base64 
                String ecbB64 = Base64.getEncoder().encodeToString(ecbEncryptedBlock);
                String cbcB64 = Base64.getEncoder().encodeToString(cbcEncryptedBlock);

                ecbOutput.append("Encrypted Block").append(blockIndex + 1).append(": ").append(ecbB64).append("\n");
                cbcOutput.append("Encrypted Block").append(blockIndex + 1).append(": ").append(cbcB64).append("\n");
            }

       
            ecbEncrypt.doFinal();
            cbcEncrypt.doFinal();

            //Decrypt full ciphertext and show message 
            byte[] ecbDecrypted = ecbDecrypt.doFinal(ecbCiphertextAll);
            byte[] cbcDecrypted = cbcDecrypt.doFinal(cbcCiphertextAll);

            String ecbDecryptedText = new String(ecbDecrypted, StandardCharsets.UTF_8);
            String cbcDecryptedText = new String(cbcDecrypted, StandardCharsets.UTF_8);

            ecbOutput.append("Decrypted Message: ").append(ecbDecryptedText).append("\n\n");
            cbcOutput.append("Decrypted Message: ").append(cbcDecryptedText).append("\n\n");

            // Compare ECB vs CBC
            String comparison =
                    "Comparison (ECB vs CBC):\n" +
                    "- ECB encrypts each block independently.\n" +
                    "  If plaintext blocks repeat, ciphertext blocks repeat (pattern leakage).\n" +
                    "- CBC chains blocks using XOR with previous ciphertext (and IV).\n" +
                    "  Even if plaintext blocks repeat, ciphertext blocks usually differ.\n";

            // Show output in one dialog 
            JOptionPane.showMessageDialog(
                    null,
                    ecbOutput.toString() + cbcOutput.toString() + comparison,
                    "AES Output",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + e.getMessage(),
                    "Exception",
                    JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
        }
    }
}

