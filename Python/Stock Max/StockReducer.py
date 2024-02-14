fileName = "StockDataSet.txt"
maxClosePrices = {}

with open(fileName, 'r') as file:
    for line in file:
        parts = line.strip().split(",")
        key = parts[0] + "," + parts[1]
        closePrice = float(parts[7])

        if key not in maxClosePrices or closePrice > maxClosePrices[key]:
            maxClosePrices[key] = closePrice

for key, value in maxClosePrices.iteritems():
    print key + "\t" + str(value)
