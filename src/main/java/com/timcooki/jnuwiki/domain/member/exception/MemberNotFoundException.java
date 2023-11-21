package com.timcooki.jnuwiki.domain.member.exception;

public class MemberNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "존재하지 않는 회원입니다.";
    }
}
