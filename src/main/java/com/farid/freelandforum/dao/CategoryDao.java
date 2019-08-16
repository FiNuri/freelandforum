package com.farid.freelandforum.dao;

import com.farid.freelandforum.model.FСategory;

import java.util.List;

public interface CategoryDao {

    String createCategory(FСategory category) throws DaoExeption;

    FСategory getCategoryById(int id) throws DaoExeption;

    List<FСategory> getAllCategorys() throws DaoExeption;

    String updateCategoryById(int id) throws DaoExeption;

    String dropCategoryById(int id) throws DaoExeption;
}
