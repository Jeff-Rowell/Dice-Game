# Dice-Game
This is the DiceGame. The purpose of this project is to apply what I have learned about coupling and cohesion 
to a simulation of a DiceGame application. To start playing the game type the command: 
java -jar (Copy the DiceGame.jar file and paste it here). The next step is to type either “d” or “c” for 
the user’s choice of whether to play using dialog pop up’s, or typing in the console. Press enter/return to 
begin the game. Follow along with the prompts and enjoy the DiceGame! 

**Description:**

The user begins the DiceGame with a set amount of tokens(100) that they can use to bet on what the dice will 
roll. The betting amount for each round played is 10 tokens. If the user rolls a 2,3, or 12 the user looses and
does not get back the tokens they bet. If they player rolls a 7 or 11 they win, and 20 tokens will be returned to 
the the user. If any other number is rolled, that number is now referred to as the point. Once a point is set, if 
the user rolls a 7, they loose the round along with the 10 tokens originally bet. If the user rolls the point, 
they win and receive 20 tokens. Otherwise the dice will be re-rolled until either a 7 or a point is matched. Once 
the round has ended, they player will be asked if they like to play another round.

Here is an example of running the dice game using the dialogue user interface. As we can see we can either run the 
.jar file directly, or we can compile and run the program from source as I am doing below. Both result in the 
same functionality.

First I went ahead and compiled the program from source then followed that up by running it. First the game will 
prompt the user with a welcome message informing them the cost of the game and the initial size of their bank.

<img width="1128" alt="1" src="https://user-images.githubusercontent.com/32188816/52236154-4d0c7680-2883-11e9-9144-a75832e6b5e0.png">

After that the game displays a message as it begins rolling the dice.

<img width="1121" alt="2" src="https://user-images.githubusercontent.com/32188816/52236233-80e79c00-2883-11e9-968f-072775bb2bf0.png">

Once the dice have been rolled using the random number generator, the game will display the outcome and check that
result against the rules of generic table crabs. Here since I did not roll a winning number, a point was set and I 
must match that point in order to win, otherwise I loose. 

<img width="1124" alt="3" src="https://user-images.githubusercontent.com/32188816/52236309-b5f3ee80-2883-11e9-98a3-d2c175ceb771.png">

As we can see above the point to set is 8. Here are the rolls that I took until I either won or lost.

<img width="1124" alt="4" src="https://user-images.githubusercontent.com/32188816/52236358-e3409c80-2883-11e9-9a47-064b178efada.png">
<img width="1120" alt="5" src="https://user-images.githubusercontent.com/32188816/52236359-e3409c80-2883-11e9-9e4e-dd250db8c48b.png">

Since I rolled a 7 that is now a loosing number since I have a point set, so I loose the game and reduced 10 tokens... After
that I quit the game, and the program will print a corresponding exit message that displays the grand total number of tokens
that the user leaves the game with.

<img width="1121" alt="6" src="https://user-images.githubusercontent.com/32188816/52236418-0703e280-2884-11e9-9bb9-a26c4ae860b4.png">
<img width="1125" alt="7" src="https://user-images.githubusercontent.com/32188816/52236419-0703e280-2884-11e9-897c-c49a2ba7db14.png">

Similarly, here is the game run once again only this time using the console interface and not the dialogue interface.
Notice that this time I pass in a command line argument of "c" rather than "d" to specify that I want the console
interface.

<img width="444" alt="screen shot 2019-02-04 at 1 43 14 pm" src="https://user-images.githubusercontent.com/32188816/52236487-3d416200-2884-11e9-83dd-1856fd07ac42.png">
