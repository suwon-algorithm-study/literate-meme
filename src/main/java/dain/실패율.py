def solution(N, stages):
    lst = [0]*(N+2)
    for i in stages:
        lst[i] += 1
        
    fail = []
    num = lst[-1]
    for i in range(N,0,-1):
        num += lst[i]
        if num == 0:
            fail.append(0)
        else:
            fail.append(lst[i]/num)
            
    fail = fail[::-1]
    order = list(enumerate(fail,1))
    order.sort(key=lambda x: (-x[1],x[0]))
    answer = [order[i][0] for i in range(N)]
    return answer