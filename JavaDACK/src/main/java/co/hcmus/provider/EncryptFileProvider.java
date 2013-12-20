package co.hcmus.provider;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Encrypt file
 * @author Thanh Toan
 *
 */
public class EncryptFileProvider implements EncryptProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(EncryptFileProvider.class);
	
	public EncryptFileProvider() {

	}

	/**
	 * Do Hash
	 * 
	 * @param filePath
	 *            filePath path of file you want to hash
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private StringBuffer doHash(String filePath, String algorithm) {
		try {
			// Get instance
			MessageDigest md = MessageDigest.getInstance(algorithm);
			FileInputStream fis = new FileInputStream(filePath);
			byte[] dataBytes = new byte[1024];
			int nread = 0;
			while ((nread = fis.read(dataBytes)) != -1) {
				md.update(dataBytes, 0, nread);
			}
			byte[] mdbytes = md.digest();
			// convert the byte to hex format
			StringBuffer sb = new StringBuffer("");
			for (int i = 0; i < mdbytes.length; i++) {
				sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			fis.close();
			logger.info("EncryptFileProvider do Hash");
			return sb;
		} catch (NoSuchAlgorithmException e) {
			logger.error("Error EncryptFileProvider NoSuchAlgorithmException dohash ");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("Error EncryptFileProvider IOException dohash ");
			e.printStackTrace();
		}

		return null;
	}

	private Boolean isMatch(String plainPassword, String checkSum,
			String algorithm) {
		// String hashedPassword = doHash(plainPassword, algorithm);

		// return hashedPassword.equals(checkSum);

		return true;
	}

	@Override
	public StringBuffer hash(String path, String algorithm) {
		return doHash(path, algorithm);
	}

	@Override
	public Boolean checkSum(String srcPath, String desPath, String algorithm) {
		return isMatch(srcPath, desPath, algorithm);
	}
}
