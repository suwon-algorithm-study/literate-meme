def solution(n):
    answer = ''
    l = ''
    lst = ['1','2','4']
    while n > 0:
        n -= 1
        answer = lst[n%3] + answer
        n //= 3
         
    return answer