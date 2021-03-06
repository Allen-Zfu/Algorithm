/* 
目前看到的最全的背包九讲：
https://www.kancloud.cn/kancloud/pack/70124
这可远不是九道背包题！而是九大topic！


Laioffer 总结

Given a set of n items, each item has a weight of w[i], i = 1, 2... n. The Backpack has a weight capacity of W.
What's the max total weight you can put into the Backpack?

1. Naive 0/1 Backpack Problem:
    1.1 Max total weight:
        M[i, w] = M[i - 1, w] || M[i - 1, w - weights[i]]
    1.2 Get number of solutions:
        M[i, w] = M[i - 1, w] + M[i - 1, w - weights[i]]
    1.3 Use minimum number of items:
        M[i, w] = min(M[i - 1, w], M[i - 1, w - weights[i]] + 1)

2. Classical 0/1 Backpack Problem:
    each item has a value of v[i]
    M[i, w] = max(M[i - 1, w], M[i - 1, w - weights[i]] + v[i])

3. Unbounded Backpack Problem:
    M[i, w] = max(M[i - 1, w], M[i, w - weights[i]] + v[i])
    
4. Group Backpack Problem:
    M[k, w] = max(M[k - 1, w], M[k - 1, w - weights[i]] + v[i] | item i belongs to group k)

5. 2D-weights Backpack Problem:
    M[i, w1, w2] = max(M[i - 1, w1, w2], M[i - 1, w1 - weights1[i], w2 - weights2[i]] + v[i]) 
    
*/
