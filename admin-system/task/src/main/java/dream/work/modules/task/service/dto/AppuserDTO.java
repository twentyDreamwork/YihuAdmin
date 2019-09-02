package dream.work.modules.task.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;


/**
* @author Yang
* @date 2019-09-01
*/
@Data
public class AppuserDTO implements Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 用户id
     */
    private Long userid;

    /**
     * 微信id
     */
    private String wxid;

    /**
     * 会员id
     */
    private String memberId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机
     */
    private String phone;

    /**
     * 平台
     */
    private Integer platform;

    /**
     * 邀请码
     */
    private String invitationcode;

    /**
     * 机器码
     */
    private String machinecode;

    /**
     * 访问ip
     */
    private String ip;

    /**
     * 頭像url
     */
    private String headimgurl;

    /**
     * 创建时间
     */
    private Timestamp createtime;

    /**
     * 创建人
     */
    private String creater;

    /**
     * 更新时间
     */
    private Timestamp updatetime;

    /**
     * 更新人
     */
    private String updater;

    /**
     * 登录时间
     */
    private Timestamp logintime;
}