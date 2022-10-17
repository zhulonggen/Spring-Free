package com.santi.pojo;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

public class Free {
    private int id;
    private String title;
    private Integer pid;

    private List<Free> children;

    public Free(Integer pid) {
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Free free = (Free) o;
        return id == free.id && Objects.equals(title, free.title) && Objects.equals(pid, free.pid);
    }

    public Free(int id, String title, Integer pid) {
        this.id = id;
        this.title = title;
        this.pid = pid;
    }

    public Free() {
    }

    @Override
    public String toString() {
        return "Free{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pid=" + pid +
                ", children=" + children +
                '}';
    }

    public List<Free> getChildren() {
        return children;
    }

    public void setChildren(List<Free> children) {
        this.children = children;
    }

    public Free(int id, String title, Integer pid, List<Free> children) {
        this.id = id;
        this.title = title;
        this.pid = pid;
        this.children = children;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, pid);
    }
}
