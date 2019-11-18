package com.td.gui.panel;

import com.td.gui.listener.RecoverListener;
import com.td.util.ColorUtil;
import com.td.util.GUIUtil;

import javax.swing.*;

public class RecoverPanel extends WorkingPanel {
    static{
        GUIUtil.useLNF();
    }

    public static RecoverPanel instance = new RecoverPanel();
    JButton bRecover =new JButton("恢复");

    public RecoverPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bRecover);
        this.add(bRecover);
        addListener();
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(RecoverPanel.instance);
    }

    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {
        RecoverListener listener = new RecoverListener();
        bRecover.addActionListener(listener);
    }

}