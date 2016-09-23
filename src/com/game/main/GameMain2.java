package com.game.main;

import com.game.view.Window2;

import javax.swing.*;
import java.awt.*;

/**
 * 这个版本加入了音效、移动特效、合并特效
 *
 * @author 锋宇
 * @contact QQ群399643539
 * @website http://www.wolfbe.com
 * @copyright 版权归朗度云所有
 */
public class GameMain2 {
    public static void main(String[] args) {
        Window2 win = new Window2();
        win.initView();
        win.setTitle("2048[©版权朗度云所有]");
        win.getContentPane().setPreferredSize(new Dimension(400, 500));
        //JFrame直接调用setBackground设置背景色不生效
        win.getContentPane().setBackground(new Color(0xfaf8ef));
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setResizable(false); //去掉最大化按钮
        win.pack();    //获得最佳大小
        win.setVisible(true);
    }
}
