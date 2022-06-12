def solution(numbers, hand):
    ans = ''
    left = '*'
    right = '#'
    coordinate = {'*':(0,0), 7:(0,1), 4:(0,2), 1:(0,3), 0:(1,0), 8:(1,1), 5:(1,2), 2:(1,3), '#':(2,0), 9:(2,1), 6:(2,2), 3:(2,3)}
    for num in numbers:
        if num == 1 or num == 4 or num == 7:
            ans += 'L'
            left = num
        elif num == 3 or num == 6 or num == 9:
            ans += 'R'
            right = num
        else:
            # 거리를 구해라
            dis_left = abs(coordinate[num][0] - coordinate[left][0]) + abs(coordinate[num][1] - coordinate[left][1])
            dis_right = abs(coordinate[num][0] - coordinate[right][0]) + abs(coordinate[num][1] - coordinate[right][1])
            if dis_left < dis_right:
                ans += 'L'
                left = num
            elif dis_left > dis_right:
                ans += 'R'
                right = num
            else:
                if hand == 'left':
                    ans += 'L'
                    left = num
                elif hand == 'right':
                    ans += 'R'
                    right = num
        
    return ans