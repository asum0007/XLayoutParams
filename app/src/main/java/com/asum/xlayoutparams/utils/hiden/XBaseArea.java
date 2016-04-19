package com.asum.xlayoutparams.utils.hiden;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;

/**
 * 位置大小设置类
 * 
 * @author Asum
 * 
 */
@SuppressLint("RtlHardcoded")
public class XBaseArea {
	protected static boolean IS_PRINT = false;
	protected Context context;
	protected View view;
	protected XBaseLayoutParams layoutParams;

	public XBaseArea(Context context, View view) {
		this.context = context;
		this.view = view;
		initializeSomeData();
	}

	public XBaseArea(View view) {
		this.context = view.getContext();
		this.view = view;
		initializeSomeData();
	}

	private void initializeSomeData() {
		String className = view.getLayoutParams().getClass().getName();
		if (className.contains("android.widget.RelativeLayout")) {
			layoutParams = new XRelLayoutParams(context, view);
		} else if (className.contains("android.widget.LinearLayout")) {
			layoutParams = new XLinLayoutParams(context, view);
		} else if (className.contains("android.widget.FrameLayout")) {
			layoutParams = new XFraLayoutParams(context, view);
		} else {
			Log.i("XJW", "位置大小设置出错：控件的父类不在支持范围内");
			return;
		}
	}

	/**
	 * 控件的左边对齐指定控件的左边
	 * 
	 * @param assignView
	 *            指定的控件
	 * @return XArea 当前对象
	 */
	public XBaseArea leftAlignLeft(View assignView) {
		((XRelLayoutParams) layoutParams).leftAlignLeft(assignView);
		return this;
	}

	/**
	 * 控件的右边对齐指定控件的右边
	 * 
	 * @param assignView
	 *            指定的控件
	 * @return XArea 当前对象
	 */
	public XBaseArea rightAlignRight(View assignView) {
		((XRelLayoutParams) layoutParams).rightAlignRight(assignView);
		return this;
	}

	/**
	 * 控件的上边对齐指定控件的上边
	 * 
	 * @param assignView
	 *            指定的控件
	 * @return XArea 当前对象
	 */
	public XBaseArea topAlignTop(View assignView) {
		((XRelLayoutParams) layoutParams).topAlignTop(assignView);
		return this;
	}

	/**
	 * 控件的底边对齐指定控件的底边
	 * 
	 * @param assignView
	 *            指定的控件
	 * @return XArea 当前对象
	 */
	public XBaseArea bottomAlignBottom(View assignView) {
		((XRelLayoutParams) layoutParams).bottomAlignBottom(assignView);
		return this;
	}

	/**
	 * 控件的左边连接指定控件的右边
	 * 
	 * @param assignView
	 * @return
	 */
	public XBaseArea leftConnectRight(View assignView) {
		((XRelLayoutParams) layoutParams).leftConnectRight(assignView);
		return this;
	}

	/**
	 * 控件的右边连接指定控件的左边
	 * 
	 * @param assignView
	 * @return
	 */
	public XBaseArea rightConnectLeft(View assignView) {
		((XRelLayoutParams) layoutParams).rightConnectLeft(assignView);
		return this;
	}

	/**
	 * 控件的上边连接指定控件的下边
	 * 
	 * @param assignView
	 * @return
	 */
	public XBaseArea topConnectBottom(View assignView) {
		((XRelLayoutParams) layoutParams).topConnectBottom(assignView);
		return this;
	}

	/**
	 * 控件的下边连接指定控件的上边
	 * 
	 * @param assignView
	 * @return
	 */
	public XBaseArea bottomConnectTop(View assignView) {
		((XRelLayoutParams) layoutParams).bottomConnectTop(assignView);
		return this;
	}

	public XBaseArea setPos(double x, double y) {
		return this;
	}

	public XBaseArea setSize(double w, double h) {
		return this;
	}

	public XBaseArea set(double x, double y, double size) {
		return this;
	}

	public XBaseArea set(double x, double y, double w, double h) {
		return this;
	}

	public static final int MATCH = Integer.MAX_VALUE;

	public static final int WRAP = Integer.MAX_VALUE - 1;

	public static final int INVARIANT = Integer.MAX_VALUE - 2;

	public static final int CENTER = Integer.MAX_VALUE - 3;

	public static final int LEFT = Integer.MAX_VALUE - 4;

	public static final int TOP = Integer.MAX_VALUE - 5;

	public static final int RIGHT = Integer.MAX_VALUE - 6;

	public static final int BOTTOM = Integer.MAX_VALUE - 7;
}
