import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Scanner;

public class EncryptionDecryption {
// encryption and decryption

    private static final String AES
            = "AES";

    // We are using a Block cipher(CBC mode)
    private static final String AES_CIPHER_ALGORITHM
            = "AES/CBC/PKCS5PADDING";

    // Function to create a
    // secret key
    public static SecretKey createAESKey()
            throws Exception {
        SecureRandom securerandom
                = new SecureRandom();
        KeyGenerator keygenerator
                = KeyGenerator.getInstance(AES);

        keygenerator.init(256, securerandom);
        SecretKey key
                = keygenerator.generateKey();

        return key;
    }

    // Function to initialize a vector
    // with an arbitrary value
    public static byte[] createInitializationVector() {

        // Used with encryption
        byte[] initializationVector
                = new byte[16];
        SecureRandom secureRandom
                = new SecureRandom();
        secureRandom.nextBytes(initializationVector);
        return initializationVector;
    }

    // This function takes plaintext,
    // the key with an initialization
    // vector to convert plainText
    // into CipherText.
    public static byte[] do_AESEncryption(
            String plainText,
            SecretKey secretKey,
            byte[] initializationVector)
            throws Exception {
        Cipher cipher
                = Cipher.getInstance(
                AES_CIPHER_ALGORITHM);

        IvParameterSpec ivParameterSpec
                = new IvParameterSpec(
                initializationVector);

        cipher.init(Cipher.ENCRYPT_MODE,
                secretKey,
                ivParameterSpec);

        return cipher.doFinal(
                plainText.getBytes());
    }

    // This function performs the
    // reverse operation of the
    // do_AESEncryption function.
    // It converts ciphertext to
    // the plaintext using the key.
    public static String do_AESDecryption(
            byte[] cipherText,
            SecretKey secretKey,
            byte[] initializationVector)
            throws Exception {
        Cipher cipher
                = Cipher.getInstance(
                AES_CIPHER_ALGORITHM);

        IvParameterSpec ivParameterSpec
                = new IvParameterSpec(
                initializationVector);

        cipher.init(
                Cipher.DECRYPT_MODE,
                secretKey,
                ivParameterSpec);

        byte[] result
                = cipher.doFinal(cipherText);

        return new String(result);
    }

    public static String toHex(byte[] data) {
        String output = "";
        for (byte d : data) {
            String nextByte = Integer.toHexString(d & 0xFF).toUpperCase();
            if (nextByte.length() < 2) {
                nextByte = "0" + nextByte;
            }
            output += nextByte;
        }
        output += "\n";
        return output;
    }

    // Driver code
    public static void encryptDecrypt() throws Exception {
        SecretKey Symmetrickey = createAESKey();

        System.out.println(
                "The Symmetric Key is :" + toHex(Symmetrickey.getEncoded()));

        byte[] initializationVector = createInitializationVector();

        System.out.print("Pliis entser ze Mässitsch: ");
        Scanner eingabe = new Scanner(System.in);
        String message = eingabe.nextLine();

        // Encrypting the message
        // using the symmetric key
        byte[] cipherText
                = do_AESEncryption(
                message,
                Symmetrickey,
                initializationVector);

        System.out.println(
                "The ciphertext or "
                        + "Encrypted Message is: "
                        + toHex(
                        cipherText));

        // Decrypting the encrypted
        // message
        String decryptedText
                = do_AESDecryption(
                cipherText,
                Symmetrickey,
                initializationVector);

        System.out.println(
                "Your original message is: "
                        + decryptedText);
    }
}

