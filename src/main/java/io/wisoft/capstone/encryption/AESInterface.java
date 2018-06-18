package io.wisoft.capstone.encryption;

public interface AESInterface {
  String encrypt(final String strToEncrypt, String secret);
  String decrypt(final String strToDecrypt, final String secret);
}
