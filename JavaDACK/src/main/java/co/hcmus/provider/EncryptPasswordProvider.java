package co.hcmus.provider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptPasswordProvider implements EncryptProvider {
	private String plainPassword;
	private String algorithm;
	
	
	public EncryptPasswordProvider(){
		
	}
	
	public EncryptPasswordProvider(String plainPassword){
		this.plainPassword = plainPassword;
		this.algorithm = "MD5";
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
	public StringBuffer hash() {
		return doHash(plainPassword, algorithm);
	}

}
