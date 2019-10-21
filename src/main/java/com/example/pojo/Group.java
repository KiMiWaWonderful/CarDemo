package com.example.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_group")
public class Group implements Serializable {

    @Id
  //  @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String groupName;

    @Lob
    @Column(nullable = true,columnDefinition = "TEXT")
    private String groupDesc;

    public Group(String groupName, String groupDesc) {
        this.groupName = groupName;
        this.groupDesc = groupDesc;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public Group() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id='" + id + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupDesc='" + groupDesc + '\'' +
                '}';
    }
}
