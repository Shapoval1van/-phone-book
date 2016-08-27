package com.phonebook.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="group_c")
public class  Group  implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_c_id_seq")
    @SequenceGenerator(name = "group_c_id_seq", sequenceName = "group_c_id_seq", allocationSize=1 )
    private Integer id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "is_default")
    private Boolean isDefault;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = true, referencedColumnName = "id")
    private User creator;

    public Group() {
    }

    public Group(int id) {
    this.id = id;
    }


    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Boolean getDefault() {
        return this.isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }
}
