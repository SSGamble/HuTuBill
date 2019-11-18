package com.td.gui.model;

import com.td.entity.Category;
import com.td.service.CategoryService;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.List;

public class CategoryComboBoxModel implements ComboBoxModel<Category> {

    public List<Category> cs = new CategoryService().list(); // 分类信息
    public Category c; // 表示被选中的字符串

    /**
     * 初始化数据
     */
    public CategoryComboBoxModel() {
        if (!cs.isEmpty()) {
            c = cs.get(0);
        }
    }

    /**
     * 获取这个下拉框的大小，就是前面定义的字符串集合的大小
     */
    @Override
    public int getSize() {
        return cs.size();
    }

    /**
     * 获取指定位置的数据
     */
    @Override
    public Category getElementAt(int index) {
        return cs.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }

    /**
     * 当界面上选中了某一个下拉框项，就会调用这个方法
     */
    @Override
    public void setSelectedItem(Object anItem) {
        c = (Category) anItem;
    }

    /**
     * 获取被选中的数据
     */
    @Override
    public Object getSelectedItem() {
        if (!cs.isEmpty()) {
            return c;
        } else {
            return null;
        }
    }
}