using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using UglyTrivia;

namespace Trivia
{
    public class GameRunner
    {

        private static bool notAWinner;

        public static void Main(String[] args)
        {
            Game aGame = new Game();

            aGame.add("Chet");
            aGame.add("Pat");
            aGame.add("Sue");

            Random rand = new Random();

            do
            {

                aGame.roll(rand.Next(5) + 1);

                if (rand.Next(9) == 7)
                {
                    notAWinner = aGame.wrongAnswer();
                }
                else
                {
                    notAWinner = aGame.wasCorrectlyAnswered();
                }



            } while (notAWinner);

        }

        public static void Run(Game game, Random random)
        {
            do
            {
                game.roll(random.Next(5) + 1);

                if (random.Next(9) == 7)
                {
                    notAWinner = game.wrongAnswer();
                }
                else
                {
                    notAWinner = game.wasCorrectlyAnswered();
                }
            } while (notAWinner);
        }


    }

}

