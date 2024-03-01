input_file_path = "StockDataSet.txt"
output_file_path = "output.txt"

input_file = open(input_file_path, 'r')
output_file = open(output_file_path, 'w')

try:
    for line in input_file:
        items = line.strip().split(",")
        if len(items) >= 8:
            stock_name = items[0]
            key = items[1]
            price = float(items[7])
            output_file.write("{0} {1} {2}\n".format(stock_name, key, price))
            print("{0} {1} {2}".format(stock_name, key, price))
finally:
    input_file.close()
    output_file.close()
