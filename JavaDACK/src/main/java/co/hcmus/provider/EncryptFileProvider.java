package co.hcmus.provider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptFileProvider implements EncryptProvider {
	private String filePath;
	private String algorithm;

	public EncryptFileProvider() {

	}

	public EncryptFileProvider(String filePath) {
		this.filePath = filePath;
		this.algorithm = "MD5";
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
			return sb;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * CheckSum data
	 * 
	 * @param dataFile
	 *            file to check
	 * @param checkSumFile
	 *            hash file
	 * @return true/false
	 */
	// public Boolean checkSum(String dataFile, String checkSumFile) {
	// // Read data from checkSumFile to check
	// // Viet cai cho doc tu file len dum t cho nay
	// String trueData = "";
	//
	// // Hash file dataFile
	// String checkData = doHash(checkSumFile).toString();
	//
	// return trueData.equals(checkData);
	// }

	@Override
	public StringBuffer hash() {
		return doHash(filePath, algorithm);
	}

}
