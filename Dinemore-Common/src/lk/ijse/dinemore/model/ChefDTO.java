package lk.ijse.dinemore.model;

public class ChefDTO extends SuperDTO {
    private int id;
    private String name;
    private String mobile;
    private String address;
    private String nic;

    public ChefDTO() {
    }

    public ChefDTO(String name, String mobile, String address, String nic) {
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.nic = nic;
    }

    public ChefDTO(int id, String name, String mobile, String address, String nic) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Override
    public String toString() {
        return "ChefDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                '}';
    }
}
