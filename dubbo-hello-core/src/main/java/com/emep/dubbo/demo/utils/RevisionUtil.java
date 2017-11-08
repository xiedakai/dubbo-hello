package com.emep.dubbo.demo.utils;

import java.util.List;

/**
 * @ClassName: RevisionUtil
 * @Description: 修约相关操作工具类
 * @author com_emep_mpc
 * @date 2016年10月18日 上午9:57:11
 * 
 */
public class RevisionUtil {



	/**
	 * @Title: getAvg
	 * @Description: 求平均值
	 * @param list
	 * @return
	 * @throws 无异常抛出
	 */
	public static Double getAvg(List<Double> list) {
		if (null == list || list.size() == 0)
			return 0.0;
		if (list.size() == 1)
			return list.get(0);

		Double sum = 0.0;
		for (Double d : list) {
			sum += d;
		}

		return sum / list.size();
	}

	/**
	 * @Title: getMax
	 * @Description:求最大值
	 * @param list
	 * @return
	 * @throws 无异常抛出
	 */
	public static Double getMax(List<Double> list) {

		if (null == list || list.size() == 0) {
			return 0.0;
		} else if (list.size() == 1) {
			return list.get(0);
		} else {
			Double result = list.get(0);
			for (Double d : list) {
				result = Math.max(result, d);
			}
			return result;
		}

	}

	/**
	 * @Title: getMedian
	 * @Description: 获取中位值
	 * @param list
	 * @return
	 * @throws 无异常抛出
	 */
	public static Double getMedian(List<Double> list) {
		int total = list.size();
		if (total % 2 == 0) {

			return (list.get(total / 2 - 1) + list.get(total / 2)) / 2;

		} else {
			return list.get(total / 2);
		}
	}

	/**
	 * @Title: insertSort
	 * @Description: 插入排序
	 * @param list
	 * @throws 无异常抛出
	 */
	public static void insertSort(List<Double> list) {

		if (null == list || list.size() < 2) {
			return;
		}

		for (int i = 1; i < list.size(); i++) {
			Double currentValue = list.get(i);
			int position = i;

			for (int j = i - 1; j >= 0; j--) {
				if (list.get(j) > currentValue) {
					list.set(j + 1, list.get(j));
					position -= 1;
				} else {
					break;
				}
			}

			list.set(position, currentValue);
		}
	}

}
