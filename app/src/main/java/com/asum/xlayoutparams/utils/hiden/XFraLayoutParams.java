package com.asum.xlayoutparams.utils.hiden;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;

import com.asum.xlayoutparams.utils.DensityUtils;
import com.asum.xlayoutparams.utils.DensityUtils.Type;

@SuppressLint("RtlHardcoded")
public class XFraLayoutParams extends XBaseLayoutParams {
	private LayoutParams layoutParams;

	public XFraLayoutParams(Context context, View view) {
		super(context, view);

		layoutParams = new LayoutParams(0, 0);
		if (layoutParams == null) {
			layoutParams = new LayoutParams(0, 0);
		}
		measureView();
	}

	public void setDp(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;

		analyseXywhFromType(0);
		setXywh();
	}

	public void setDiv(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;

		analyseXywhFromType(1);
		setXywh();
	}

	public void setPx(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;

		analyseXywhFromType(2);
		setXywh();
	}

	protected void analyseXywhFromType(int type) {
		analyseW(type);
		analyseH(type);
		analyseX(type);
		analyseY(type);
	}

	protected void analyseW(int type) {
		if (w == XBaseArea.MATCH) {
			w = android.view.ViewGroup.LayoutParams.MATCH_PARENT;
		} else if (w == XBaseArea.INVARIANT) {
			if (view.getWidth() == 0) {
				w = view.getMeasuredWidth();
			} else {
				w = view.getWidth();
			}
		} else if (w == XBaseArea.WRAP) {
			w = android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
		} else {
			if (type == 0) {
				w = DensityUtils.dip2px(context, w);
			} else if (type == 1) {
				w = DensityUtils.div2px(context, w, Type.WIDTH);
			}
		}
	}

	protected void analyseH(int type) {
		if (h == XBaseArea.MATCH) {
			h = android.view.ViewGroup.LayoutParams.MATCH_PARENT;
		} else if (h == XBaseArea.INVARIANT) {
			if (view.getHeight() == 0) {
				h = view.getMeasuredHeight();
			} else {
				h = view.getHeight();
			}
		} else if (h == XBaseArea.WRAP) {
			h = android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
		} else {
			if (type == 0) {
				h = DensityUtils.dip2px(context, h);
			} else if (type == 1) {
				h = DensityUtils.div2px(context, h, Type.HEIGHT);
			}
		}
	}

	protected void analyseX(int type) {
		if (x == XBaseArea.CENTER) {
			x = 0;
			layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
		} else if (x == XBaseArea.INVARIANT) {
			x = (int) view.getX();
		} else if (x == XBaseArea.LEFT) {
			x = 0;
			layoutParams.gravity = Gravity.LEFT;
		} else if (x == XBaseArea.RIGHT) {
			x = 0;
			layoutParams.gravity = Gravity.RIGHT;
		} else {
			if (type == 0) {
				x = DensityUtils.dip2px(context, x);
			} else if (type == 1) {
				x = DensityUtils.div2px(context, x, Type.WIDTH);
			}
		}
	}

	protected void analyseY(int type) {
		if (y == XBaseArea.CENTER) {
			y = 0;
			layoutParams.gravity = Gravity.CENTER_VERTICAL;
		} else if (y == XBaseArea.INVARIANT) {
			y = (int) view.getY();
		} else if (y == XBaseArea.TOP) {
			y = 0;
			layoutParams.gravity = Gravity.TOP;
		} else if (y == XBaseArea.BOTTOM) {
			y = 0;
			layoutParams.gravity = Gravity.BOTTOM;
		} else {
			if (type == 0) {
				y = DensityUtils.dip2px(context, y);
			} else if (type == 1) {
				y = DensityUtils.div2px(context, y, Type.HEIGHT);
			}
		}
	}

	protected void setXywh() {
		if (XBaseArea.IS_PRINT) {
			Log.i("XJW", "Fra：X：" + x + "，Y：" + y + "，W：" + w + "，H：" + h);
		}
		layoutParams.height = (int) h;
		layoutParams.width = (int) w;
		layoutParams.setMargins((int) x, (int) y, (int) (0), (int) (0));
		view.setLayoutParams(layoutParams);
	}
}
