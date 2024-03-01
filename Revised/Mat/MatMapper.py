def write_matrix_to_file(writer, matrix_name, matrix):
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            writer.write("%s,%d,%d,%d\n" % (matrix_name, i, j, matrix[i][j]))

if __name__ == "__main__":
    matrix1 = [[1, 3, 3], [5, 5, 6]]
    matrix2 = [[1, 2], [3, 4], [5, 6]]

    try:
        with open("output.txt", "w") as file_writer:
            for matrix, name in [(matrix1, "M"), (matrix2, "N")]:
                write_matrix_to_file(file_writer, name, matrix)
        print("Output written to output.txt successfully.")
    except IOError as e:
        print("Error writing to output.txt:", e)

