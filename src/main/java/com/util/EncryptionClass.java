package com.util;

import org.apache.commons.codec.digest.DigestUtils;

public class EncryptionClass {

	public String encrypt(String value) {
		value = DigestUtils.md5Hex(value); //Hash a String.
		return value;
	}

}
