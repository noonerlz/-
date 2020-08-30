package cn.nooner.demo;

import java.time.Clock;
import java.util.HashSet;
import java.util.Random;

/**
 * 入参:50 万个不重复的整数。 
 * 出参:随机返回 10 万个不重复的整数。 
 * 要求:
 * 1、执行时间尽可能少。 
 * 2、Maven项目实现项目可编译运行。
 *
 */
public class App {
	public static void main(String[] args) {
		int n1 = 500000;
		int n2 = 100000;
		long startTime = Clock.systemDefaultZone().millis();
		int[] num = getNum(n1);
		int[] rs = outNum(num, n2);
		long endTime = Clock.systemDefaultZone().millis();
		System.out.println("50w数据是否存在重复："+cheakIsRepeat(num));
		System.out.println("10w数据是否存在重复："+cheakIsRepeat(rs));
		System.out.println("用时：" + (endTime - startTime));
		//System.out.println("获取的10w随机数：" + Arrays.toString(rs));
	}

	public static int[] getNum(int n) {
		int[] x = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = i;
		}
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			int in = r.nextInt(n - i) + i;
			int t = x[in];
			x[in] = x[i];
			x[i] = t;
		}
		return x;
	}

	public static int[] outNum(int[] num, int n) {
		int len = num.length;
		int[] source = new int[len];  
	    for (int i = 0; i <len; i++){  
	    	source[i] = i;  
	    }  
	         
	    int[] result = new int[n];  
	    Random rd = new Random();  
	    int index = 0;  
	    for (int i = 0; i < result.length; i++) {
	    	index = Math.abs(rd.nextInt() % len--);
	    	result[i] = source[index];
	    	source[index] = source[len];  
		}
		int[] x = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = num[result[i]];
		}
		return x;
	}

	public static boolean cheakIsRepeat(int[] array) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			hashSet.add(array[i]);
		}
		if (hashSet.size() == array.length) {
			return false;
		} else {
			return true;
		}
	}
}
