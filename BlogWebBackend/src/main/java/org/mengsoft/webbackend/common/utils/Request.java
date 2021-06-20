package org.mengsoft.webbackend.common.utils;

public class Request<E> {
  private E model;
  private String action;
  private String info;

  public E getModel() {
    return model;
  }

  public void setModel(E model) {
    this.model = model;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }
}
