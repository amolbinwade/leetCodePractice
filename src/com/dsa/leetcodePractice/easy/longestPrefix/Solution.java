package com.dsa.leetcodePractice.easy.longestPrefix;

public class Solution {

	public static void main(String[] args) {

		Solution s = new Solution();
		String[] strs = { "flower", "flow", "flight" };

		System.out.println(s.longestCommonPrefix(strs));

	}

	public String longestCommonPrefix(String[] strs) {

		String pre = strs[0];

		for (int i = 1; i < strs.length; i++) {
			pre = Solution.getCommonPrefix(pre, strs[i]);
			if (pre.equals("")) {
				break;
			}
		}

		return pre;

	}

	public static String getCommonPrefix(String s1, String s2) {
		if(s1.length() == 0 || s2.length() == 0){
			return "";
		}

		
		int i = 0;

		while (s1.charAt(i) == s2.charAt(i)) {	
			
			i++;
			if (i >= s1.length() || i >= s2.length()) {
				break;
			}
		}
		return s1.substring(0, i);

	}

}
