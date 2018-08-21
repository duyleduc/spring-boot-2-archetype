****Description****

This is a maven archetype for spring boot 2 using reactive programming.
The initialization comes with spring boot security and authorization method using jwt token. 
The others libs using:
- lombok
- mapstruct
- devtools
- jsonwebtoken
- Mongodb
- mongobee
 
 ****How to use it****
 - Clone this project 
 - Rename the group id and artifact id
 - Rename your package
 - Change git config url 
 
 
 ****Others remarks****
 ***Configuration***
 - Jackson configuration
 - Security configuration 
 - Mongodb initialization
 
 ***Jwt controller***
 POST /authorize
 - Body    
 `{
    "username": "admin",
    "password: "password"
  }`   
  - Response:   
  `{
       "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTUzMzc2MjM0M30.O_pUCQFWUGk9hOn-kSegjr5jHUK5rvYpHj-DRKQeEYdjp16Tu9L6yUfzesECEV9KUQDSC-SMQ5EVZ-PiqA6kFQ"
   }`