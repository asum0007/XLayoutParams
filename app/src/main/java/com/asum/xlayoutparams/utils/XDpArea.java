package com.asum.xlayoutparams.utils;

import com.asum.xlayoutparams.utils.hiden.XBaseArea;

import android.content.Context;
import android.view.View;

/**
 * 基于DIP思想设置大小位置
 * 
 * @author Asum
 * 
 */
public class XDpArea extends XBaseArea {
	public XDpArea(Context context, View view) {
		super(context, view);
	}

	/**
	 * 基于DIP进行位置设置，大小不变
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public XBaseArea setPos(int x, int y) {
		layoutParams.setDp(x, y, INVARIANT, INVARIANT);
		return this;
	}

	/**
	 * 基于DIP进行大小设置，位置不变
	 * 
	 * @param w
	 * @param h
	 * 
	 * @return XArea 当前对象
	 */
	public XBaseArea setSize(int w, int h) {
		layoutParams.setDp(INVARIANT, INVARIANT, w, h);
		return this;
	}

	/**
	 * 基于DIP进行位置大小设置，大小为等长等宽
	 * 
	 * @param x
	 * @param y
	 * @param size
	 * @return
	 */
	public XBaseArea set(int x, int y, int size) {
		layoutParams.setDp(x, y, size, size);
		return this;
	}

	/**
	 * 基于DIP进行位置大小设置
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * 
	 * @return XArea 当前对象
	 */
	public XBaseArea set(int x, int y, int w, int h) {
		layoutParams.setDp(x, y, w, h);
		return this;
	}

	/**
	 * 设置是否打印输出
	 * 
	 * @param canPrint
	 */
	public static void switchPrint(boolean canPrint) {
		IS_PRINT = canPrint;
	}
}
