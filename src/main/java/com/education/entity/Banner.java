package com.education.entity;

import java.sql.Timestamp;

/**
 * @author lss
 * @since 2020-03-22
 */
public class Banner {
    private Integer id;

    private String image;

    private String title;

    private Timestamp createTime;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Banner banner = (Banner) o;

        return image.equals(banner.image);

    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id='").append(id).append('\'');
        sb.append("image'").append(image).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return image.hashCode();
    }
}
