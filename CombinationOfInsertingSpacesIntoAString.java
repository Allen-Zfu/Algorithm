/* 对于一个String，在它的内部，相邻的char之间，可以塞入一个或者零个空格。问所有的可能产出
比如，对于字符串 ILZY，可能的产出包括：
ILZY
ILZ Y
IL ZY
IL Z Y
I LZY
I LZ Y
I L ZY
I L Z Y    */


// 方法1：经典的 BFS 方法
// 注意！！！ 这一题插入space会影响char的index，但是我们如果采用
// curIndex仅和原string相绑定，而与插入后的string无关，就可以解决这个问题
// 插入空格后的string，即半成品prefix string，我们用一个StringBuilder来另外表达。这样就和index以及原string这些东西都分开了 ！！！
//
// Time: O(2^n), n is the length of the input string, 2^n is the amount of answers
// Space: O(n). StringBuilder
public class Solution {
	 
	public List<String> insertSpaces(String str) {
		List<String> result = new ArrayList<>();
 
		if (str == null || str.length() == 0) {
			return result;
		}
		
		bfs(str.toCharArray(), 0, new StringBuilder(), result);
		return result;
	}
		 
	private void bfs(char[] cArray, int curIndex, StringBuilder cur, List<String> result) {
		int n = cArray.length;
		
		if (curIndex == n - 1) {
			cur.append(cArray[n - 1]);
			result.add(cur.toString());
			cur.deleteCharAt(cur.length() - 1); // 特别容易漏了这个　！！！
			return;
		}
		
		
		the following can be simplified:```````````````````````````````````
		add A
	        add space
		do helper once
		delete the end char of sb
		
		do helper for another time
		delete the end char of sb again
		
		
		
		// Case 1: do not insert space in the current index
		cur.append(cArray[curIndex]);
		bfs(cArray, curIndex + 1, cur, result);
		cur.deleteCharAt(cur.length() - 1);
		 
		// Case 2: insert a space in the current index
		cur.append(cArray[curIndex]);
		cur.append(' ');
		bfs(cArray, curIndex + 1, cur, result);
		cur.deleteCharAt(cur.length() - 1);
		cur.deleteCharAt(cur.length() - 1);
		
		```````````````````````````````````````````````````````````````````````
	}
}


