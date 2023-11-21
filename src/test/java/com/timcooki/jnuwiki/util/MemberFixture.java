package com.timcooki.jnuwiki.util;

import com.timcooki.jnuwiki.domain.member.entity.Member;
import com.timcooki.jnuwiki.domain.member.entity.MemberRole;

public enum MemberFixture {

    ADMIN(1L, "aaa@gmail.com", "asdF123!", "관리자", MemberRole.ADMIN),
    MEMBER1(2L, "cc@gmail.com", "asdF123!", "1번 유저", MemberRole.USER),
    MEMBER2(3L, "bb@gmail.com", "asdF123!", "2번 유저", MemberRole.USER),
    ;

    private final Long memberId;
    private final String email;
    private final String password;
    private final String nickname;
    private final MemberRole memberRole;

    MemberFixture(Long memberId,
                  String email,
                  String password,
                  String nickname,
                  MemberRole memberRole) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.memberRole = memberRole;
    }


    public Member getMember() {
        return new Member(email, password, nickname, memberRole);
    }
}
