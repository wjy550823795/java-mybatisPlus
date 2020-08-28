package com.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;

import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangjunyu.5508
 * @since 2020-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Userinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /***
     * 默认模糊查询
     */
    @TableField(condition=SqlCondition.LIKE)
    private String name;

    private String emplyee;

    private String email;

    private String diqu;

    private String department;

    private String departmentId;

    private Long updatetimeunix;

    private LocalDate updatetime;

    private Integer labelid;

    private String picture;

    private String sp1;

    private String sp2;

    private String sp3;

    @TableField(exist=false)
    private String zhiji;


}
