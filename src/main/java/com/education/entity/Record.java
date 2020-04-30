package com.education.entity;

import java.sql.Timestamp;

/**
 * @author lss
 * @since 2020-03-22
 */
public class Record extends BaseEntity {

    private String recordId;

    private int type;

    private String video;

    private String image;

    private String title;

    private int recommend;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
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

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Record record = (Record) o;
        return recordId.equals(record.recordId);
    }

    @Override
    public String toString() {

        final StringBuffer sb = new StringBuffer("Record{");
        sb.append("id='").append(super.getId()).append('\'');
        sb.append(", recordId='").append(recordId).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", video='").append(video).append('\'');
        sb.append(", image='").append(image).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", recommend='").append(recommend).append('\'');
        sb.append(", createTime='").append(super.getCreateTime()).append('\'');
        sb.append(", updatedTime='").append(super.getUpdatedTime()).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return recordId.hashCode();
    }
}

