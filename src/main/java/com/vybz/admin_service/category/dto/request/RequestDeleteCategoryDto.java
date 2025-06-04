package com.vybz.admin_service.category.dto.request;

import com.vybz.admin_service.category.vo.request.RequestDeleteCategoryVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteCategoryDto {

    private Long id;

    @Builder
    public RequestDeleteCategoryDto(Long id) {
        this.id = id;
    }

    public static RequestDeleteCategoryDto from(RequestDeleteCategoryVo requestDeleteCategoryVo) {
        return RequestDeleteCategoryDto.builder()
                .id(requestDeleteCategoryVo.getId())
                .build();
    }

}
