package top.werls.data.algortihm.chapter.one;

/**
 * @author : Lee JiaWei
 * @version V1.0
 * @Project: data
 * @Date : 2020/7/23 17:32
 */
public class StringTools {
    /**
     * 判断是否含有回文
     *
     * @param str String
     * @return boolean
     */
    public static boolean isPalindrome(String str) {
        
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static String fileExtensionName(String file) {
        return file.substring(file.indexOf(".") + 1);
    }

    public static String fileBaseName(String file) {
        return file.substring(0, file.indexOf("."));
    }

    public boolean isSorted(String[] strings) {
        for (int i = 1; i < strings.length; i++) {
            if (strings[i - 1].compareTo(strings[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
