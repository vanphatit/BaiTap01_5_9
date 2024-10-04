package me.phatlee.demotuan3.services;

import me.phatlee.demotuan3.models.CategoryModel;

import java.util.List;

public interface iCategoryService {
    List<CategoryModel> findAll();
    CategoryModel findById(int id);
    void insert(CategoryModel category);
    void update(CategoryModel category);
    void delete(int id);
    List<CategoryModel> findName(String keyword);
    void updateStatus(int id, int status);
}
