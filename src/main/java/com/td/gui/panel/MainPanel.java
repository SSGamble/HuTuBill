package com.td.gui.panel;

import com.td.gui.listener.ToolBarListener;
import com.td.util.CenterPanel;
import com.td.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    static {
        GUIUtil.useLNF();
    }

    // 采用单例模式，为的是后续的监听器访问这个容器里的组件的便利性
    public static MainPanel instance = new MainPanel();
    // 把各种按钮声明为 public 的属性，同样也是为了后续的监听器访问这个容器里的组件的便利性
    public JToolBar tb = new JToolBar();
    public JButton bSpend = new JButton();
    public JButton bRecord = new JButton();
    public JButton bCategory = new JButton();
    public JButton bReport = new JButton();
    public JButton bConfig = new JButton();
    public JButton bBackup = new JButton();
    public JButton bRecover = new JButton();
    // 工作面板，用于将来显示不同的功能面板
    public CenterPanel workingPanel;

    public static void main(String[] args) {
        // 显示这个面板实例
        GUIUtil.showPanel(MainPanel.instance, 1);
    }

    private MainPanel() {
        // 设置这些按钮的图标、文字和提示
        GUIUtil.setImageIcon(bSpend, "home.png", "消费一览");
        GUIUtil.setImageIcon(bRecord, "record.png", "记一笔");
        GUIUtil.setImageIcon(bCategory, "category2.png", "消费分类");
        GUIUtil.setImageIcon(bReport, "report.png", "月消费报表");
        GUIUtil.setImageIcon(bConfig, "config.png", "设置");
        GUIUtil.setImageIcon(bBackup, "backup.png", "备份");
        GUIUtil.setImageIcon(bRecover, "restore.png", "恢复");
        tb.add(bSpend);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);
        tb.setFloatable(false);
        workingPanel = new CenterPanel(0.8);
        setLayout(new BorderLayout());
        add(tb, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);
        addListener(); // ToolBarListener 监听器
    }

    /**
     * 在主面板中增加监听器
     */
    private void addListener() {
        ToolBarListener listener = new ToolBarListener();
        bSpend.addActionListener(listener);
        bRecord.addActionListener(listener);
        bCategory.addActionListener(listener);
        bReport.addActionListener(listener);
        bConfig.addActionListener(listener);
        bBackup.addActionListener(listener);
        bRecover.addActionListener(listener);
    }

}
