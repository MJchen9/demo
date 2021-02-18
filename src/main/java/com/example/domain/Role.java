package com.example.domain;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Description 角色
 *
 * @author chenmj
 * @date 2020-12-17 14:39
 **/
@Data
public class Role implements Serializable {

    private static final long serialVersionUID = -8605816479902286681L;

    private Long id;

    private Date createTime;

    private String roleName;

    private String description;

    private Long creatorId;

    private String status;

    private Integer isOrg;

    private Date updateTime;
}
