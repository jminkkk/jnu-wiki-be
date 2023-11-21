package com.timcooki.jnuwiki.domain.docs.exception;

public class DocsNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "해당 문서를 찾을 수 없습니다.";
    }
}
