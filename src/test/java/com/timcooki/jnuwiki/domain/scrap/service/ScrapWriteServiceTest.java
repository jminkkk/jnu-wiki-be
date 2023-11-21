package com.timcooki.jnuwiki.domain.scrap.service;

import com.timcooki.jnuwiki.domain.docs.repository.DocsRepository;
import com.timcooki.jnuwiki.domain.member.repository.MemberRepository;
import com.timcooki.jnuwiki.domain.scrap.DTO.request.DeleteScrapReqDTO;
import com.timcooki.jnuwiki.domain.scrap.DTO.request.NewScrapReqDTO;
import com.timcooki.jnuwiki.domain.scrap.entity.Scrap;
import com.timcooki.jnuwiki.domain.scrap.repository.ScrapRepository;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.timcooki.jnuwiki.util.DocsFixture.DOCS1;
import static com.timcooki.jnuwiki.util.MemberFixture.MEMBER1;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ScrapWriteServiceTest {
    @InjectMocks private ScrapWriteService scrapWriteService;
    @Mock private ScrapRepository scrapRepository;
    @Mock private MemberRepository memberRepository;
    @Mock private DocsRepository docsRepository;

    @Test
    @DisplayName("스크랩 생성")
     void delete_scrap_test() {
        // given
        NewScrapReqDTO newScrapReqDTO = NewScrapReqDTO.builder()
                .memberId(1L)
                .docsId(1L)
                .build();

        // when
        Mockito.when(memberRepository.findByMemberId(any())).thenReturn(Optional.of(MEMBER1.getMember()));
        Mockito.when(docsRepository.findById(any())).thenReturn(Optional.of(DOCS1.getDocs()));
        scrapWriteService.create(newScrapReqDTO);

        // then
        verify(scrapRepository, times(1)).save(any(Scrap.class));
    }

    @Test
    @DisplayName("스크랩 삭제")
     void create_scrap_test() {
        // given
        DeleteScrapReqDTO deleteScrapReqDTO = DeleteScrapReqDTO.builder()
                .memberId(1L)
                .docsId(1L)
                .build();

        // when
        Mockito.when(memberRepository.findByMemberId(any())).thenReturn(Optional.of(MEMBER1.getMember()));
        Mockito.when(docsRepository.findById(any())).thenReturn(Optional.of(DOCS1.getDocs()));
        scrapWriteService.delete(deleteScrapReqDTO);

        // then
        verify(scrapRepository, times(1)).delete(any(Scrap.class));
    }
}
