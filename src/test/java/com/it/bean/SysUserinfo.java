package com.it.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName sys_userinfo
 */
public class SysUserinfo implements Serializable {
    /**
     * 主键
     */
    private String guid;

    /**
     * 登陆账号
     */
    private String username;

    /**
     * 登陆密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 居住地址
     */
    private Address address;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否注销
     */
    private String isDelete;

    /**
     * 最后一次登陆时间
     */
    private Date lastLoginDate;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public String getGuid() {
        return guid;
    }

    /**
     * 主键
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * 登陆账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 登陆账号
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 登陆密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 登陆密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 电话号码
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 电话号码
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 居住地址
     */
    public Address getAddress() {
        return address;
    }

    /**
     * 居住地址
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 是否注销
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 是否注销
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 最后一次登陆时间
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * 最后一次登陆时间
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysUserinfo other = (SysUserinfo) that;
        return (this.getGuid() == null ? other.getGuid() == null : this.getGuid().equals(other.getGuid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getLastLoginDate() == null ? other.getLastLoginDate() == null : this.getLastLoginDate().equals(other.getLastLoginDate()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuid() == null) ? 0 : getGuid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getLastLoginDate() == null) ? 0 : getLastLoginDate().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", guid=").append(guid);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", telephone=").append(telephone);
        sb.append(", email=").append(email);
        sb.append(", address=").append(address);
        sb.append(", remark=").append(remark);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", lastLoginDate=").append(lastLoginDate);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}