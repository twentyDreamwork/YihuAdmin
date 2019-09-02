package dream.work.modules.task.domain;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author Yang
* @date 2019-09-01
*/
@Entity
@Data
@Table(name="appuser")
public class Appuser implements Serializable {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private String id;

    /**
     * 用户id
     */
    @Column(name = "UserId",nullable = false)
    private Long userid;

    /**
     * 微信id
     */
    @Column(name = "wxid")
    private String wxid;

    /**
     * 会员id
     */
    @Column(name = "member_id")
    private String memberId;

    /**
     * 用户名
     */
    @Column(name = "UserName")
    private String username;

    /**
     * 密码
     */
    @Column(name = "Password")
    private String password;

    /**
     * 手机
     */
    @Column(name = "Phone")
    private String phone;

    /**
     * 平台
     */
    @Column(name = "Platform")
    private Integer platform;

    /**
     * 邀请码
     */
    @Column(name = "InvitationCode")
    private String invitationcode;

    /**
     * 机器码
     */
    @Column(name = "MachineCode")
    private String machinecode;

    /**
     * 访问ip
     */
    @Column(name = "Ip")
    private String ip;

    /**
     * 頭像url
     */
    @Column(name = "Headimgurl")
    private String headimgurl;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    private Timestamp createtime;

    /**
     * 创建人
     */
    @Column(name = "Creater")
    private String creater;

    /**
     * 更新时间
     */
    @Column(name = "UpdateTime")
    private Timestamp updatetime;

    /**
     * 更新人
     */
    @Column(name = "Updater")
    private String updater;

    /**
     * 登录时间
     */
    @Column(name = "LoginTime")
    private Timestamp logintime;
}