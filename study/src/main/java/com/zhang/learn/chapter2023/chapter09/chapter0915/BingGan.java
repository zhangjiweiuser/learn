package com.zhang.learn.chapter2023.chapter09.chapter0915;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *
 * 对每个孩子 i，都有一个胃口值  g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * 示例  1:
 *
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1 解释:你有三个孩子和两块小饼干，3 个孩子的胃口值分别是：1,2,3。虽然你有两块小饼干，由于他们的尺寸都是 1，你只能让胃口值是 1 的孩子满足。所以你应该输出 1。
 * @author zhangjiwei1
 * @description
 * @create 2023-09-15 10:37
 */
public class BingGan {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println(tanxin(g,s));
    }
    private static int tanxin(int[] g,int[] s){
        int index = s.length-1;
        int count = 0;
        for(int i=g.length-1;i>=0;i--){
            if(index>=0 && s[index] >= g[i]){
                index--;
                count++;
            }
        }
        return count;
    }
}
