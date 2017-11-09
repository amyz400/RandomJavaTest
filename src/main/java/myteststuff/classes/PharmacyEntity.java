package myteststuff.classes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

/**
 * Created by aziring on 9/5/17.
 */
@Indexed
@Entity
@Table(name = "PHARMACY")
public class PharmacyEntity implements Serializable {

  private int id;
  private String ncpdpId;
  private String npi;
  private String name;
  private String address1;
  private String address2;
  private String city;
  private String state;
  private String zipCode;
  private String primaryPhone;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id", unique=true, nullable=false, updatable=false, insertable=false)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Column(name="NCPDPID")
  public String getNcpdpId() {
    return ncpdpId;
  }

  public void setNcpdpId(String ncpdpId) {
    this.ncpdpId = ncpdpId;
  }

  @Column(name="NPI")
  public String getNpi() {
    return npi;
  }

  public void setNpi(String npi) {
    this.npi = npi;
  }

  @Column(name="name")
  @Field
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name="ADDRESS_LINE_1")
  public String getAddress1() {
    return address1;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  @Column(name="ADDRESS_LINE_2")
  public String getAddress2() {
    return address2;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  @Column(name="CITY")
  @Field
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Column(name="STATE")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Column(name="ZIP")
  @Field
  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  @Column(name="PHONE_PRIMARY")
  public String getPrimaryPhone() {
    return primaryPhone;
  }

  public void setPrimaryPhone(String primaryPhone) {
    this.primaryPhone = primaryPhone;
  }
//
//  @Column(name="FAX_FLAG")
//  public String getFax() {
//    return fax;
//  }
//
//  public void setFax(String fax) {
//    this.fax = fax;
//  }
//
//  @Column(name="EMAIL")
//  public String getEmail() {
//    return email;
//  }
//
//  public void setEmail(String email) {
//    this.email = email;
//  }
//
//  @Column(name="MAIL_ORDER_FLAG")
//  public boolean isMailOrder() {
//    return mailOrder;
//  }
//
//  public void setMailOrder(boolean mailOrder) {
//    this.mailOrder = mailOrder;
//  }
//
//  @Column(name="twenty_four_hour_flag")
//  public boolean isTwentyFourHour() {
//    return twentyFourHour;
//  }
//
//  public void setTwentyFourHour(boolean twentyFourHour) {
//    this.twentyFourHour = twentyFourHour;
//  }
//
//  @Column(name="retail_flag")
//  public boolean isRetail() {
//    return retail;
//  }
//
//  public void setRetail(boolean retail) {
//    this.retail = retail;
//  }
//
//  @Column(name="long_term_care_flag")
//  public boolean isLongTermCare() {
//    return longTermCare;
//  }
//
//  public void setLongTermCare(boolean longTermCare) {
//    this.longTermCare = longTermCare;
//  }
//
//  @Column(name="specialty")
//  public boolean isSpecialty() {
//    return specialty;
//  }
//
//  public void setSpecialty(boolean specialty) {
//    this.specialty = specialty;
//  }
//
//  @Column(name="start_date")
//  public LocalDateTime getStartDate() {
//    return startDate;
//  }
//
//  public void setStartDate(LocalDateTime startDate) {
//    this.startDate = startDate;
//  }
//
//  @Column(name="end_date")
//  public LocalDateTime getEndDate() {
//    return endDate;
//  }
//
//  public void setEndDate(LocalDateTime endDate) {
//    this.endDate = endDate;
//  }

}
