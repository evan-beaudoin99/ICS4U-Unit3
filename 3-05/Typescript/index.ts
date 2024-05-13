/**
* This is the magic square program.
*
* By:      Evan Beaudoin
* Version: 1.0
* Since:   2024-05-12
*/ 

const SIZE: number = 3; // Size of the magic square (3x3)
const MAGIC_CONSTANT: number = 15; // Sum of numbers from 1 to 9 for 3x3 matrix


/*
 * Generates a random magic square of size 3x3.
 */
function generateMagicSquare(): number[][] {
    const numbers: number[] = [];
    for (let i = 1; i <= SIZE * SIZE; i++) {
        numbers.push(i);
    }
    shuffle(numbers);

    const square: number[][] = new Array(SIZE).fill([]).map(() => new Array(SIZE).fill(0));
    let index = 0;
    for (let i = 0; i < SIZE; i++) {
        for (let j = 0; j < SIZE; j++) {
            square[i][j] = numbers[index++]; // Add the numbers to the square
        }
    }
    return square;
}

/**
 * Since there is no built-in function that shuffles
 * the array like in Java here the function in typescript .
 */
function shuffle(array: any[]): void {
    for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
    }
}

/*
 * Checks if the given 2D array represents a magic square.
 */
function isMagicSquare(square: number[][]): boolean {
    // Check rows and columns sums
    for (let i = 0; i < SIZE; i++) {
        let rowSum = 0;
        let columnSum = 0;
        for (let j = 0; j < SIZE; j++) {
            rowSum += square[i][j];
            columnSum += square[j][i];
        }
        if (rowSum !== MAGIC_CONSTANT || columnSum !== MAGIC_CONSTANT) {
            return false;
        }
    }

    // Check diagonal sums
    let diagonal1Sum = 0;
    let diagonal2Sum = 0;
    for (let i = 0; i < SIZE; i++) {
        diagonal1Sum += square[i][i];
        diagonal2Sum += square[i][SIZE - 1 - i];
    }
    return diagonal1Sum === MAGIC_CONSTANT && diagonal2Sum === MAGIC_CONSTANT;
}

/*
 * Checks if the list of generated magic squares contains the given magic square.
 */
function containsMagicSquare(squares: number[][][], square: number[][]): boolean {
    for (const testSquare of squares) {
        if (areSquaresEqual(testSquare, square)) {
            return true;
        }
    }
    return false;
}

/*
 * Checks if two magic squares are equal.
 */
function areSquaresEqual(square1: number[][], square2: number[][]): boolean {
    for (let i = 0; i < SIZE; i++) {
        for (let j = 0; j < SIZE; j++) {
            if (square1[i][j] !== square2[i][j]) {
                return false;
            }
        }
    }
    return true;
}

/**
 * Prints the given magic square along with its index.
 */
function printMagicSquare(square: number[][], count: number): void {
    console.log(`Magic Square ${count}:`);
    for (let i = 0; i < SIZE; i++) {
        console.log(square[i].join(" "));
    }
    console.log();
}

/**
 * Main method to generate and print unique magic squares.
 */
const magicSquareCount: number = 8; // Number of magic squares to generate
const generatedMagicSquares: number[][][] = [];

// Loop to generate magic squares
for (let count = 0; count < magicSquareCount; count++) {
    while (true) {
        const square: number[][] = generateMagicSquare();
        if (isMagicSquare(square) && !containsMagicSquare(generatedMagicSquares, square)) {
            printMagicSquare(square, count + 1);
            generatedMagicSquares.push(square);
            break;
        }
    }

}
console.log("Done")


