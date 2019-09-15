# Cryptography
## Definitions
- ### cryptography - art of converting meaningful(plaintext) text to meaningless(ciphertext) text
- ### cryptanalysis - breaking cryptographic code
- ### cryptology = cryptolgraphy + cryptanalysis
- ### encryption - the process of disguising plaintext
- ### decryption - the process of reverting ciphertext to its original plaintext
- ### weak cryptography - given a message m1 it is computationally infeasible to find m2 such that m1!=m2 and h(m1)==h(m2)
- ### strong cryptography - it is computationally infeasible to find any pair of m1 and m2 such that m1!=m2 and h(m1)==h(m2), (strong ryptography implies weak but reverse is not true)


## what is cryptography - art of converting meaningful(plaintext) text to meaningless(ciphertext) text
## important components
- plain text
- key
- ciphertext


## selecting key
- sufficiently large enough to avoid brute-force attack
- for example 10bit key of binary requires 2^10 attempts to guess correct key


## types of cryptogrpahy
- ### symmetric(same key) - uses single key for encryption/decryption
  - substitution based - map each character with some other character
  - permutation based - rearrange the characters of plaintext
- ### asymmetric (private, public key) - uses defferent keys for encryption/decryption

## ciphers
-	shift/ceaser cipher
	- shift each character by N places
	- encrypt = (m+k)%26
	- decrypt = (m-k)%26
- vernam cipher
  - choose a key of message length
  - add each character of message and key and % 26 and get character from it
  - for example message = ab, key = cf, 1+3 2+6 = 48 = dh(cipher)
- 
# doubts
- coditional cryptography
- unconditional cryptography

