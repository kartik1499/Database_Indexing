# Database_Indexing
The goal of this project is to implement a program that parses an ASCII text-based CSV data file and then transforms that same information to a memory-efficient format and writes it to a binary data file. The new binary data file shall also have multiple index files for efficient record retrieval of values from fields other than the primary key. 
A CSV data file is attached: PHARMA_TRIALS_1000B.csv
The program transforms the data into binary file where fields are converted to the binary types indicated below.
•	The varchar field in the binary data file should be prefixed with a single byte that indicates the length of the string.
o	e.g. the string "GlaxoSmithKline LLC" should be converted to binary with the byte value 0x13 (i.e. "19", the length of the string) prefixed as a single byte.
o	Hexadecimal: 0x13 0x47 0x6c 0x61 0x78 0x6f 0x53 0x6d 0x69 0x74 0x68 0x4b 0x6c 0x69 0x6e 0x65 0x20 0x4c 0x4c 0x43
o	Chars: "<DC3>GlaxoSmithKline LLC", where <DC3> is the non-printable ASCII char 'device control 3'.
•	Note that the four boolean fields should all be stored in the same byte. The first four most significant bits should always be false (i.e. 0000, hexadecimal 0x0). The next four bits should store the boolean values of the four fields respectively, in order. For example: double_blind=true, controlled_study=true, govt_funded=false, and fda_approved=true would have the bits 00001101, which should be stored as the single byte 0x0d.
•	Therefore, record id=992 should take up a total 41 bytes = 4 + (1 + 19) + 6 + 2 + 2 + 2 + 4 + 1 in the binary file.
o	It uses 70 bytes (including the newline) in the CSV file).

