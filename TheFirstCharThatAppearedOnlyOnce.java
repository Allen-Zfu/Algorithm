/* 给一个数组，里面的元素是a到z的小写字母，它们可能会重复出现。找第一个只出现了一次的字母

思路：
做一个长度为26的int数组，比如叫做 int[] counts，记录每个字母出现过多少次。
然后：关键在于：再从char数组的左边开始，一个一个看逐个字母，如果 counts[curChar - 'a'] == 1，则curChar就是我们要的答案  */
