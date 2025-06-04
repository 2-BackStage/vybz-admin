package com.vybz.admin_service.category.dto.response;

import com.vybz.admin_service.category.domain.Category;
import com.vybz.admin_service.category.vo.response.ResponseCategoryVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseCategoryDto {

    private Long id;
    private String name;

    @Builder
    public ResponseCategoryDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ResponseCategoryDto from(Category category) {
        return ResponseCategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public ResponseCategoryVo toVo() {
        return ResponseCategoryVo.builder()
                .id(id)
                .name(name)
                .build();
    }

}
