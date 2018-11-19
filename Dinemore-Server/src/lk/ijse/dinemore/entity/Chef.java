package lk.ijse.dinemore.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chef")
public class Chef {
    @Id
    private int id;
    private String name;
    private String mobile;
    private String address;
    private String nic;

}
