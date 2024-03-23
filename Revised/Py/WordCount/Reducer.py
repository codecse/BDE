prev_word = None
prev_count = 0

input_file_path = "mapper_output.txt"

with open(input_file_path, "r") as input_file:
    for line in input_file:
        line = line.strip()
        word, count = line.split('\t')
        count = int(count)

        if prev_word == word:
            prev_count += count
        else:
            if prev_word:
                print('%s\t%s' % (prev_word, prev_count))
            prev_count = count
            prev_word = word

    # Print the final word count outside of the loop
    if prev_word:
        print('%s\t%s' % (prev_word, prev_count))

