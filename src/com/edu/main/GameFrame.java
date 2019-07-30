package com.edu.main;

import com.edu.constant.FrameConstant;
import com.edu.runtime.Background;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class GameFrame extends Frame {

    private Background background =new Background();


    @Override
    public void paint(Graphics g) {
        background.draw(g);
    }

    /**
     * 初始化窗口
     */
    public void init(){
        //设置窗口大小
        setSize(FrameConstant.FRAME_WIDTH,FrameConstant.FRAME_HEIGHT);
        //设置居中
        setLocationRelativeTo(null);
        //禁止启动窗口时有图片
        enableInputMethods(false);
        //关闭窗口
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        new Thread(){
            @Override
            public void run() {
                //睡眠
                while (true) {
                    repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        setVisible(true);

    }


    private Image offScreenImage = null;  //创建缓冲区
    @Override
    public void update(Graphics g) {
        if(offScreenImage == null){
            offScreenImage = this.createImage(FrameConstant.FRAME_WIDTH,FrameConstant.FRAME_HEIGHT);
        }
        Graphics gOff = offScreenImage.getGraphics();//创建离线图片实例，在图片缓冲区绘图

        paint(gOff);
        g.drawImage(offScreenImage,0,0,null); //将缓冲区图片绘制到窗口目标
    }
}
