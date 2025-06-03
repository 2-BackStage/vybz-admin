package com.vybz.admin_service.category.dto.request;

import com.vybz.admin_service.category.domain.Category;
import com.vybz.admin_service.category.vo.request.RequestUpdateCategoryVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUpdateCategoryDto {

    private Long id;
    private String name;

    @Builder
    public RequestUpdateCategoryDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category updateEntity(Category category) {
        return Category.builder()
                .id(category.getId())
                .name(name)
                .build();
    }

    public static RequestUpdateCategoryDto from(RequestUpdateCategoryVo requestUpdateCategoryVo) {
        return RequestUpdateCategoryDto.builder()
                .id(requestUpdateCategoryVo.getId())
                .name(requestUpdateCategoryVo.getName())
                .build();
    }

}
