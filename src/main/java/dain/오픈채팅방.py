def solution(record):
    answer = []
    arr = []
    dic = {}
    for x in record:
        arr.append(x.split())
        if len(arr[-1]) == 3: # Leave 땜에
            dic[arr[-1][1]] = arr[-1][-1]
    
    for i in range(len(arr)):
        if arr[i][0] == 'Enter':
            answer.append(f'{dic[arr[i][1]]}님이 들어왔습니다.')
        elif arr[i][0] == 'Leave':
            answer.append(f'{dic[arr[i][1]]}님이 나갔습니다.')
        else:
            pass
            
    return answer