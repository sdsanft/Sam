import math
def ProjectEuler3(p=600851475143):
    #What is the largest prime factor of the number 600851475143?
    x = p
    factors = []
    primes = []
    skip = (p % 2) + 1
    for i in range(1,int(math.sqrt(x)),skip):
        if p % i == 0:
            factors.append(i)
    for i in range(0, len(factors)):
        x /= factors[i]
        primes.append(factors[i])
        if (x == 1):
            break
        elif (x < 1):
            primes = "Error, please try again"
            break
    return primes


print(ProjectEuler3())
