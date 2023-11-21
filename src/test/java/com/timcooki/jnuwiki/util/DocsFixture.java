package com.timcooki.jnuwiki.util;

import com.timcooki.jnuwiki.domain.docs.entity.Docs;
import com.timcooki.jnuwiki.domain.docs.entity.DocsLocation;
import com.timcooki.jnuwiki.domain.docsRequest.entity.DocsCategory;
import com.timcooki.jnuwiki.domain.member.entity.Member;
import com.timcooki.jnuwiki.domain.member.entity.MemberRole;

public enum DocsFixture {

    DOCS1(1L, "문서1", new DocsLocation(), "관리자", MemberFixture.MEMBER1.getMember(), DocsCategory.CAFE),
    DOCS2(2L, "문서2", new DocsLocation(), "1번 유저", MemberFixture.MEMBER1.getMember(), DocsCategory.SCHOOL),
    DOCS3(3L, "문서3", new DocsLocation(), "2번 유저", MemberFixture.MEMBER2.getMember(), DocsCategory.SCHOOL),
    ;

    private final Long docsId;
    private final String docsName;
    private final DocsLocation docsLocation;
    private final String docsContent;
    private final Member createdBy;
    private final DocsCategory docsCategory;

    DocsFixture(Long docsId, String docsName, DocsLocation docsLocation, String docsContent, Member createdBy,
                DocsCategory docsCategory) {
        this.docsId = docsId;
        this.docsName = docsName;
        this.docsLocation = docsLocation;
        this.docsContent = docsContent;
        this.createdBy = createdBy;
        this.docsCategory = docsCategory;
    }


    public Docs getDocs() {
        return new Docs(docsName, docsLocation, createdBy, docsCategory);
    }
}
