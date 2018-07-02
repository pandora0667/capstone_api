package io.wisoft.capstone.controller;

import org.json.JSONObject;

@SuppressWarnings("ALL")
public class ResponseCommand {
  // TODO GSON 변경

  protected String getOK() {
    JSONObject OK = new JSONObject();
    OK.put("result", "ok");

    return OK.toString();
  }

  protected String getNoContent() {
    JSONObject noItem = new JSONObject();
    noItem.put("result", "no");
    noItem.put("description", "해당하는 정보를 찾을 수 없습니다.");

    return noItem.toString();
  }

  protected String getExist() {
    JSONObject exist = new JSONObject();
    exist.put("result", "no");
    exist.put("description", "데이터가 이미 존재합니다.");

    return exist.toString();
  }

  protected String getRemoved() {
    JSONObject removed = new JSONObject();
    removed.put("result", "no");
    removed.put("description", "데이터가 이미 삭제되었습니다.");

    return removed.toString();
  }

  protected String getInternalServerError() {
    JSONObject removed = new JSONObject();
    removed.put("result", "no");
    removed.put("description", "서버내부에 에러가 발생했습니다.");

    return removed.toString();
  }
}
