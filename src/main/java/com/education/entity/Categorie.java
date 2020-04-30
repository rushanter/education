package com.education.entity;

import java.sql.Timestamp;

/**
 * @author lss
 * @since 2020-03-22
 */
public class Categorie extends BaseEntity {

    private String categorieId;

    private String title;

    private int type;

    public String getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(String categorieId) {
        this.categorieId = categorieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Categorie categorie = (Categorie) o;
        return categorieId.equals(categorie.categorieId);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Categorie{");
        sb.append("id='").append(super.getId()).append('\'');
        sb.append(", categorieId='").append(categorieId).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", createTime='").append(super.getCreateTime()).append('\'');
        sb.append(", updatedTime='").append(super.getUpdatedTime()).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return categorieId.hashCode();
    }

}
