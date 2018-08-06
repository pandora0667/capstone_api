package io.wisoft.capstone.encryption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// TODO 예외 발생시 로직상 처리방안 고안

public class Security {
  private final Logger logger = LoggerFactory.getLogger(Security.class);

  public String sha256(final String password) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
      messageDigest.update(password.getBytes());
      byte byteData[] = messageDigest.digest();
      StringBuffer buffer = new StringBuffer();

      for (byte data : byteData) {
        buffer.append(Integer.toString(data & 0xff + 0x100, 16).substring(1));
      }
      return buffer.toString();
    } catch (NoSuchAlgorithmException e) {
      logger.error("Error :" , e);
      return null;
    }
  }
}
