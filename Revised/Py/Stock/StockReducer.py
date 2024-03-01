filename = "output.txt"
max_close_prices = {}

with open(filename, 'r') as file:
    for line in file:
        parts = line.strip().split(" ")

        if len(parts) >= 3:
            key = parts[0] + "," + parts[1]
            try:
                close_price = float(parts[2])
            except ValueError:
                # Handle non-float values gracefully
                continue

            if key not in max_close_prices or close_price > max_close_prices[key]:
                max_close_prices[key] = close_price

for key, value in max_close_prices.iteritems():
    print key + "\t" + str(value)
