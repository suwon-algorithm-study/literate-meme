from collections import deque

def solution(s):
    answer = 1
    q = deque()
    for x in s:
        if len(q) == 0:
            q.append(x)
        elif q[-1] == x:
            q.pop()
        else:
            q.append(x)
    
    if q:
        answer = 0
    
    return answer