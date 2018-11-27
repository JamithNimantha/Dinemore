package lk.ijse.dinemore.model;

public class RiderDTO extends SuperDTO{
    private int id;
    private String name;
    private String address;
    private String mobile;
    private String nic;

    public RiderDTO() {
    }

    public RiderDTO(int id, String name, String address, String mobile, String nic) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.nic = nic;
    }

    public RiderDTO(String name, String address, String mobile, String nic) {
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.nic = nic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Override
    public String toString() {
        return "RiderDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", nic='" + nic + '\'' +
                '}';
    }
}
