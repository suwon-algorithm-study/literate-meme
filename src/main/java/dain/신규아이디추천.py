def solution(new_id):
    
    #1
    new_id = new_id.lower()
    
    #2
    s = {'-','_','.'}
    for i in new_id:
        if i.isalpha() or i.isdigit() or i in s:
            continue
        else:
            new_id = new_id.replace(i,"")
    
    #3
    while '..' in new_id:
        new_id = new_id.replace('..','.')
        
    #4
    new_id = new_id.strip('.')
    
    #5
    if not new_id:
        new_id += 'a'
        
    #6
    if len(new_id) >= 16:
        new_id = new_id[:15]
    new_id = new_id.rstrip('.')
    
    #7
    while len(new_id) <= 2:
        new_id += new_id[-1]
        
    answer = new_id
    return answer