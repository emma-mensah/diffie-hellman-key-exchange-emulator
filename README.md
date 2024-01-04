# Diffie-Hellman Key Exchange Emulator

## Overview

This Java program emulates the Diffie-Hellman key exchange algorithm, a method for secure communication over an untrusted network. The program prompts the user to input two prime numbers (p and g), randomly generates secret keys (SA and SB), calculates public keys (TA and TB), and then computes a shared secret key.

## Usage

1. **Input Prime Numbers:**

    - Accepts two prime numbers, p and g, from the user.

2. **Generate Secret Keys:**

    - Randomly picks secret keys SA and SB.

3. **Calculate Public Keys:**

    - Utilizes fast exponential modular arithmetic to calculate public keys TA and TB.

4. **Calculate Shared Secret Key:**

    - Applies the same fast exponential modular arithmetic to determine a shared secret key.

5. **Output:**

    - Displays the calculated public keys (TA and TB) and the shared secret key.

## Example

A sample dialog is provided below:

```
Enter 2 prime numbers, p and g: 
23 5

Random number(SA): 74 Random number(SB): 65

TA: 4, TB: 2

Calculating Secret Key...

Secret Key: 16
```

## Notes

- The program generates random secret keys, calculates public keys, and computes the shared secret key using the Diffie-Hellman key exchange algorithm.
- It uses fast exponential modular arithmetic for efficient calculations.
- The shared secret key is computed by both parties and compared for consistency.
 
