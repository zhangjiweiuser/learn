package com.zhang.learn.chapter2023.chapter11.chapter1112;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SuccessfulPairs {
    public static void main(String[] args) {
        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};
        int[] ans = successfulPairs(spells,potions,7);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            if(map.get(spells[i]) != null){
                ans[i] = map.get(spells[i]);
            }else{
                if(map.get(spells[i]-1) != null){
                    int n = map.get(spells[i]-1);
                    if(n == potions.length){
                        ans[i] = n;
                        map.put(spells[i],n);
                    }else{
                        int t = potions.length - n;
                        while(t > 0){
                            if((long) spells[i] * potions[t - 1] >= success){
                                n++;
                                t--;
                            }else{
                                break;
                            }
                        }
                        ans[i] = n;
                        map.put(spells[i],n);
                    }

                }else{
                    int n = 0;
                    int t = potions.length - n;
                    while(t > 0){
                        if((long) spells[i] * potions[t - 1] >= success){
                            n++;
                            t--;
                        }else{
                            break;
                        }
                    }
                    ans[i] = n;
                    map.put(spells[i],n);
                }
            }
        }
        return ans;
    }
}
