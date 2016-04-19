package com.asum.xlayoutparams.utils.hiden;

import android.content.Context;
import android.view.View;

public abstract class XBaseLayoutParams {
	protected Context context;
	protected View view;
	protected int x, y, w, h;

	public XBaseLayoutParams(Context context, View view) {
		this.context = context;
		this.view = view;
	}

	protected void measureView() {
		int measureW = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		int measureH = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		view.measure(measureW, measureH);
	}

	public abstract void setDp(int x, int y, int w, int h);

	public abstract void setDiv(int x, int y, int w, int h);

	public abstract void setPx(int x, int y, int w, int h);

	protected abstract void analyseXywhFromType(int type);

	protected abstract void analyseW(int type);

	protected abstract void analyseH(int type);

	protected abstract void analyseX(int type);

	protected abstract void analyseY(int type);

	protected abstract void setXywh();

	public static final int MAX_WIDTH = 720;

	public static final int MAX_HEIGHT = 1280;
}
