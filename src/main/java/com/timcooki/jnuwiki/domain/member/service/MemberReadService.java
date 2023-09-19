package com.timcooki.jnuwiki.domain.member.service;

import com.timcooki.jnuwiki.domain.docs.entity.Docs;
import com.timcooki.jnuwiki.domain.docs.repository.DocsRepository;
import com.timcooki.jnuwiki.domain.member.DTO.response.ReadResDTO;
import com.timcooki.jnuwiki.domain.member.DTO.response.ScrapListResDTO;
import com.timcooki.jnuwiki.domain.member.DTO.response.ScrapResDTO;
import com.timcooki.jnuwiki.domain.member.entity.Member;
import com.timcooki.jnuwiki.domain.member.repository.MemberRepository;
import com.timcooki.jnuwiki.util.errors.exception.Exception404;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberReadService {
    private final MemberRepository memberRepository;
    private final DocsRepository docsRepository;
    public ReadResDTO getInfo(UserDetails userDetails) {
        Member memberOptional = memberRepository.findByEmail(userDetails.getUsername()).orElseThrow(
                () -> new Exception404("존재하지 않는 회원입니다.")
        );
        // TODO - mapStruct 사용
        ReadResDTO resDTO = ReadResDTO.builder()
                .id(memberOptional.getMemberId())
                .nickName(memberOptional.getNickName())
                .password(memberOptional.getPassword())
                .build();
        return resDTO;
    }

    public ScrapListResDTO getScrappedDocs(UserDetails userDetails, Pageable pageable) {
        Member member = memberRepository.findByEmail(userDetails.getUsername()).orElseThrow(
                () -> new Exception404("존재하지 않는 회원입니다.")
        );

        Page<Docs> docsList = docsRepository.mFindScrappedDocsByMemberId(member.getMemberId(), pageable);

        ScrapListResDTO list = ScrapListResDTO.builder()
                .scrapList(docsList.stream()
                        .map(d -> new ScrapResDTO(d.getDocsId(), d.getDocsName(), d.getDocsName(), d.getDocsLocation(), member.getNickName()))
                        .toList())
                .totalPages(docsList.getTotalPages())
                .build();
        return list;
    }

}
