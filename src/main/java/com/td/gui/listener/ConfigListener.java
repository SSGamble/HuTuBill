package com.td.gui.listener;

import com.td.gui.panel.ConfigPanel;
import com.td.service.ConfigService;
import com.td.util.GUIUtil;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * 监听器 ConfigListener，这个监听器是用在更新按钮上的
 */
public class ConfigListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ConfigPanel p = ConfigPanel.instance;
        if (!GUIUtil.checkNumber(p.tfBudget, "本月预算")) // 首先判断输入的预算值是否是整数
            return;
        String mysqlPath = p.tfMysqlPath.getText();
        if (0 != mysqlPath.length()) {
            File commandFile = new File(mysqlPath, "bin/mysql.exe");
            if (!commandFile.exists()) {
                JOptionPane.showMessageDialog(p, "Mysql路径不正确");
                p.tfMysqlPath.grabFocus();
                return;
            }
        }
        ConfigService cs = new ConfigService();
        // 进行数据更新
        cs.update(ConfigService.budget, p.tfBudget.getText());
        cs.update(ConfigService.mysqlPath, mysqlPath);
        JOptionPane.showMessageDialog(p, "设置修改成功");
    }

}
