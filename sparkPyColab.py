!pip install pyspark

from pyspark import SparkContext

# Create a Spark context
sc = SparkContext()

# Create RDD from python list
lst = range(5, 20)
list_rdd1 = sc.parallelize(lst, 3)

# Copy RDD
rdd2 = list_rdd1

# Read from a file
# r3 = sc.textFile('/user/cloudera/mr/file1')
rdd1 = sc.textFile('file1.txt')

# Actions and Transformations
# Actions: first(), take(n), collect(), count(), reduce(func), takeOrdered(n, [ordering])
print("First element:", list_rdd1.first())
print("First 3 elements:", list_rdd1.take(3))
print("All elements:", rdd2.collect())
print("Count:", rdd2.count())
x = rdd2.reduce(lambda i, j: i + j)
print("Reduced value:", x)

# Transformations: distinct(), filter(func), map(func), flatMap(func), union(otherDataset), intersection(otherDataset), groupByKey([numTasks]), reduceByKey(func, [numTasks]), join(otherDataset, [numTasks]), cartesian(otherDataset)
lst = [('modi', 'pm'), ('Babu', 'cm'), ('Naidu', 'vp'), ('kcr', 'cm'), ('narasimham', 'governor'),
       ('uma', 'minister'), ('ktr', 'minister'), ('Babu', 'cm'), ('narasimham', 'governor')]
rdd_lst = sc.parallelize(lst)

# Distinct
distinct_rddlist = rdd_lst.distinct()
print("Distinct elements:", distinct_rddlist.collect())

# Filter
filter_rddlist = rdd_lst.filter(lambda element: element[1] == 'cm')
print("Filtered elements:", filter_rddlist.collect())

# Map
map_rddlist = rdd_lst.map(lambda x: (x[1], x[0]))
print("Mapped elements:", map_rddlist.collect())

# SortByKey
sortbykey_rdd = map_rddlist.sortByKey()
print("Sorted by key:", sortbykey_rdd.collect())

# GroupByKey
groupbykey_rdd = map_rddlist.groupByKey()
print("Grouped by key:")
for x in groupbykey_rdd.collect():
    print(x[0], list(x[1]))

# ReduceByKey
reducebykey_rdd = map_rddlist.reduceByKey(lambda x, y: x + y)
print("Reduced by key:", reducebykey_rdd.collect())

# FlatMap
rdd1 = sc.parallelize(range(5, 10))
flatmap_rdd3 = rdd1.flatMap(lambda i: (i, i + 5, i * 5))
print("FlatMap result:", flatmap_rdd3.collect())

# TakeOrdered
print("TakeOrdered (asc):", flatmap_rdd3.takeOrdered(7))
print("TakeOrdered (desc):", flatmap_rdd3.takeOrdered(flatmap_rdd3.count(), lambda x: -x))

# Union and Intersection
rdd2 = sc.parallelize(range(8, 15))
rddunion = rdd1.union(rdd2)
print("Union:", rddunion.collect())

rddintersection = rdd1.intersection(rdd2)
print("Intersection:", rddintersection.collect())

# Cartesian
rddcartesian = rdd1.cartesian(rdd2)
print("Cartesian:", rddcartesian.collect())

# JOIN
rdd1 = sc.parallelize([(1, 8.5), (2, 7.7), (3, 9), (5, 6.5)])
rdd2 = sc.parallelize([(1, 'cse'), (3, 'ece'), (4, 'me'), (5, 'eee')])

rddjoin = rdd1.join(rdd2)
print("JOIN result:", rddjoin.collect())

rddleftouter = rdd1.leftOuterJoin(rdd2)
print("Left Outer JOIN result:", rddleftouter.collect())

rddrightouter = rdd1.rightOuterJoin(rdd2)
print("Right Outer JOIN result:", rddrightouter.collect())

rddfullouter = rdd1.fullOuterJoin(rdd2)
print("Full Outer JOIN result:", rddfullouter.collect())

# Word Count Example
# x = sc.textFile("/user/cloudera/wc")
x = sc.textFile("file2.txt")
a = x.flatMap(lambda line: line.split(" "))
b = a.map(lambda word: (word, 1))
c = b.reduceByKey(lambda a, b: a + b)
# c.saveAsTextFile("/user/cloudera/output")

# Stop Spark Context
sc.stop()
