package co.hcmus.provider;

/**
 * This interface use for encrypt
 * @author Thanh Toan
 *
 */
public interface EncryptProvider {
	/**
	 * Has file/string
	 * @param path
	 * @param algorithm
	 * @return
	 */
	StringBuffer hash(String path, String algorithm);
	
	/**
	 * Check 
	 * @param srcPath
	 * @param desPath
	 * @param algorithm
	 * @return
	 */
	Boolean checkSum(String srcPath, String desPath, String algorithm);
}
