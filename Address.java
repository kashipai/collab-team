public class Address {
    private int doorNo;
    private String street;
    private String area;
  public Address(int dn, String street, String area){
      this.doorNo = dn;
      this.street = street;
      this.area = area;
  }
    public int getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(int doorNo) {
        this.doorNo = doorNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
