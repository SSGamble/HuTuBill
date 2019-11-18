package com.td.startup;

import com.td.gui.frame.MainFrame;
import com.td.gui.panel.MainPanel;
import com.td.gui.panel.SpendPanel;
import com.td.util.GUIUtil;
import javax.swing.*;

/**
 * 启动入口，
 */
public class Bootstrap {
    public static void main(String[] args) throws Exception{
        GUIUtil.useLNF();

        // 启动图形界面
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                MainFrame.instance.setVisible(true); // 显示主窗体
                MainPanel.instance.workingPanel.show(SpendPanel.instance); // 让主面板下方的 workingPanel 显示消费一览 Panel
            }
        });
    }
}
