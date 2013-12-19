package co.hcmus.provider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

/**
 * Encrypt password
 * @author Thanh Toan
 *
 */
@Service("encryptPasswordProvider")
public class EncryptPasswordProvider implements EncryptProvider {

	public EncryptPasswordProvider(){
		
	}

	/**
	 * Do Hash
	 * 
	 * @param filePath
	 *            filePath path of file you want to hash
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private StringBuffer doHash(String plainPassword, String algorithm) {
		try {
			// Get instance
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(plainPassword.getBytes(), 0, plainPassword.length());
			byte[] mdbytes = md.digest();
			// convert the byte to hex format
			StringBuffer sb = new StringBuffer("");
			for (int i = 0; i < mdbytes.length; i++) {
				sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			return sb;
		} catch (NoSuchAlgorithmException e) {
			System.out.print("EncryptPasswordProvider: NO SUCH ALGORITHM");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public StringBuffer hash(String path, String algorithm) {
		return doHash(path, algorithm);
	}

	@Override
	public Boolean checkSum(String plainPassword, String desPath, String algorithm){
		String hashedPassword = doHash(plainPassword, algorithm).toString();
		return hashedPassword.equals(desPath);
	}
}
