package com.timcooki.jnuwiki.domain.scrap.DTO.request;

import com.timcooki.jnuwiki.domain.scrap.entity.Scrap;
import lombok.Builder;

@Builder
public record DeleteScrapReqDTO(
        Long memberId,
        Long docsId
) {
}
