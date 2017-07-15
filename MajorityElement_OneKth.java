/* Given an integer array of length L, find all numbers that occur more than 1/K * L times if any exist.

Assumptions:
The given array is not null or empty
K >= 2

Examples:
A = {1, 2, 1, 2, 1}, K = 3, return [1, 2]
A = {1, 2, 1, 2, 3, 3, 1}, K = 4, return [1, 2, 3]
A = {2, 1}, K = 2, return []   */


// 参考 Majority Element_One Third 那一题
// 对消的方法
// Time: O(n*k), Space: O(k)

/* 思路：
   用别的数 “对消” 目前计数最 “冒尖” 的数 ！！！ 
   要求出现次数大于 n/k 的数，那么我们就需要 k-1 个 candidates ！！！ 
   这样如果来了一个数不等于这k-1中的任何一个，就会是k个数的对消 ！！！ 就是说k个数每个数的相应的count都 -1
   用一个 Map 来存 <candidate_i, count_i> ！
   最后符合要求的数可能不止一个。
   
   从数组左端的第一个数开始，一个一个看，设当前数为 cur，
   如果 hashMap.containsKey(cur) 为 true，
       hashMap.put(cur, count_cur ++)    
   如果 hashMap.containsKey(cur) 为 false，
       如果当前 hashMap.size() < k - 1，
           我们就把cur放进去，即 hashMap.put(cur, 1)
       如果当前 hashMap.size() == k - 1，
           我们就把 map 里的所有 entries 的 value 即 count 全都 -1，
           然后如果哪个count减去这个1后成为了0，就把整个entry删掉 ！
        
   总之，可以这么理解：
   每一次累加，都是对于当前candidate的增强，
   而每一次削减，都是  k个不同的数  同时削减 ！！！ 最后的赢家 理  应  能 Survive 这种削减　！！！　*/






