package com.edu.runtime;

import com.edu.base.BaseSprite;
import com.edu.base.Drawable;
import com.edu.base.Moveable;
import com.edu.util.ImageMap;
import com.edu.util.ImageUtil;

import java.awt.Graphics;
import java.awt.Image;

public class Background extends BaseSprite implements Moveable, Drawable {

    private Image image;

    public Background() {
        this(0,9440, ImageMap.get("bg01"));
    }

    public Background(int x, int y, Image image) {
        super(x, y);
        this.image = image;
    }

    @Override
    public void move() {
        setY(getY()-1);

    }

    @Override
    public void draw(Graphics g) {
     g.drawImage(image,getX(),-getY(),image.getWidth(null),image.getHeight(null),null);
     move();
    }
}
