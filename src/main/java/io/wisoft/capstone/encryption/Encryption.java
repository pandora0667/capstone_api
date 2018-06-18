package io.wisoft.capstone.encryption;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Encryption {
  private final static String secretKey = "wisoftseongwon";
  // TODO 싱글톤 적용
  private AES aes = new AES();

//
//  private static String readToSecretKeyFile() {
//    String secretKey = null;
//    try {
//      File file = new File("./secretKey.txt");
//      Scanner scanner = new Scanner(file);
//      while (scanner.hasNextLine()) {
//        secretKey = scanner.nextLine();
//      }
//    } catch (FileNotFoundException e) {
//      e.printStackTrace();
//    }
//    return secretKey;
//  }

  public String encryption(final String password) {
    return aes.encrypt(password, secretKey);
  }

  public String decryption(final String password) {
    return aes.decrypt(password, secretKey);
  }
}
