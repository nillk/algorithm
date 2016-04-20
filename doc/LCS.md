LCS(Longest Common Subsequence) <small>최장 공통 부분 수열</small>
--
*두 수열의 공통 부분 수열 중 가장 긴 것을 찾아내는 문제*  
LCS(Longest Common Substring) <small>최장 공통 부분 문자열</small> 과 혼동하면 안 됨

---
#### 복잡도
임의의 수의 수열의 경우 *NP-hard* 지만 주어진 수열의 개수가 일정할 때는 *동적계획법(Dynamic Programming)* 으로 다항시간에 풀 수 있다

> 동적계획법  
일반적으로 주어진 문제를 풀기 위해서, 문제를 여러 개의 *하위 문제(subproblem)* 로 나누어 푼 다음, 그것을 결합하여 최종적인 목적에 도달하는 것이다. 각 하위 문제의 해결을 계산한 뒤, 그 해결책을 저장하여 후에 같은 하위 문제가 나왔을 경우 그것을 간단하게 해결할 수 있다. 이러한 방법으로 동적 계획법은 계산 횟수를 줄일 수 있다. [위키백과][1]

#### 예시
ACAYKP와 CAPCAK의 최장 공통 부분 수열은 ACAK  

---
### [풀이 방법][2]
LCS는 작은 *부분문제* 로 쪼갤 수 있다. 그리고 각 부분문제는 더 작은 부분문제로 쪼개질 수 있으며, 상위 부분문제는 하위 부분문제의 해답을 이용해 답을 구할 수 있다. 따라서 부분문제의 합을 표에 저장하는 방식인 메모이제이션을 통하여 풀이하는 방식을 사용할 수 있다.  
여기서 두 수열 <big>X</big><small>1...m</small> and <big>Y</big><small>1...n</small>이 주어졌을 때 LCS 함수는 이렇게 정의할 수 있다.  

![LCS 함수 정의](https://upload.wikimedia.org/math/5/d/d/5dd8f6ef68fff159354e8ae98b40de7f.png)

### LCS의 풀이는 다음 두 속성에 의존
#### 첫번째
두 수열이 같은 원소로 끝난다고 가정하면? 가장 끝자리 원소는 계산할 필요가 없다. 따라서 마지막 원소를 제외하고 하나만큼 짧아진 수열로 LCS를 찾은 후, 제외했던 원소를 다시 붙이면 된다.  
```
LCS(Xn, Ym) = (LCS(Xn-1, Ym-1), Xn)
```

#### 두번째
두 수열이 같은 원소로 끝나지 않는다면? 역시 가장 마지막 자리 원소는 무시할 수 있다.(손실이 없다.)
```
LCS(Xn, Ym) = longest(LCS(Xn,Ym-1), LCS(Xn-1,Ym))
```


#### 문제
[백준 LCS&LIS 문제집](https://www.acmicpc.net/workbook/view/231)

[1]: https://ko.wikipedia.org/wiki/%EB%8F%99%EC%A0%81_%EA%B3%84%ED%9A%8D%EB%B2%95
[2]: https://ko.wikipedia.org/wiki/%EC%B5%9C%EC%9E%A5_%EA%B3%B5%ED%86%B5_%EB%B6%80%EB%B6%84_%EC%88%98%EC%97%B4
