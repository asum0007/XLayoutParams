package com.asum.xlayoutparams.utils.hiden;

/**
 * 获取不重复的ID值
 * 
 * @author Asum
 *
 */
public class XIDTools {
	private final static int ID_SEEDS = 745201;
	private static int ID_COUNT = 0;

	public static int getID() {
		ID_COUNT++;
		return ID_SEEDS + ID_COUNT;
	}
}
