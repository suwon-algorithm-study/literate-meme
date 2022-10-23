def solution(lottos, win_nums):
    # 이미 가지고 있는 당첨 숫자 + 0의 개수
    cnt = 0
    for i in lottos:
        if i in win_nums:
            cnt += 1
            
    zero_cnt = lottos.count(0)
    
    if zero_cnt == 6:
        answer = [7-(cnt+zero_cnt),6]
        
    elif zero_cnt == 0 and cnt == 0:
        answer = [6,6]
        
    else:
        answer = [7-(cnt+zero_cnt),7-cnt]
        
    return answer