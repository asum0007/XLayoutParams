package com.asum.xlayoutparams.utils;

import android.content.Context;
import android.view.View;

import com.asum.xlayoutparams.utils.DensityUtils.Type;
import com.asum.xlayoutparams.utils.hiden.XBaseArea;

/**
 * 基于等分思想设置大小位置
 * 
 * @author Asum
 * 
 */
public class XDivArea extends XBaseArea {
	public XDivArea(Context context, View view) {
		super(context, view);
	}

	/**
	 * 基于等分进行设置位置大小，其中的等分全基于宽度
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @return
	 */
	public XDivArea setBaseOfW(double x, double y, double w, double h) {
		y = DensityUtils.div2px(context, y, Type.WIDTH);
		h = DensityUtils.px2div(context, h, Type.WIDTH);

		layoutParams.setDiv((int) x, (int) y, (int) w, (int) h);
		return this;
	}

	/**
	 * 基于等分进行设置位置大小，其中的等分全基于高度
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @return
	 */
	public XDivArea setBaseOfH(double x, double y, double w, double h) {
		x = DensityUtils.div2px(context, x, Type.HEIGHT);
		w = DensityUtils.px2div(context, w, Type.HEIGHT);

		layoutParams.setDiv((int) x, (int) y, (int) w, (int) h);
		return this;
	}

	/**
	 * 基于等分进行设置位置，其中的等分全基于宽度
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public XDivArea setPosBaseOfW(double x, double y) {
		y = DensityUtils.div2px(context, y, Type.WIDTH);

		layoutParams.setDiv((int) x, (int) y, INVARIANT, INVARIANT);
		return this;
	}

	/**
	 * 基于等分进行设置位置，其中的等分全基于高度
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public XDivArea setPosBaseOfH(double x, double y) {
		x = DensityUtils.div2px(context, x, Type.HEIGHT);

		layoutParams.setDiv((int) x, (int) y, INVARIANT, INVARIANT);
		return this;
	}

	/**
	 * 基于等分进行设置大小，其中的等分全基于宽度
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public XDivArea setSizeBaseOfW(double w, double h) {
		h = DensityUtils.div2px(context, h, Type.WIDTH);

		layoutParams.setDiv(INVARIANT, INVARIANT, (int) w, (int) h);
		return this;
	}

	/**
	 * 基于等分进行设置大小，其中的等分全基于高度
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public XDivArea setSizeBaseOfH(double w, double h) {
		w = DensityUtils.div2px(context, w, Type.HEIGHT);

		layoutParams.setDiv(INVARIANT, INVARIANT, (int) w, (int) h);
		return this;
	}

	/**
	 * 基于等分进行设置位置大小
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @return
	 */
	public XDivArea set(double x, double y, double w, double h) {
		layoutParams.setDiv((int) x, (int) y, (int) w, (int) h);
		return this;
	}

	/**
	 * 基于等分进行设置位置大小，等长等宽，其中的等分全基于宽度
	 * 
	 * @param x
	 * @param y
	 * @param size
	 * @return
	 */
	public XDivArea setBaseOfW(double x, double y, double size) {
		double h = DensityUtils.div2px(context, size, Type.WIDTH);
		layoutParams.setDiv((int) x, (int) y, (int) size, (int) h);
		return this;
	}

	/**
	 * 基于等分进行设置位置大小，等长等宽，其中的等分全基于高度
	 * 
	 * @param x
	 * @param y
	 * @param size
	 * @return
	 */
	public XDivArea setBaseOfH(double x, double y, double size) {
		double w = DensityUtils.div2px(context, size, Type.HEIGHT);
		layoutParams.setDiv((int) x, (int) y, (int) w, (int) size);
		return this;
	}

	/**
	 * 基于等分进行设置位置
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @return
	 */
	public XDivArea setPos(double x, double y) {
		layoutParams.setDiv((int) x, (int) y, INVARIANT, INVARIANT);
		return this;
	}

	/**
	 * 基于等分进行设置大小
	 * 
	 * @param w
	 * @param h
	 * @return
	 */
	public XDivArea setSize(double w, double h) {
		layoutParams.setDiv(INVARIANT, INVARIANT, (int) w, (int) h);
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
