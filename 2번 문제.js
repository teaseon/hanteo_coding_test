function solution (sum, coins){
  let resultArr = [];
  for(let c of coins){
    dfs(c, [c]);
  }
  function dfs(s, arr){
    if(s > sum){
      return;
    }
    if(s === sum){
      resultArr.push(arr.sort().join(''));
      return;
    }
    for(let coin of coins){
      dfs(s + coin, [...arr, coin]);
    }
  }

  return [...new Set(resultArr)].length;
}
