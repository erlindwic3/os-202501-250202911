import time

data = []
print("Start compute & allocate")

for i in range(10_000_000):
    if i % 1_000_000 == 0:
        print("i =", i)
    data.append(i)

print("Done")
time.sleep(2)
