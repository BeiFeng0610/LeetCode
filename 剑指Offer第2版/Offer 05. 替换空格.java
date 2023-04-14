class Solution {
	public String replaceSpace(String s) {
		if (s.length() == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (ch != ' ') {
				sb.append(ch);
			} else {
				sb.append("%20");
			}
		}
		return sb.toString();
	}
}