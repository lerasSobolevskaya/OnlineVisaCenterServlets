package by.sobol.visacenter.service.util;

import org.apache.commons.codec.digest.DigestUtils;

public final class PasswordEncryptor {

	public static String md5Apache(String str) {
		return DigestUtils.md2Hex(str);
	}
}
