## Bit-Functions
- [ClearBit](#ClearBit): Clears (sets to 0) specific bits in a number
- [ExtractBit](#ExtractBit): Extracts a range of bits from a number
- [InvertBit](#InvertBit): Inverts (flips) specific bits in a number
- [SetBit](#SetBit): Sets (sets to 1) specific bits in a number
- [TestBit](#TestBit): Tests if a specific bit is set in a number

### ClearBit
    Syntax: ClearBit(x, pos, ...)
Clears the bit of x at all given positions

    ClearBit(0b111, 2) => 0b101

### ExtractBit
    Syntax: ExtractBit(x, start, end)
Extracts bits from x starting at position 'start' and ending at position 'end' (inclusive). The extracted bits are returned as a new number. If end >= start, bits are extracted in ascending order. If end < start, bits are extracted in descending order (reversing the bits).

    ExtractBit(0b1101, 0, 2) => 0b101
    ExtractBit(0b1101, 2, 0) => 0b101
    ExtractBit(0b1101, 1, 3) => 0b110

### InvertBit
    Syntax: InvertBit(x, pos, ...)
Inverts (flips) the bit of x at all given positions. If the bit is 0, it becomes 1, and if it's 1, it becomes 0.

    InvertBit(0b1010, 0) => 0b1011
    InvertBit(0b1010, 1, 3) => 0b0110

### SetBit
    Syntax: SetBit(x, pos, ...)
Sets the bit of x at all given positions

    SetBit(0, 1) => 0b10
    SetBit(0, 1, 3) => 0b1010

### TestBit
    Syntax: TestBit(x, pos)
Tests the bit of x at the given position

    TestBit(0b111, 2) => true
    TestBit(0b111, 5) => false
