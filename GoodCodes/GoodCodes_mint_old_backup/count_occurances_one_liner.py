l = [1, 2, 2, 3, 3, 3, 4]
d = {}
[ d.update( {i:d.get(i, 0)+1} ) for i in l ]
print(d)