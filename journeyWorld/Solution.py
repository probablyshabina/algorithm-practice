
fuel = 0
cities = 0

firstLine = input().rstrip().split()
cities = int(firstLine[0])
fuel = int(firstLine[1])


if(cities >= 2 and cities <= 1000000):
    if(fuel >= 1 and fuel <= 10,000,000,000,000,000,000):
        print()

startFuel = list(map(int,input().rstrip().split()))
usingFuel = list(map(int,input().rstrip().split()))

balanceFuel = [] 
for n in range(cities):
    seq = list()
    for y in range(n, cities + n):
        x = y % cities
        if(x - 1 >= n):
            seq.append(startFuel[x] - usingFuel[x] + seq[len(seq) - 1])
        else:
            seq.append(startFuel[x] - usingFuel[x])
    balanceFuel.insert(n, seq)

passableCities = []
for n1 in range(len(balanceFuel)):
    passableCities.insert(n1, 0)
    for n2 in range(len(balanceFuel[n1])):
        if(balanceFuel[n1][n2] > 0):
            passableCities[n1] += 1
        elif(balanceFuel[n1][n2] == 0):
            if(n2 - 1 >= 0 and balanceFuel[n1][n2 - 1] != 0):
                passableCities[n1] += 1

passableCities.sort(reverse=True)
print(passableCities[0])


