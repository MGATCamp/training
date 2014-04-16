package com.lewenyong;

public class Test {

    public static int middle(int a[]) {
        return getIndex(a, (a.length - 1) / 2);
    }

    public static int getIndex(int a[], int index) {
        if (index > a.length - 1) {
            throw new IllegalArgumentException();
        }
        if (a.length == 1) {
            return a[0];
        }
        //随机取一个数小于或等于index
        Random random = new Random();
        int r = random.nextInt(a.length - 1);

        int rv = a[r];

        int[] aLeft = new int[a.length];
        int[] aRight = new int[a.length];

        int lIndex = 0;
        int rIndex = 0;

        for (int i = 0; i < a.length; i++) {
            if (i != r) {
                if (a[i] < rv) {
                    aLeft[lIndex++] = a[i];
                } else {
                    aRight[rIndex++] = a[i];
                }
            }
        }

        aLeft = Arrays.copyOfRange(aLeft, 0, lIndex);
        aRight = Arrays.copyOfRange(aRight, 0, rIndex);

        //计算当前重复的
        int repeatNum = a.length - aLeft.length - aRight.length;

        if (index <= aLeft.length - 1) {
            //寻找的值在左侧
            a = aLeft;
            //index不变
        } else if (index < aLeft.length + repeatNum) {
            return rv;

        } else {
            a = aRight;
            index = index - aLeft.length - 1;
        }

        return getIndex(a, index);
    }

    public static void main(String[] args) {
        int a[] = new int[] { 2, 5, 5, 5, 6, 6, 9 };
        System.out.println(middle(a));
    }

}
