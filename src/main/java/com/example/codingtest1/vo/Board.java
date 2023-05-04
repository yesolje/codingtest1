package com.example.codingtest1.vo;

public class Board {
    private String parent_idx;
    private String child_id;
    private String category_nm;
    public Board(){}
    public Board(String parent_idx, String child_id, String category_nm) {
        this.parent_idx = parent_idx;
        this.child_id = child_id;
        this.category_nm = category_nm;
    }

    public String getParent_idx() {
        return parent_idx;
    }

    public void setParent_idx(String parent_idx) {
        this.parent_idx = parent_idx;
    }

    public String getChild_id() {
        return child_id;
    }

    public void setChild_id(String child_id) {
        this.child_id = child_id;
    }

    public String getCategory_nm() {
        return category_nm;
    }

    public void setCategory_nm(String category_nm) {
        this.category_nm = category_nm;
    }

    @Override
    public String toString() {
        return "Board{" +
                "parent_idx='" + parent_idx + '\'' +
                ", child_id='" + child_id + '\'' +
                ", category_nm='" + category_nm + '\'' +
                '}';
    }

}
