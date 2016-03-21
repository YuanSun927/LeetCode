/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/
public class _93_RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12)
            return result;
        StringBuilder temp = new StringBuilder();
        restoreIpAddresses(s, 0, 0, temp, result);
        return result;
    }

    private void restoreIpAddresses(String s, int start, int n, StringBuilder temp, List<String> result) {
        if (start == s.length() && n == 4) {
            result.add(temp.toString());
            return;
        }
        if (start > s.length() || n > 4)
            return;
        for (int i = start; i < start + 3 && i < s.length(); i++) {
            String subIP = s.substring(start, i + 1);
            if (subIP.charAt(0) == '0' && subIP.length() > 1 || Integer.parseInt(subIP) > 255)
                continue;
            int len = temp.length();
            if (n != 0)
                temp.append('.');
            temp.append(subIP);
            restoreIpAddresses(s, i + 1, n + 1, temp, result);
            temp.delete(len, temp.length());
        }
    }

    // 直接循环，适用于本题递归层数少的情况，测试结果比之前方法快
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        int len = s.length();
        String s1, s2, s3, s4;
        for(int i = 1; i < 4 && i < len - 2; i++) {
            s1 = s.substring(0, i);
            if (!isValid(s1))
                continue;
            for(int j = i + 1; j < i + 4 && j < len - 1; j++) {
                s2 = s.substring(i, j);
                if (!isValid(s2))
                    continue;
                for(int k = j + 1; k < j + 4 && k < len; k++) {
                    s3 = s.substring(j, k);
                    if (!isValid(s3))
                        continue;
                    s4 = s.substring(k, len);
                    if (isValid(s4)) {
                        result.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String s){
        return !(s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255);    
    }
}