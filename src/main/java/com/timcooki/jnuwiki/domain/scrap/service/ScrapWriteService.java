package com.timcooki.jnuwiki.domain.scrap.service;

import com.timcooki.jnuwiki.domain.docs.entity.Docs;
import com.timcooki.jnuwiki.domain.docs.exception.DocsNotFoundException;
import com.timcooki.jnuwiki.domain.docs.repository.DocsRepository;
import com.timcooki.jnuwiki.domain.member.entity.Member;
import com.timcooki.jnuwiki.domain.member.exception.MemberNotFoundException;
import com.timcooki.jnuwiki.domain.member.repository.MemberRepository;
import com.timcooki.jnuwiki.domain.scrap.DTO.request.DeleteScrapReqDTO;
import com.timcooki.jnuwiki.domain.scrap.DTO.request.NewScrapReqDTO;
import com.timcooki.jnuwiki.domain.scrap.entity.Scrap;
import com.timcooki.jnuwiki.domain.scrap.repository.ScrapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScrapWriteService {

    private final ScrapRepository scrapRepository;
    private final MemberRepository memberRepository;
    private final DocsRepository docsRepository;

    @Transactional
    public void create(NewScrapReqDTO newScrapReqDTO) {
        Member member = memberRepository.findByMemberId(newScrapReqDTO.memberId())
                .orElseThrow(MemberNotFoundException::new);

        Docs docs = docsRepository.findById(newScrapReqDTO.docsId())
                .orElseThrow(DocsNotFoundException::new);

        scrapRepository.save(Scrap.of(member, docs));
    }

    @Transactional
    public void delete(DeleteScrapReqDTO deleteScrapReqDTO) {
        Member member = memberRepository.findByMemberId(deleteScrapReqDTO.memberId())
                .orElseThrow(MemberNotFoundException::new);

        Docs docs = docsRepository.findById(deleteScrapReqDTO.docsId())
                .orElseThrow(DocsNotFoundException::new);

        scrapRepository.delete(Scrap.of(member, docs));
    }
}
