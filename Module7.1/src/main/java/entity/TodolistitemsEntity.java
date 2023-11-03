package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "todolistitems", schema = "to-do-listdb")
public class TodolistitemsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "listitemID")
    private int listitemId;
    @Basic
    @Column(name = "listitem")
    private String listitem;

    public int getListitemId() {
        return listitemId;
    }

    public void setListitemId(int listitemId) {
        this.listitemId = listitemId;
    }

    public String getListitem() {
        return listitem;
    }

    public void setListitem(String listitem) {
        this.listitem = listitem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodolistitemsEntity that = (TodolistitemsEntity) o;

        if (listitemId != that.listitemId) return false;
        if (listitem != null ? !listitem.equals(that.listitem) : that.listitem != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = listitemId;
        result = 31 * result + (listitem != null ? listitem.hashCode() : 0);
        return result;
    }
}
