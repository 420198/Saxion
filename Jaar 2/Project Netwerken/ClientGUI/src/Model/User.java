package Model;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * Created by sklar on 3/13/2017.
 */
public class User {
    private String username;
    private String ip;
    private PublicKey pb;

    public User(String username, String ip) {
        this.username = username;
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public String getUsername() {
        return username;
    }

    public PublicKey getPb() {
        return pb;
    }

    public void setPb(PublicKey pb) {
        this.pb = pb;
    }

    public String getPublicKeyString() throws GeneralSecurityException {
        KeyFactory fact = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec spec = fact.getKeySpec(pb, X509EncodedKeySpec.class);
        return base64Encode(spec.getEncoded());
    }

    public void storePublicKey(String stored) throws GeneralSecurityException {
        byte[] data = base64Decode(stored);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(data);
        KeyFactory fact = KeyFactory.getInstance("RSA");
        this.pb = fact.generatePublic(spec);
    }

    private String base64Encode(byte[] array) {
        return Base64.getEncoder().encodeToString(array);
    }

    private static byte[] base64Decode(String key) {
        return Base64.getDecoder().decode(key);
    }
}
