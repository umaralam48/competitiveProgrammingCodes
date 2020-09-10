public class LargestTimeFromNumbers {
    public static void main(String[] args) {
        int[] a = { 0, 0, 0, 9 };
        System.out.println(largestTimeFromDigits(a));
    }

    public static String largestTimeFromDigits(int[] A) {
        boolean taken[] = new boolean[4];
        int mh = -1, mm = -1;
        for (int i = 0; i < 3; i++) {
            taken[i] = true;
            for (int j = i + 1; j < 4; j++) {
                taken[j] = true;
                int h = A[i] * 10 + A[j];
                int hr = A[j] * 10 + A[i];
                int m = 0;
                int mr = 0;
                for (int k = 0; k < 4; k++) {
                    if (taken[k])
                        continue;
                    m = m * 10 + A[k];
                    mr = A[k] * 10 + mr / 10;
                }
                if (h < 24) {
                    if (m < 60) {
                        if (h > mh) {
                            mh = h;
                            mm = m;
                        } else if (h == mh) {
                            if (m > mm) {
                                mm = m;
                            }
                        }
                    }
                    if (mr < 60) {
                        if (h > mh) {
                            mh = h;
                            mm = mr;
                        } else if (h == mh) {
                            if (mr > mm) {
                                mm = mr;
                            }
                        }
                    }
                }
                if (hr < 24) {
                    if (m < 60) {
                        if (hr > mh) {
                            mh = hr;
                            mm = m;
                        } else if (hr == mh) {
                            if (m > mm) {
                                mm = m;
                            }
                        }
                    }
                    if (mr < 60) {
                        if (hr > mh) {
                            mh = hr;
                            mm = mr;
                        } else if (hr == mh) {
                            if (mr > mm) {
                                mm = mr;
                            }
                        }
                    }
                }
                taken[j] = false;
            }
            taken[i] = false;
        }
        if (mh == -1 && mm == -1)
            return "";
        else
            return (mh < 10 ? "0" : "") + mh + ":" + (mm < 10 ? "0" : "") + mm;
    }
}