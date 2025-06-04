package com.vybz.admin_service.category.application;

import com.vybz.admin_service.category.dto.request.RequestAddCategoryDto;
import com.vybz.admin_service.category.dto.request.RequestDeleteCategoryDto;
import com.vybz.admin_service.category.dto.request.RequestUpdateCategoryDto;
import com.vybz.admin_service.category.dto.response.ResponseCategoryDto;

import java.util.List;

public interface CategoryService {

    /**
     * 카테고리 추가
     * @param requestAddCategoryDto
     */
    void createCategory(RequestAddCategoryDto requestAddCategoryDto);

    /**
     * 카테고리 id로 카테고리 조회
     * @param id
     */
    ResponseCategoryDto getCategoryById(Long id);

    /**
     * 카테고리 이름으로 카테고리 조회
     * @param name
     */
    ResponseCategoryDto getCategoryByName(String name);

    /**
     * 카테고리 전체 조회
     */
    List<ResponseCategoryDto> getAllCategories();

    /**
     * 카테고리 수정
     * @param requestUpdateCategoryDto
     */
    void updateCategory(RequestUpdateCategoryDto requestUpdateCategoryDto);

    /**
     * 카테고리 삭제
     * @param requestDeleteCategoryDto
     */
    void deleteCategory(RequestDeleteCategoryDto requestDeleteCategoryDto);

}
