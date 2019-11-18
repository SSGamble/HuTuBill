package com.td.gui.frame;

import com.td.gui.panel.MainPanel;
import javax.swing.*;

/**
 * 整个程序只有这一个主 Frame
 */
public class MainFrame extends JFrame {
    public static MainFrame instance = new MainFrame();

    private MainFrame() {
        this.setSize(500, 450);
        this.setTitle("一本糊涂账");
        this.setContentPane(MainPanel.instance); // 在主窗体中通过 setContentPane 把 MainPanel 设置为内容面板
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        instance.setVisible(true);
    }

}