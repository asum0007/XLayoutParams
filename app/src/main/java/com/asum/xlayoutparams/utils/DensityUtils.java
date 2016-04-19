package com.asum.xlayoutparams.utils;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.asum.xlayoutparams.utils.hiden.XBaseLayoutParams;

public class DensityUtils {
	public enum Type {
		WIDTH, HEIGHT
	}

	/**
	 * dp转px
	 * 
	 * @param context
	 * @param dpValue
	 * @return
	 */
	public static int dip2px(Context context, double dpValue) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) dpValue, context.getResources().getDisplayMetrics());
	}

	/**
	 * px转dp
	 * 
	 * @param context
	 * @param pxValue
	 * @return
	 */
	public static int px2dip(Context context, double pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * div转px
	 * 
	 * @param context
	 * @param divValue
	 * @param type
	 * @return
	 */
	public static int div2px(Context context, double divValue, Type type) {
		Point screenSize = getScreenPx(context);
		if (type == Type.HEIGHT) {
			float scale = XBaseLayoutParams.MAX_HEIGHT / (float) screenSize.y;
			return (int) (divValue / scale);
		} else {
			float scale = XBaseLayoutParams.MAX_WIDTH / (float) screenSize.x;
			return (int) (divValue / scale);
		}
	}

	/**
	 * px转div
	 * 
	 * @param context
	 * @param pxValue
	 * @param type
	 * @return
	 */
	public static int px2div(Context context, double pxValue, Type type) {
		Point screenSize = getScreenPx(context);
		if (type == Type.HEIGHT) {
			float scale = XBaseLayoutParams.MAX_HEIGHT / (float) screenSize.y;
			return (int) (pxValue * scale);
		} else {
			float scale = XBaseLayoutParams.MAX_WIDTH / (float) screenSize.x;
			return (int) (pxValue * scale);
		}
	}

	/**
	 * 获取屏幕的dp
	 * 
	 * @param context
	 * @return
	 */
	public static Point getScreenDip(Context context) {
		Point point = new Point();
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		point.y = px2dip(context, dm.heightPixels);
		point.x = px2dip(context, dm.widthPixels);
		return point;
	}

	/**
	 * 获取屏幕的px
	 * 
	 * @param context
	 * @return
	 */
	public static Point getScreenPx(Context context) {
		Point point = new Point();
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		point.y = dm.heightPixels;
		point.x = dm.widthPixels;
		return point;
	}
}
