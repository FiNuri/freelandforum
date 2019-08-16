package com.farid.freelandforum.dao;

import com.farid.freelandforum.model.Сategory;

import java.util.List;

public interface CategoryDao {

    String createCategory(Сategory category) throws DaoExeption;

    Сategory getCategoryById(int id) throws DaoExeption;

    List<Сategory> getAllCategorys() throws DaoExeption;

    String updateCategoryById(int id) throws DaoExeption;

    String dropCategoryById(int id) throws DaoExeption;
}
