package com.td.gui.model;

import com.td.entity.Category;
import com.td.service.CategoryService;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CategoryTableModel extends AbstractTableModel {
    String[] columnNames = new String[]{"分类名称", "消费次数"};
    // 使用从 Service 返回的 List 作为 TableModel 的数据
    public List<Category> cs = new CategoryService().list();

    public int getRowCount() {
        return cs.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    // 先通过 cs.get(rowIndex) 获取行对应的 Category 对象
    // 然后根据 columnIndex 返回对应的属性
    public Object getValueAt(int rowIndex, int columnIndex) {
        Category h = cs.get(rowIndex);
        if (0 == columnIndex) {
            return h.name;
        }
        if (1 == columnIndex) {
            return h.recordNumber;
        }
        return null;
    }

}