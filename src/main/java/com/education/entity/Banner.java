package com.education.entity;

/**
 * @author lss
 * @since 2020-03-22
 */
public class Banner extends BaseEntity {

    private String bannerId;

    private String image;

    private String title;

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Banner banner = (Banner) o;
        return bannerId.equals(banner.bannerId);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Banner{");
        sb.append("id='").append(super.getId()).append('\'');
        sb.append(", bannerId='").append(bannerId).append('\'');
        sb.append(", image='").append(image).append('\'');
        sb.append(", title=='").append(title).append('\'');
        sb.append(", createTime='").append(super.getCreateTime()).append('\'');
        sb.append(", updatedTime='").append(super.getUpdatedTime()).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return bannerId.hashCode();
    }
}
