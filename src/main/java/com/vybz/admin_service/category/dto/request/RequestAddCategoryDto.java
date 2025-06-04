package com.vybz.admin_service.category.dto.request;

import com.vybz.admin_service.category.domain.Category;
import com.vybz.admin_service.category.vo.request.RequestAddCategoryVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAddCategoryDto {

    private String name;

    @Builder
    public RequestAddCategoryDto(String name) {
        this.name = name;
    }

    public Category toEntity() {
        return Category.builder()
                .name(name)
                .build();
    }

    public static RequestAddCategoryDto from(RequestAddCategoryVo requestAddCategoryVo) {
        return RequestAddCategoryDto.builder()
                .name(requestAddCategoryVo.getName())
                .build();
    }

}
