package io.wisoft.capstone.error;

import org.json.JSONObject;

public class ErrorCommands {
  final static int BAD_REQUEST = 1;
  final static int NOT_FOUND = 2;
  final static int METHOD_NOT_ALLOWED = 3;
  final static int UNSUPPORTED_MEDIA = 4;
  final static int INTERNAL_SERVER_ERROR = 5;
  final static int NOT_IMPLEMENTED = 6;

  private JSONObject error;

  public ErrorCommands() {
    this.error = new JSONObject();
    error.put("result", "error");
  }

  public String error(final int select) {
    String response = null;

    switch (select) {
      case BAD_REQUEST:
        response = getBadRequest();
        break;
      case NOT_FOUND:
        response = getNotFound();
        break;
      case METHOD_NOT_ALLOWED:
        response = getMethodNotAllowed();
        break;
      case UNSUPPORTED_MEDIA:
        response = getUnsupportedMedia();
        break;
      case INTERNAL_SERVER_ERROR:
        response = getInternalServerError();
        break;
      case NOT_IMPLEMENTED:
        response = getNotImplemented();
        break;
    }
    return response;
  }

  private synchronized String getBadRequest() {
    error.put("error_code", "400");
    error.put("descriptions", "잘못된 요청을 보냈셨습니다.");
    return error.toString();
  }

  private synchronized String getNotFound() {
    error.put("error_code", "404");
    error.put("descriptions", "요청한 URI를 찾을 수 없습니다.");
    return error.toString();
  }

  private synchronized String getMethodNotAllowed() {
    error.put("error_code", "405");
    error.put("descriptions", "요청에 지정된 방법을 사용할 수 없습니다. 다른 방식으로 시도하세요.");
    return error.toString();
  }

  private synchronized String getUnsupportedMedia() {
    error.put("error_code", "415");
    error.put("descriptions", "지원하지 않는 미디어 타입입니다.");
    return error.toString();
  }

  private synchronized String getInternalServerError() {
    error.put("error_code", "500");
    error.put("descriptions", "서버의 오류가 발생하였습니다. 관리자에게 문의하세요.");
    return error.toString();
  }

  private synchronized String getNotImplemented() {
    error.put("error_code", "501");
    error.put("descriptions", "서버에 요청을 처리할 수 있는 기능이 없습니다.");
    return error.toString();
  }
}
