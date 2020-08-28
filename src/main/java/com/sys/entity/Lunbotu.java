package com.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangjunyu.5508
 * @since 2020-04-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Lunbotu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "ahref不能为空")
    private String ahref;
    
    @NotNull(message = "imgsrc不能为空")
    @Size(min = 1, max = 5, message = "密码长度必须是1-5个字符")
    private String imgsrc;
    
    @NotNull(message = "divjianjie不能为空")
    private String divjianjie;
    
    @NotNull(message = "changedby不能为空")
    private String changedby;
    
    @NotNull(message = "state不能为空")
    private Integer state;

    
    

}
