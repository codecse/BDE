input_file_path = "StockDataSet.txt"

with open(input_file_path, 'r') as file:
    for line in file:
        items = line.strip().split(",")
        if len(items) >= 8:
            stock_name = items[0]
            key = items[1]
            price = float(items[7])
            print stock_name + "," + key + " " + str(price)
