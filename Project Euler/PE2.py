def ProjectEuler2(a = 1, b = 2, c = 4000000, d = 2):
    #By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
    f1 = a
    f2 = b
    f3 = 0
    z = 0
    while ((f1 < c) and (f2 < c)):
        if (f2 % 2 == 0):
            z += f2
        f3 = f1 + f2
        f1 = f2
        f2 = f3
    return z

print(ProjectEuler2())
        
