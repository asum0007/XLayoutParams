package com.asum.xlayoutparams.utils;

import com.asum.xlayoutparams.utils.hiden.XBaseArea;

import android.content.Context;
import android.view.View;

public class XPxArea extends XBaseArea {
	public XPxArea(Context context, View view) {
		super(context, view);
	}

	public XPxArea(View view) {
		super(view);
	}

	/**
	 * 基于PX进行位置设置，大小不变
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public XBaseArea setPos(double x, double y) {
		layoutParams.setPx((int) x, (int) y, INVARIANT, INVARIANT);
		return this;
	}

	/**
	 * 基于PX进行大小设置，位置不变
	 * 
	 * @param w
	 * @param h
	 * 
	 * @return XArea 当前对象
	 */
	public XBaseArea setSize(double w, double h) {
		layoutParams.setPx(INVARIANT, INVARIANT, (int) w, (int) h);
		return this;
	}

	/**
	 * 基于PX进行位置大小设置，大小为等长等宽
	 * 
	 * @param x
	 * @param y
	 * @param size
	 * @return
	 */
	public XBaseArea set(double x, double y, double size) {
		layoutParams.setPx((int) x, (int) y, (int) size, (int) size);
		return this;
	}

	/**
	 * 基于PX进行位置大小设置
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * 
	 * @return XArea 当前对象
	 */
	public XBaseArea set(double x, double y, double w, double h) {
		layoutParams.setPx((int) x, (int) y, (int) w, (int) h);
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
