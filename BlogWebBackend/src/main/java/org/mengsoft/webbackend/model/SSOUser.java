package org.mengsoft.webbackend.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "SSO_USER")
public class SSOUser {
    /**
     * user_id
     */
    @Id
    @Column(name = "SSO_ID")
    private Long ssoId;

    /**
     * USER_ID
     */
    @Column(name = "USER_ID")
    private Integer userId;

    /**
     * token
     */
    @Column(name = "TOKEN")
    private String token;

    /**
     * token
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;

    /**
     * 获取user_id
     *
     * @return SSO_ID - user_id
     */
    public Long getSsoId() {
        return ssoId;
    }

    /**
     * 设置user_id
     *
     * @param ssoId user_id
     */
    public void setSsoId(Long ssoId) {
        this.ssoId = ssoId;
    }

    /**
     * 获取USER_ID
     *
     * @return USER_ID - USER_ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置USER_ID
     *
     * @param userId USER_ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取token
     *
     * @return TOKEN - token
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置token
     *
     * @param token token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取token
     *
     * @return CREATE_DATE - token
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置token
     *
     * @param createDate token
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}