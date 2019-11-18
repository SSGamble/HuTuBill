package com.td.gui.panel;

import javax.swing.JPanel;

/**
 * WorkingPanel 是一个抽象类，其中声明了方法 addListener()和 updateData().
 * 不同的面板类，都应该继承这个抽象类，进而必须提供 addListener 和 updateData 方法。
 */
public abstract class WorkingPanel  extends JPanel{
    public abstract void updateData();
    public abstract void addListener();
}
