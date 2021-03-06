# RockPaperScissors
**A game of Rock Paper Scissors between two computers in Java.**

## Description

The exercise is about the implementation of the  game “Rock-Paper-Scissors” (https://en.wikipedia.org/wiki/Rock%E2%80%93paper%E2%80%93scissors) in Java. 

After the start of program two players (“A” and “B”) play 100 rounds of the game and the end result is printed on the console (numbers of won/lost games, number of ties). 

Both players are controlled by the program, no user input is necessary after the start of the program. 
Player “A” chooses a random symbol in every round, while player “B” consistently chooses “Paper”.

## Installation

- Download and unzip the archive file

- Or type on the command shell 

  ```
  git clone https://github.com/jdayssol/RockPaperScissors 
  ```

## How to run the program
- Type on the command shell 

  ```
  java -jar RockPaperScissors.jar
  ```

- Or in a IDE select Run as -> Java application

## Technical stack
- Created with Maven.
- Using Junit for the test.
- Version control with Git on my GitHub account https://github.com/jdayssol/RockPaperScissors.

## Technical xplanation of the program
- Motion is an enumeration which proposes 3 moves: rock/paper/scissors. It also provides a function to return the result of the game between two motions.
- Interface Strategy provides a function that will return the next Motion. Since Strategy is an interface, you can create a lot of strategies using this interface without modifying the rest of the program.
- Class Player provides attributes name and strategy. 
- Class Game has a start function which launches the game between the two players a parameterized number of times. 

## Extra features
- A menu so you can easily re-run the program and configure the game.
- A user input strategy.