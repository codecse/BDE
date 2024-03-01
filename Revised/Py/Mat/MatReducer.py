def multiply_matrices(a, b):
    m = len(a)
    n = len(b[0])
    p = len(b)
    result = [[0] * n for _ in range(m)]

    for i in range(m):
        for j in range(n):
            for k in range(p):
                result[i][j] += a[i][k] * b[k][j]

    return result

def print_matrix(matrix):
    for row in matrix:
        print " ".join(map(str, row))

if __name__ == "__main__":
    matrix1 = [[0] * 3 for _ in range(2)]
    matrix2 = [[0] * 2 for _ in range(3)]

    try:
        with open("output.txt", "r") as reader:
            for line in reader:
                parts = line.strip().split(",")
                if parts[0] == "M":
                    i, j, value = map(int, parts[1:])
                    matrix1[i][j] = value
                elif parts[0] == "N":
                    i, j, value = map(int, parts[1:])
                    matrix2[i][j] = value

        result = multiply_matrices(matrix1, matrix2)
        print_matrix(result)
    except IOError as e:
        print "Error reading from output.txt:", e

