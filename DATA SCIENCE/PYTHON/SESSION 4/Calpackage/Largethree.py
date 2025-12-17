def maximum_two(a,b):
     return a if a>b else b

def maximu_three (a,b,c):
     return maximum_two(a, maximum_two(b,c))