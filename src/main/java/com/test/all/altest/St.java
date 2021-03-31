package com.test.all.altest;

public class St {
    public static int countnumber(int[] a, int b) {
        int left = 0;
        int right = a.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (a[mid] == b)
                break;
            else {
                if (a[mid] > b) {
                    right = mid;
                } else if (a[mid] < b) {
                    left = mid;
                }

            }
        }
        left = mid;
        int l = findlocation(a, left, b, -1);
        right = mid;
        int r = findlocation(a, right, b, +1);

        return r - l-1;
    }

    public static int findlocation(int[] b, int location, int value, int direction) {

        int step = 1;
        if (location > 0) {
            while (location > 0 &&location < b.length) {
                if (b[location] == value) {
                    location = location + direction * step;
                    step++;
                    while (location < 0 || location > b.length) {
                        location = location - direction * step;
                        step--;
                        location = location + direction * step;
                    }
                    continue;
                }

                if (b[location] > value) {

                    for (int i = 0; i < step; i++) {
                        if (b[--location] == value)
                            break;
                    }
                    break;
                }
                if (b[location] < value) {
                    for (int i = 0; i < step; i++) {
                        if (b[++location] == value)
                            break;
                    }
                    break;
                }

            }
            return location;
        } else {
            return 0;
        }

    }

    public static void main(String[] args) {
        int arr[] = {1,2,2,3,3,3,3,4};
        int k=countnumber(arr,3);
        System.out.println(k);
    }

}
