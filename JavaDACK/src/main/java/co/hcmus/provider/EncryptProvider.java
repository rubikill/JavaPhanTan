package co.hcmus.provider;

public interface EncryptProvider {
	StringBuffer hash(String path, String algorithm);

	Boolean checkSum(String srcPath, String desPath, String algorithm);
}
