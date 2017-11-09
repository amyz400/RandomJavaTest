package myteststuff.classes;

/**
 * Created by aziring on 9/18/17.
 */
public class SearchCriteria {

  private String name;
  private String city;
  private String zip;

  public SearchCriteria(String name, String city, String zip) {
    this.name = name;
    this.city = city;
    this.zip = zip;
  }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }
}
