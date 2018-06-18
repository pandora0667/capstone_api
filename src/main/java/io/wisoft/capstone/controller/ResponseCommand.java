package io.wisoft.capstone.controller;

import org.json.JSONObject;

@SuppressWarnings("ALL")
public class ResponseCommand {

  protected String getOK() {
    JSONObject OK = new JSONObject();
    OK.put("result", "ok");

    return OK.toString();
  }

  protected String getNoContent() {
    JSONObject noItem = new JSONObject();
    noItem.put("result", "no");
    noItem.put("code", "204");
    noItem.put("description", "해당하는 정보를 찾을 수 없습니다.");

    return noItem.toString();
  }

  protected String getExist() {
    JSONObject exist = new JSONObject();
    exist.put("result", "no");
    exist.put("code", "204");
    exist.put("description", "데이터가 이미 존재합니다.");

    return exist.toString();
  }

  protected String getRemoved() {
    JSONObject removed = new JSONObject();
    removed.put("result", "no");
    removed.put("code", "204");
    removed.put("description", "데이터가 이미 삭제되었습니다.");

    return removed.toString();
  }
}
