# Fail
def solution(str1, str2):
    answer = 65536
    
    s1_lst = []
    s2_lst = []
    for i in range(0,len(str1)-1):
        if str1[i:i+2].isalpha():
            s1_lst.append(str1[i:i+2].lower())
    for i in range(0,len(str2)-1):
        if str2[i:i+2].isalpha():
            s2_lst.append(str2[i:i+2].lower())

    # 합집합
    s1_tmp = s1_lst.copy()
    union = s1_lst.copy()
    for i in s2_lst:
        if i not in s1_tmp:
            union.append(i)
        else:
            s1_tmp.remove(i)
            
    # 교집합
    intersection = []
    for i in s2_lst:
        if i in s1_lst:
            intersection.append(i)
            s1_lst.remove(i)   
    
    if s1_lst or s2_lst:
        answer = int(len(intersection)/len(union)*65536)
        
    return answer