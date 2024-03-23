# -*- coding: utf-8 -*-

input_file_path = "input.txt"
output_file_path = "mapper_output.txt"

with open(input_file_path, "r") as input_file:
    with open(output_file_path, "w") as output_file:
        for line in input_file:
            line = line.strip()
            words = line.split()
            for word in words:
                output_file.write('%s\t%s\n' % (word, 1))
print("output of Mapper.py stored in 'mapper_output.txt'")

