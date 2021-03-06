/* There is a building of n floors. If an egg drops from the k th floor or above, it will break. 
If it's dropped from any floor below, it will not break.
You're given two eggs, Find k while minimize the number of drops for the worst case. 
Return the number of drops in the WORST case.

Clarification:
For n = 10, a naive way to find k is drop egg from 1st floor, 2nd floor ... kth floor. 
But in this worst case (k = 10), you have to drop 10 times.
Notice that you have two eggs, so you can drop at 4th, 7th & 9th floor, 
in the worst case (for example, k = 9) you have to drop 4 times.

Example:
Given n = 10, return 4.
Given n = 100, return 14. */

// 比较详细的讲述整个 飞蛋问题：
// Ref: http://datagenetics.com/blog/july22012/index.html

// 注意：如果一个蛋在某次摔时没碎，它是可以被重复利用的
// 一个蛋摔一次，不管碎不碎，都算是一次drop
// 不管一开始有几个蛋，当只剩最后一个蛋时，只能老老实实在当前的目标区间内从低到高一层一层试了

/* 如果要考虑2个蛋扔5次最多能check多少层楼，我们的思路如下图，从这张图的最下面开始，从下往上看：

--------------------------------------------------
|        第五步：如果第1个蛋在14楼没碎              |
|        我们在第15层楼第5次扔第1个蛋               |                       扔1次
--------------------------------------------------
      5次仍蛋都用完了。第2个蛋不能再扔了
最后这一次在第15层扔的第1个蛋，能说明15层碎还是不碎（前面的过程说明了14不碎）
 所以第1个蛋扔了5次，第2个蛋不能再扔了，一共还是扔5次
 
--------------------------------------------------
|        第四步：如果第1个蛋在12楼没碎              |
|        我们在第14层楼第4次扔第1个蛋               |                       扔1次
--------------------------------------------------
    如果第1个蛋在14楼碎了，14层和12层之间间隔了1层楼，
         第2个蛋还能再扔1次以检验哪个楼会碎                              最多扔1次
 所以第1个蛋扔了4次，第2个蛋最多扔1次，一共还是最多扔5次
 
--------------------------------------------------
|        第三步：如果第1个蛋在9楼没碎               |
|        我们在第12层楼第3次扔第1个蛋               |                       扔1次
--------------------------------------------------
    如果第1个蛋在12楼碎了，12层和9层之间间隔了2层楼，
         第2个蛋还能再扔2次以检验哪个楼会碎                              最多扔2次
 所以第1个蛋扔了3次，第2个蛋最多扔2次，一共还是最多扔5次

--------------------------------------------------
|        第二步：如果第1个蛋在5楼没碎               |
|        我们在第9层楼第2次扔第1个蛋                |                       扔1次
--------------------------------------------------
    如果第1个蛋在9楼碎了，9层和5层之间间隔了3层楼，
         第2个蛋还能再扔3次以检验哪个楼会碎                              最多扔3次
 所以第1个蛋扔了2次，第2个蛋最多扔3次，一共还是最多扔5次

--------------------------------------------------      
|            第一步：第1个蛋扔到5楼                |                        扔1次
--------------------------------------------------
        如果第1个蛋在5楼碎了，下面还有4层楼，
         第2个蛋还能再扔4次以检验哪个楼会碎                              最多扔4次
 所以第1个蛋扔了1次，第2个蛋最多扔4次，一共最多扔5次

上面的数加起来是： (1+4) + (1+3) + (1+2) + (1+1) + (1+0) = 15层楼
到了这里，也可以将其视为 5 + 4 + 3 + 2 + 1                                   */

public class Solution {
       
    public int dropEggs(int n) {
        
        // 注意！n 虽然不会超过int的范围，但我们的实验和sum可能超过int的范围！！
        // 比如n正好在int的上限处的话，sum必须>=int的上限才能导致while循环结束
        long sum = 0;
        int i = 1;
        
        while (sum < n) {
            sum += i;
            i++;
        }
        return i - 1;
    }
}
