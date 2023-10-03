package state;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import model.User;

public class GlobalState {
  private static GlobalState instance;
  private ObjectProperty<String> page = new SimpleObjectProperty<String>();

  private User user;

  private GlobalState() {
  }

  public static GlobalState getInstance() {
    if (instance == null) {
      instance = new GlobalState();
    }
    return instance;
  }

  public ObjectProperty<String> getPage() {
    return this.page;
  }

  public void setPage(String page) {
    this.page.set(page);
  }

  public String getPageValue() {
    return this.page.get();
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
