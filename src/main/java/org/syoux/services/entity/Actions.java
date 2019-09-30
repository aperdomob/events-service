package org.syoux.services.entity;

public enum Actions {
  CREATE("Create"),
  READ("Read"),
  UPDATE("Update"),
  DELETE("Delete");

  private final String name;

  Actions(final String name) {
    this.name = name;
  }

  public boolean equalsName(String otherName) {
    return this.name.equals(otherName);
  }

  public String toString() {
    return this.name;
  }
}
