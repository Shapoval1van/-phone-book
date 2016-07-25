package com.phonebook.model;

import javax.persistence.*;

@Entity
@Table(name ="group_c")
public class Group {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
        groupName = groupName;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public User getCreatedBy() {
        return creator;
    }

    public void setCreatedBy(User createdBy) {
        this.creator = createdBy;
    }
}
