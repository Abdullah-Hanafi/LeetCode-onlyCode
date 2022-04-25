package No_165比较版本号;

public class Solution {
    /**
     * 方法一：while+字符串分割
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while (i < v1.length && i < v2.length) {
            if (Integer.parseInt(v1[i]) == Integer.parseInt(v2[i])) {
                i++;
            } else if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                return -1;
            } else {
                return 1;
            }
        }
        while (i < v1.length) {
            if (Integer.parseInt(v1[i]) != 0) {
                return 1;
            } else {
                i++;
            }
        }
        while (i < v2.length) {
            if (Integer.parseInt(v2[i]) != 0) {
                return -1;
            } else {
                i++;
            }
        }
        return 0;
    }

    /**
     * 方法二：官方答案for+字符串分割
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion1(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length || i < v2.length; i++) {
            int x = 0;
            int y = 0;
            if (i < v1.length) {
                x = Integer.parseInt(v1[i]);
            }

            if (i < v2.length) {
                y = Integer.parseInt(v2[i]);
            }

            if (x > y) {
                return 1;
            }

            if (x < y) {
                return -1;
            }
        }
        return 0;
    }
}
