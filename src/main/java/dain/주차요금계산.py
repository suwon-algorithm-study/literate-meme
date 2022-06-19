from collections import defaultdict
import math

def solution(fees, records):
    answer = []
    lst = []
    dic = defaultdict(list)
    for record in records:
        time, car, inout = record.split()
        dic[car].append(time)
    
    # 23:59 추가
    for d in dic:
        if len(dic[d]) % 2:
            dic[d].append('23:59')
    
    # 시간 계산 함수
    def time_cal(x):
        hour, minute = x.split(':')
        total = int(hour) * 60 + int(minute)
        return total
    
    # 시간
    time = []
    for d in sorted(dic):
        cnt = 0
        for i in range(0,len(dic[d]),2):
            cnt += time_cal(dic[d][i+1]) - time_cal(dic[d][i])
        time.append(cnt)
    
    # 요금
    cost = []
    for t in time:
        # 기본 시간 이내
        if t <= fees[0]:
            cost.append(fees[1])
        else:
            basic = fees[1]
            add_time = t - fees[0]
            add_fee = math.ceil(add_time/fees[2]) * fees[3]
            cost.append(basic + add_fee)
                        
    return cost