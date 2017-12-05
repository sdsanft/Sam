def ProjectEuler1(a=1,b=1000,c=[3,5]):
    #Find the sum of all the multiples of 3 or 5 below 1000.
    x = 0
    for m in range(a,b):
        for n in range(0,len(c)):
            if (m % c[n] == 0):
                x += m
                break
    return x

print(ProjectEuler1(1,1000,[3,5]))
