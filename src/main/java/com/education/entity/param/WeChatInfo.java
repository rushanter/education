package com.education.entity.param;

/**
 * 微信信息
 * @author lss
 * @since 2020-03-22
 */
public class WeChatInfo {

    private String unionId;

    private String nickName;

    private String sex;

    private String headImg;




    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WeChatInfo{");
        sb.append("unionId='").append(unionId).append('\'');
        sb.append(", nickName='").append(nickName).append('\'');
        sb.append(", sex='").append(sex).append('\'');
        sb.append(", headImg='").append(headImg).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
