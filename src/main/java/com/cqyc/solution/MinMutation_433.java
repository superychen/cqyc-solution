package com.cqyc.solution;

import java.util.*;

/**
 * @author cqyc
 * @create 2023-01-17-15:03
 */
//基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
//
// 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
//
//
// 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
//
//
// 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
//
// 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成
//此基因变化，返回 -1 。
//
// 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
//
//
//
// 示例 1：
//
//
//输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
//输出：1
//
//
// 示例 2：
//
//
//输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA",
//"AAACGGTA"]
//输出：2
//
//
// 示例 3：
//
//
//输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC",
//"AACCCCCC"]
//输出：3
//
//
//
//
// 提示：
//
//
// start.length == 8
// end.length == 8
// 0 <= bank.length <= 10
// bank[i].length == 8
// start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成
//
// Related Topics 广度优先搜索 哈希表 字符串 👍 234 👎 0
public class MinMutation_433 {

    public int minMutation(String startGene, String endGene, String[] bank) {
        //设置初始值
        Set<String> cnt = new HashSet<>();
        Set<String> visited = new HashSet<>();
        char[] chat = new char[]{'A', 'C', 'G', 'T'};
        //讲bank数组放入cnt的map中
        cnt.addAll(Arrays.asList(bank));
        if(startGene.equals(endGene)) {
            return 0;
        }
        if(!cnt.contains(endGene)) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        int step = 1;
        while(!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String poll = queue.poll();
                //这里显示每个字符串需要换的次数
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        //这里直接枚举全部的可能，最多3 * 8为24次，每次的替换看bank数组里面是否有匹配的字符串
                        if(chat[k] != poll.charAt(j)) {
                            StringBuffer buffer = new StringBuffer(poll);
                            buffer.setCharAt(j, chat[k]);
                            String nextStr = buffer.toString();
                            //这里需要判断visited数组中是否已经出现过，如果出现过，则之前已经有字符串进行匹配过了
                            if(!visited.contains(nextStr) && cnt.contains(nextStr)) {
                                if(nextStr.equals(endGene)) {
                                    return step;
                                }
                                queue.offer(nextStr);
                                visited.add(nextStr);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinMutation_433 test = new MinMutation_433();
        //输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA",
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = new String[]{"AACCGGTA","AACCGCTA", "AAACGGTA"};
        int i = test.minMutation(start, end, bank);
        System.out.println("i = " + i);
    }

}
