package util;
import java.security.MessageDigest;
public class HashAlgorithm_SHA2 {

	        public static String getHashSha2(String password) {
	                byte[] cipher_byte;
	                try{
	                        MessageDigest md = MessageDigest.getInstance("SHA-256");
	                        md.update(password.getBytes());
	                        cipher_byte = md.digest();
	                        StringBuilder sb = new StringBuilder(2 * cipher_byte.length);
	                        for(byte b: cipher_byte) {
	                                sb.append(String.format("%02x", b&0xff) );
	                        }
	                        return sb.toString();
	                } catch (Exception e) {
	                        e.printStackTrace();
	                }
					return null;
	        }
	        public static void main(String[] args) {
				System.out.println(getHashSha2("12356"));
				System.out.println(getHashSha2("abcdefg"));
				System.out.println(getHashSha2("123456"));
			}
	}
