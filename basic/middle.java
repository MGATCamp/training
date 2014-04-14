package com.lewenyong;

public class Main {

	public static int middleNum(int[] a) {
		int len = a.length;
		int m = (len - 1) / 2;
		for (int i=0;i<len; i++) {
			int count = 0;
			for (int j=0 ;j<len;j++) {
				if (a[i] >= a[j]&&i!=j) {
					count++;
					if(count>m){
						break;
					}
				}
			}
			if(count==m){
				return a[i];
			}
		}
		throw new RuntimeException("error");
	}

	public static void main(String[] args) {
		int[] a = new int[] { 100, 4, 4, 4, 4, 101, 7, 5, 4 };
		System.out.println(middleNum(a));
 	}

}
