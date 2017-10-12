package Model.Encryption.End2End;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author JavaDigest
 *
 */
public class EncryptAndDecryptEnd2End {

    /**
     * String to hold name of the encryption algorithm.
     */
    private static final String ALGORITHM = "RSA";

    /**
     * String to hold the private key.
     */
    private static PrivateKey PRIVATE_KEY;

    /**
     * String to hold the public key.
     */
    private static PublicKey PUBLIC_KEY;


    public static void generateKey() {
        if (PRIVATE_KEY == null || PUBLIC_KEY == null) {
            try {
                final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
                keyGen.initialize(1024);
                final KeyPair key = keyGen.generateKeyPair();

                PUBLIC_KEY = key.getPublic();
                PRIVATE_KEY = key.getPrivate();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Encrypt the plain text using public key.
     *
     * @param text: original plain text
     * @param key:The public key
     * @return Encrypted text
     */
    static byte[] encrypt(String text, PublicKey key) {
        byte[] cipherText = null;
        try {
            // get an RSA cipher object and print the provider
            final Cipher cipher = Cipher.getInstance(ALGORITHM);
            // encrypt the plain text using the public key
            cipher.init(Cipher.ENCRYPT_MODE, key);
            cipherText = cipher.doFinal(text.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cipherText;
    }

    /**
     * Decrypt text using private key.
     *
     * @param text:encrypted text
     * @return plain text
     */
    static String decrypt(byte[] text) {
        byte[] decryptedText = null;
        try {
            // get an RSA cipher object and print the provider
            final Cipher cipher = Cipher.getInstance(ALGORITHM);

            // decrypt the text using the private key
            cipher.init(Cipher.DECRYPT_MODE, PRIVATE_KEY);
            decryptedText = cipher.doFinal(text);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new String(decryptedText);
    }

    public static PublicKey getPublicKey() {
        return PUBLIC_KEY;
    }
}