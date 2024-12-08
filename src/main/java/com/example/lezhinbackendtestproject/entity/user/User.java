package com.example.lezhinbackendtestproject.entity.user;

import com.example.lezhinbackendtestproject.domain.auth.dto.request.AuthRequest;
import com.example.lezhinbackendtestproject.entity.base.BaseTime;
import com.example.lezhinbackendtestproject.enums.auth.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
@Entity
@Table(catalog = "lezhin", name = "t_user_mst")
public class User extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_seq")
    private Long seq;

    @NotNull
    @Column(name = "f_user_id")
    private String userId;

    @NotNull
    @Column(name = "f_user_name")
    private String userName;

    @NotNull
    @Column(name = "f_user_pwd")
    private String userPassword;

    @Column(name = "f_email_addr")
    private String emailAddress;

    @Column(name = "f_phone_no")
    private String phoneNumber;

    @Column(name = "f_adult_yn")
    private String adultYn;

    @Column(name = "f_status")
    private String status;

    @Column(name = "f_last_login_date")
    private LocalDateTime lastLoginDate;

    @NotNull
    @Column(name = "f_reg_id")
    private String regId;

    @Column(name = "f_mdfy_id")
    private String modifyID;

    public static User toEntity(AuthRequest.Register request, String userPassword){
        return User.builder()
                .userId(request.getUserId())
                .userName(request.getUserName())
                .userPassword(userPassword)
                .emailAddress(request.getEmailAddress())
                .phoneNumber(request.getPhoneNumber())
                .adultYn("N")
                .status(UserStatus.ACTIVE.getValue())
                .lastLoginDate(LocalDateTime.now())
                .regId("SYSTEM")
                .build();
    }

}
