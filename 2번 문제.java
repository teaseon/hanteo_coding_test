import java.util.*;

public class Solution {
    public static int solution(int sum, int[] coins) {
        List<String> resultArr = new ArrayList<>();
        for (int c : coins) {
            dfs(c, new ArrayList<>(Collections.singletonList(c)), sum, coins, resultArr);
        }
        Set<String> uniqueResultArr = new HashSet<>(resultArr);

        return uniqueResultArr.size();
    }

    private static void dfs(int s, List<Integer> arr, int sum, int[] coins, List<String> resultArr) {
        if (s > sum) {
            return;
        }
        if (s == sum) {
            resultArr.add(arr.stream().sorted().map(String::valueOf).collect(Collectors.joining()));
            return;
        }
        for (int coin : coins) {
            dfs(s + coin, new ArrayList<>(arr) {
                {
                    add(coin);
                }
            }, sum, coins, resultArr);
        }
    }
}
