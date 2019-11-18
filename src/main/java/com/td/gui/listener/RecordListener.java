package com.td.gui.listener;

import com.td.entity.Category;
import com.td.gui.panel.CategoryPanel;
import com.td.gui.panel.MainPanel;
import com.td.gui.panel.RecordPanel;
import com.td.gui.panel.SpendPanel;
import com.td.service.RecordService;
import com.td.util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class RecordListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        RecordPanel p = RecordPanel.instance;
        if (0 == p.cbModel.cs.size()) {
            JOptionPane.showMessageDialog(p, "暂无消费分类，无法添加，请先增加消费分类");
            MainPanel.instance.workingPanel.show(CategoryPanel.instance);
            return;
        }
        if (!GUIUtil.checkZero(p.tfSpend, "花费金额")) {
            return;
        }
        int spend = Integer.parseInt(p.tfSpend.getText());
        Category c = p.getSelectedCategory();
        String comment = p.tfComment.getText();
        Date d = p.datepick.getDate();
        new RecordService().add(spend, c, comment, d);
        JOptionPane.showMessageDialog(p, "添加成功");
        MainPanel.instance.workingPanel.show(SpendPanel.instance);
    }
}