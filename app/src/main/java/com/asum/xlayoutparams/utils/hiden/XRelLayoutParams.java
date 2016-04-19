package com.asum.xlayoutparams.utils.hiden;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.asum.xlayoutparams.utils.DensityUtils;
import com.asum.xlayoutparams.utils.DensityUtils.Type;

public class XRelLayoutParams extends XBaseLayoutParams {
	private LayoutParams layoutParams;

	protected XRelLayoutParams(Context context, View view) {
		super(context, view);

		layoutParams = (LayoutParams) view.getLayoutParams();
		// layoutParams = new LayoutParams(0, 0);
		if (layoutParams == null) {
			Log.w("XJW", view + "控件的位置信息是新建的");
			layoutParams = new LayoutParams(0, 0);
		}
		measureView();
	}

	public void leftAlignLeft(View assignView) {
		initializeId(assignView);
		layoutParams.addRule(RelativeLayout.ALIGN_LEFT, assignView.getId());
	}

	public void rightAlignRight(View assignView) {
		initializeId(assignView);
		layoutParams.addRule(RelativeLayout.ALIGN_RIGHT, assignView.getId());
	}

	public void topAlignTop(View assignView) {
		initializeId(assignView);
		layoutParams.addRule(RelativeLayout.ALIGN_TOP, assignView.getId());
	}

	public void bottomAlignBottom(View assignView) {
		initializeId(assignView);
		layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, assignView.getId());
	}

	public void leftConnectRight(View assignView) {
		initializeId(assignView);
		layoutParams.addRule(RelativeLayout.RIGHT_OF, assignView.getId());
	}

	public void rightConnectLeft(View assignView) {
		initializeId(assignView);
		layoutParams.addRule(RelativeLayout.LEFT_OF, assignView.getId());
	}

	public void topConnectBottom(View assignView) {
		initializeId(assignView);
		layoutParams.addRule(RelativeLayout.BELOW, assignView.getId());
	}

	public void bottomConnectTop(View assignView) {
		initializeId(assignView);
		layoutParams.addRule(RelativeLayout.ABOVE, assignView.getId());
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
			layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		} else if (x == XBaseArea.INVARIANT) {
			x = (int) view.getX();
		} else if (x == XBaseArea.LEFT) {
			x = 0;
			layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		} else if (x == XBaseArea.RIGHT) {
			x = 0;
			layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
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
			layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
		} else if (y == XBaseArea.INVARIANT) {
			y = (int) view.getY();
		} else if (y == XBaseArea.TOP) {
			y = 0;
			layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		} else if (y == XBaseArea.BOTTOM) {
			y = 0;
			layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
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
			Log.i("XJW", "Rel：X：" + x + "，Y：" + y + "，W：" + w + "，H：" + h);
		}
		layoutParams.height = (int) h;
		layoutParams.width = (int) w;
		layoutParams.setMargins((int) x, (int) y, (int) (0), (int) (0));
		view.setLayoutParams(layoutParams);
	}

	private void initializeId(View assignView) {
		if (assignView.getId() == -1) {
			assignView.setId(XIDTools.getID());
		}
	}
}
