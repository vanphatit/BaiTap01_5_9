package me.phatlee.demotuan3.dao.impl;

import me.phatlee.demotuan3.configs.DBconnectMySQL;
import me.phatlee.demotuan3.dao.iCategoryDAO;
import me.phatlee.demotuan3.models.CategoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOimpl implements iCategoryDAO {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public List<CategoryModel> findAll() {
        String sql = "SELECT * FROM categories";
        List<CategoryModel> categories = new ArrayList<>();
        try {
            conn = DBconnectMySQL.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setCategoryID(rs.getInt("categoryID"));
                category.setCategoryName(rs.getString("categoryName"));
                category.setImages(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
                categories.add(category);
            }
            conn.close();
            ps.close();
            rs.close();
            return categories;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CategoryModel findById(int id) {
        String sql = "SELECT * FROM categories WHERE categoryID = ?";
        CategoryModel category = new CategoryModel();
        try {
            conn = DBconnectMySQL.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                category.setCategoryID(rs.getInt("categoryID"));
                category.setCategoryName(rs.getString("categoryName"));
                category.setImages(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
            }
            conn.close();
            ps.close();
            rs.close();
            return category;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(CategoryModel category) {
        String sql = "INSERT INTO categories(categoryName, images, status) VALUES(?, ?, ?)";
        try {
            conn = DBconnectMySQL.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getCategoryName());
            ps.setString(2, category.getImages());
            ps.setInt(3, category.getStatus());
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(CategoryModel category) {
        String sql = "UPDATE categories SET categoryName = ?, images = ?, status = ? WHERE categoryID = ?";
        try {
            conn = DBconnectMySQL.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getCategoryName());
            ps.setString(2, category.getImages());
            ps.setInt(3, category.getStatus());
            ps.setInt(4, category.getCategoryID());
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM categories WHERE categoryID = ?";
        try {
            conn = DBconnectMySQL.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CategoryModel> findName(String keyword) {
        String sql = "SELECT * FROM categories WHERE categoryName LIKE ?";
        List<CategoryModel> categories = new ArrayList<>();
        try {
            conn = DBconnectMySQL.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setCategoryID(rs.getInt("categoryID"));
                category.setCategoryName(rs.getString("categoryName"));
                category.setImages(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
                categories.add(category);
            }
            conn.close();
            ps.close();
            rs.close();
            return categories;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateStatus(int id, int status) { // 0: inactive, 1: active
        String sql = "UPDATE categories SET status = ? WHERE categoryID = ?";
        try {
            conn = DBconnectMySQL.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, status == 1 ? 0 : 1);
            ps.setInt(2, id);
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
