package com.vybz.admin_service.category.presentation;

import com.vybz.admin_service.category.application.CategoryService;
import com.vybz.admin_service.category.dto.request.RequestAddCategoryDto;
import com.vybz.admin_service.category.dto.request.RequestDeleteCategoryDto;
import com.vybz.admin_service.category.dto.request.RequestUpdateCategoryDto;
import com.vybz.admin_service.category.dto.response.ResponseCategoryDto;
import com.vybz.admin_service.category.vo.request.RequestAddCategoryVo;
import com.vybz.admin_service.category.vo.request.RequestDeleteCategoryVo;
import com.vybz.admin_service.category.vo.request.RequestUpdateCategoryVo;
import com.vybz.admin_service.category.vo.response.ResponseCategoryVo;
import com.vybz.admin_service.common.entity.BaseResponseEntity;
import com.vybz.admin_service.common.entity.BaseResponseStatus;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    /**
     * 카테고리 추가
     * @param requestAddCategoryVo
     */
    @Operation(summary = "카테고리 추가 API", description = "카테고리 추가 API 입니다.", tags = {"Category-Service"})
    @PostMapping
    public BaseResponseEntity<Void> createCategory(@RequestBody RequestAddCategoryVo requestAddCategoryVo) {
        categoryService.createCategory(RequestAddCategoryDto.from(requestAddCategoryVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    /**
     * 카테고리 id로 카테고리 조회
     * @param id
     */
    @Operation(summary = "카테고리 id로 카테고리 조회 API", description = "카테고리 id로 카테고리 조회 API 입니다.", tags = {"Category-Service"})
    @GetMapping("/{id}")
    public BaseResponseEntity<ResponseCategoryVo> getCategoryById(@PathVariable("id") Long id) {
        ResponseCategoryDto responseCategoryDto = categoryService.getCategoryById(id);
        return new BaseResponseEntity<>(responseCategoryDto.toVo());
    }

    /**
     * 카테고리 이름으로 카테고리 조회
     * @param name
     */
    @Operation(summary = "카테고리 이름으로 카테고리 조회 API", description = "카테고리 이름으로 카테고리 조회 API 입니다.", tags = {"Category-Service"})
    @GetMapping("/search")
    public BaseResponseEntity<ResponseCategoryVo> getCategoryByName(@RequestParam("name") String name) {
        ResponseCategoryDto responseCategoryDto = categoryService.getCategoryByName(name);
        return new BaseResponseEntity<>(responseCategoryDto.toVo());
    }

    /**
     * 카테고리 전체 조회
     */
    @Operation(summary = "카테고리 전체 조회 API", description = "카테고리 전체 조회 API 입니다.", tags = {"Category-Service"})
    @GetMapping("/list")
    public BaseResponseEntity<List<ResponseCategoryVo>> getAllCategories() {
       List<ResponseCategoryVo> responseCategoryVo = categoryService.getAllCategories()
                .stream()
                .map(ResponseCategoryDto::toVo)
                .toList();
        return new BaseResponseEntity<>(responseCategoryVo);
    }

    /**
     * 카테고리 수정
     * @param requestUpdateCategoryVo
     */
    @Operation(summary = "카테고리 수정 API", description = "카테고리 수정 API 입니다.", tags = {"Category-Service"})
    @PutMapping
    public BaseResponseEntity<Void> updateCategory(@RequestBody RequestUpdateCategoryVo requestUpdateCategoryVo) {
        categoryService.updateCategory(RequestUpdateCategoryDto.from(requestUpdateCategoryVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    /**
     * 카테고리 삭제
     * @param requestDeleteCategoryVo
     */
    @Operation(summary = "카테고리 삭제 API", description = "카테고리 삭제 API 입니다.", tags = {"Category-Service"})
    @DeleteMapping
    public BaseResponseEntity<Void> deleteCategory(@RequestBody RequestDeleteCategoryVo requestDeleteCategoryVo) {
        categoryService.deleteCategory(RequestDeleteCategoryDto.from(requestDeleteCategoryVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

}
