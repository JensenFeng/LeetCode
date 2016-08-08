package me.jie;

/**
 * Created by jie on 8/5/16.
 * https://leetcode.com/problems/word-ladder/
 */

import java.util.*;

public class Leet127 {
    /**
     * TLE: DFS
     */
    private int ans = Integer.MAX_VALUE-2;
    Map<String, Integer> mp;
    Map<String, Map<String, Integer> > allMP;
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord.length() == 0) return 2;
        mp = new HashMap<>();
        mp.put(endWord, countDiffLen(beginWord, endWord));
        for(String s : wordList){
            if(!mp.containsKey(s)){
                mp.put(s, countDiffLen(beginWord, s));
            }
        }
        allMP = new HashMap<>();
        HashMap<String, Integer> ewmp = new HashMap<>();
        for(String s : wordList){
            ewmp.put(s, countDiffLen(endWord, s));
        }
        allMP.put(endWord, ewmp);
        HashMap<String, Integer> wlmp;
        for(String s: wordList){
            wlmp = new HashMap<>();
            for(String ss: wordList){
                wlmp.put(ss, countDiffLen(s, ss));
            }
            allMP.put(s, wlmp);
        }

        ladder(beginWord, endWord, wordList, new HashSet<>());

        return ans+2 == Integer.MAX_VALUE ? 0 : ans + 2;
    }
    private void ladder(String beginWord, String endWord, Set<String> wordList, Set<String> marked){
        int countDiff = mp.get(endWord);
        if(countDiff <= 1){
            if(marked.size() < ans){
                ans = marked.size();
                //System.out.println(ans);
            }
            return;
        }else{
            for(String s: wordList){
                if(!marked.contains(s)){
                    if(allMP.get(endWord).get(s) <= 1){
                        marked.add(s);
                        ladder(beginWord, s, wordList, marked);
                        marked.remove(s);
                    }
                }
            }
        }
    }
    private int countDiffLen(String beginWord, String endWord){
        int len = beginWord.length();
        int countDiff = 0;
        for(int i = 0; i < len; i ++){
            if(beginWord.charAt(i) != endWord.charAt(i)){
                countDiff ++;
                if(countDiff >= 2){
                    break;
                }
            }
        }
        return countDiff;
    }


    /**
     * BFS
     */

    public int ladderLengthbfs(String beginWord, String endWord, Set<String> wordList){
        if(beginWord.equals(endWord)) return 2;
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);

        wordList.add(endWord);
        wordList.remove(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int j = 0; j < len; j ++) {
//                Set<String> topList = new HashSet<>();

                char[] curr = queue.poll().toCharArray();
                for (int i = 0; i < curr.length; i++) {
                    char c = curr[i];
                    for (char e = 'a'; e <= 'z'; e ++) {
                        curr[i] = e;
                        String s = new String(curr);
                        if(s.equals(endWord)) return level + 1;
                        if(wordList.contains(s)){
                            wordList.remove(s);
                            queue.add(s);
                        }
                    }
                    curr[i] = c;
                }
                if(wordList.size() == 0) return 0;
            }
            level ++;
        }
        return 0;
    }
    public static void main(String[] args){
        Set<String> set = new HashSet<>();
        String[] str = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av",
                "sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr",
                "po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as",
                };
        for(String s: str){
            set.add(s);
        }
        System.out.println(new Leet127().ladderLengthbfs("qa", "sq", set));
    }
}
