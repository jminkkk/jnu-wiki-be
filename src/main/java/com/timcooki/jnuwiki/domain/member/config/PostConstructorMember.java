package com.timcooki.jnuwiki.domain.member.config;

import com.timcooki.jnuwiki.domain.docs.entity.Docs;
import com.timcooki.jnuwiki.domain.docs.entity.DocsLocation;
import com.timcooki.jnuwiki.domain.docs.repository.DocsRepository;
import com.timcooki.jnuwiki.domain.docsRequest.entity.DocsCategory;
import com.timcooki.jnuwiki.domain.docsRequest.entity.DocsRequest;
import com.timcooki.jnuwiki.domain.docsRequest.entity.DocsRequestType;
import com.timcooki.jnuwiki.domain.docsRequest.repository.DocsRequestRepository;
import com.timcooki.jnuwiki.domain.member.entity.Member;
import com.timcooki.jnuwiki.domain.member.entity.MemberRole;
import com.timcooki.jnuwiki.domain.member.repository.MemberRepository;
import com.timcooki.jnuwiki.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class PostConstructorMember {

    private final MemberRepository memberRepository;
    private final DocsRepository docsRepository;
    private final PasswordEncoder passwordEncoder;
    private final DocsRequestRepository docsRequestRepository;

    @PostConstruct // 안의 데이터 변경 시 어노테이션 제거 후에 실행하고 다시 어노테이션 붙여서 실행해야함
    public void init(){

        Member admin = Member.builder()
                .email("admin@naver.com")
                .password(passwordEncoder.encode("adminA1234!@"))
                .role(MemberRole.ADMIN)
                .nickName("admin")
                .build();
        memberRepository.save(admin);
        Member user = Member.builder()
                .email("test@test.com")
                .password(passwordEncoder.encode("testT1234!@"))
                .role(MemberRole.USER)
                .nickName("test")
                .build();
        memberRepository.save(user);

        Docs docs1 = Docs.builder()
                .docsName("문서테스트")
                .docsCategory(DocsCategory.CAFE)
                .docsLocation(DocsLocation.builder()
                        .lng(35.17641341218037)
                        .lat(126.91349388159176)
                        .build())
                .createdBy(user)
                .build();
        docs1.updateContent("문서 컨텐츠");
        docsRepository.save(docs1);

        Docs docs2 = Docs.builder()
                .docsName("문서테스트22")
                .docsCategory(DocsCategory.CAFE)
                .docsLocation(DocsLocation.builder()
                        .lng(35.17641341218037)
                        .lat(126.91349388159176)
                        .build())
                .createdBy(user)
                .build();
        docs2.updateContent("문서 컨텐츠22");
        docsRepository.save(docs2);

        Docs docs3 = Docs.builder()
                .docsName("문서테스트33")
                .docsCategory(DocsCategory.CAFE)
                .docsLocation(DocsLocation.builder()
                        .lng(35.17641341218037)
                        .lat(126.91349388159176)
                        .build())
                .createdBy(user)
                .build();
        docs3.updateContent("문서 컨텐츠33");
        docsRepository.save(docs3);

        DocsRequest docsRequest1 = DocsRequest.builder()
                .docsRequestName("요청문서11")
                .docsRequestType(DocsRequestType.CREATED)
                .docsRequestLocation(DocsLocation.builder()
                        .lat(35.17641341218037)
                        .lng(126.91349388159176)
                        .build())
                .docsRequestedBy(user)
                .docsRequestCategory(DocsCategory.CAFE)
                .build();
        docsRequestRepository.save(docsRequest1);

        DocsRequest docsRequest2 = DocsRequest.builder()
                .docsRequestName("요청문서22")
                .docsRequestType(DocsRequestType.CREATED)
                .docsRequestLocation(DocsLocation.builder()
                        .lat(35.17641341218037)
                        .lng(126.91349388159176)
                        .build())
                .docsRequestedBy(user)
                .docsRequestCategory(DocsCategory.CAFE)
                .build();
        docsRequestRepository.save(docsRequest2);

        DocsRequest docsRequest3 = DocsRequest.builder()
                .docsRequestName("요청문서33")
                .docsRequestType(DocsRequestType.CREATED)
                .docsRequestLocation(DocsLocation.builder()
                        .lat(35.17641341218037)
                        .lng(126.91349388159176)
                        .build())
                .docsRequestedBy(user)
                .docsRequestCategory(DocsCategory.CAFE)
                .build();
        docsRequestRepository.save(docsRequest3);

        DocsRequest docsRequest4 = DocsRequest.builder()
                .docsRequestName("요청문서44444")
                .docsRequestType(DocsRequestType.MODIFIED)
                .docsRequestLocation(DocsLocation.builder()
                        .lat(35.17641341218037)
                        .lng(126.91349388159176)
                        .build())
                .docsRequestedBy(user)
                .docsRequestCategory(DocsCategory.CAFE)
                .docs(docs3)
                .build();
        docsRequestRepository.save(docsRequest4);

        DocsRequest docsRequest5 = DocsRequest.builder()
                .docsRequestName("요청문서5555")
                .docsRequestType(DocsRequestType.MODIFIED)
                .docsRequestLocation(DocsLocation.builder()
                        .lat(35.17641341218037)
                        .lng(126.91349388159176)
                        .build())
                .docsRequestedBy(user)
                .docsRequestCategory(DocsCategory.CAFE)
                .docs(docs3)
                .build();
        docsRequestRepository.save(docsRequest5);

        DocsRequest docsRequest6 = DocsRequest.builder()
                .docsRequestName("요청문666")
                .docsRequestType(DocsRequestType.MODIFIED)
                .docsRequestLocation(DocsLocation.builder()
                        .lat(35.17641341218037)
                        .lng(126.91349388159176)
                        .build())
                .docsRequestedBy(user)
                .docsRequestCategory(DocsCategory.CAFE)
                .docs(docs1)
                .build();
        docsRequestRepository.save(docsRequest6);

        //UPDATE MEMBER SET CREATED_AT = '2023-06-27 06:23:13.271379' WHERE MEMBER_ID=2
    }

}
