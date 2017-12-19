# Dice-Game
This is the DiceGame. The purpose of this project is to apply what I have learned about coupling and cohesion 
to a simulation of a DiceGame application. To start playing the game type the command: 
java -jar (Copy the DiceGame.jar file and paste it here). The next step is to type either “Dialog” or “c” for 
the user’s choice of whether to play using a dialog pop up’s, or typing in the console. Press enter/return to 
begin the game. Follow along with the prompts and enjoy the DiceGame! 

Description:
The user begins the DiceGame with a set amount of tokens(100) that they can use to bet on what the dice will 
roll. The betting amount for each round played is 10 tokens. If the user rolls a 2,3, or 12 the user looses and
does not get back the tokens they bet. If they player rolls a 7 or 11 they win, and 20 tokens will be returned to 
the the user. If any other number is rolled, that number is now referred to as the point. Once a point is set, if 
the user rolls a 7, they loose the round along with the 10 tokens originally bet. If the user rolls the point, 
they win and receive 20 tokens. Otherwise the dice will be re-rolled until either a 7 or a point is matched. Once 
the round has ended, they player will be asked if they like to play another round.
