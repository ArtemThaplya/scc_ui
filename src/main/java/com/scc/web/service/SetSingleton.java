package com.scc.web.service;

import java.util.Set;

public class SetSingleton {

  private static SetSingleton instance;
  public Set<String> set;

  private SetSingleton(Set<String> set) {
    this.set = set;
  }

  public static SetSingleton getInstance(Set<String> set) {
    if (instance == null) {
      instance = new SetSingleton(set);
    }
    return instance;
  }
}
