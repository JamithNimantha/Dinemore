package lk.ijse.dinemore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tel_operator")
public class TelOperator{
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;
    private String mobile;
    private String nic;

    public TelOperator() {
    }

    public TelOperator(int id, String name, String address, String mobile, String nic) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.nic = nic;
    }

    public TelOperator(String name, String address, String mobile, String nic) {
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
        return "TelOperator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", nic='" + nic + '\'' +
                '}';
    }
}
