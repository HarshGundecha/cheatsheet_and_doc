- [JWT](#jwt)
  - [Intro](#intro)
  - [What does it contain](#what-does-it-contain)
    - [Header](#header)
    - [Payload](#payload)
    - [Signature](#signature)
- [Creation of JWT](#creation-of-jwt)
- [References](#references)

# JWT

## Intro
- JWT is about authorization and not authentication
- JWT consists of 3 parts 
- thats why the token itself is seperated by . in 3 parts

## What does it contain

### Header
    - consist of 
      - token type
      - algorithm used
### Payload
    - depending upon configuration could contain anything
    - usually contains usernames or similar things
### Signature
    - built by server using the algorith specified in header and a secret stored on server

# Creation of JWT
- the 1st 2 parts are just base64 encoded version of their original content
- which means you can essentially decode the first 2 parts and get the plain text out of it, but the thing is it doesnt contain any top secret
- the server takes the 1st two parts alongwith secret and uses alogirithm defined in 1st part to generates the signature
- that signature is what the third part is all about
- so when the user uses that token to request something, the server again computes signature from the 1st two parts and matches the computed signature with the signature in token
- 

# References
- [What is JWT authorization really about - Java Brains
](https://youtu.be/soGRyl9ztjI)
- [What is the structure of a JWT - Java Brains](https://youtu.be/_XbXkVdoG_0)
- [jwt.io - play with JWT](jwt.io)