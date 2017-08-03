
/**
 *
 * @author Lily
 *
 * Program takes a string that represents a person bowling score
 * and calculates the total number of points
 *
 * The string represent ten frames. Each frame is separated by  |
 * Frames and bonus balls are separated by ||
 * A player may receive 2, 1, or 0 bonus balls if they get a
 * strike, spare, or otherwise respectively
 *
 * Minimal value for a frame or bonus ball is is 0
 * Maximum value for a frame or bonus ball is 10
 *
 * X indicates a strike
 * / indicates a spare
 * - indicates a miss
 * A value from 1-9 represents the number of pins hit per ball
 *   when the frame is not a miss, strike, or spare
 * | indicates a frame boundary
 *
 *
 * ************* Scoring *************
 *
 * To calculate the score for each frame:
 *
 * If you get a strike, add 10 and the pins knocked down by the next
 *   two balls
 * If you get a spare, add 10 and the pins knocked down by the next ball
 * Otherwise add the number of pins knocked down in the current frame
 * The number of pins knocked down by the bonus balls are not added
 *   to the final score. They are used to calculated the score for the
 *   9th and 10th frame.
 */

public class Lab13 {

    final String BONUSBALLSEPARATOR = "\\|\\|";
    final String FRAMESEPARATOR = "\\|";

    /**
     * Calculate the final score of a bowling game
     * @param gameResult String that represents 10 frames and possibility
     *    2, 1, 0 bonus balls
     * @return score of the whole game
     */
    public int scoreGame (String gameResult){
        String [] framesAndBonusBalls = gameResult.split(BONUSBALLSEPARATOR, 2);
        String [] frames = framesAndBonusBalls[0].split(FRAMESEPARATOR);

        int [] frameScores = calculateAllFrameScore(gameResult);
        int score = 0;
        for (int i = 0; i < 10; i++){
            // Add the number of the pins knocked down
            // in the current frame
            score += frameScores[i];

            if (isSpare(frames[i])){
                // Add the number of pins knocked down by the next ball
                // to the total score
                if (i < 9) {
                    score += calculateFrameScore(frames[i+1].substring(0, 1));
                }

            }

            else if (isStrike(frames[i])){
                // Add the number of pins knocked down by the next two balls
                // AKA the next frame's score
                score += frameScores[i+1];

                // If the next frame is also a strike, only one
                // ball was rolled
                if (isStrike(frames[i+1])){
                    score += frameScores[i+2];
                }
            }
        }
        return score;
    }

    /**
     * Calculate the pins knocked down per frame
     * Considers each bonus ball to be an individual frame
     * @param gameResult String that represents 10 frames and possibility
     *    2, 1, 0 bonus balls
     * @return int array that contains the number of pin knocked down
     *    for each frame and bonus ball
     */
    private int [] calculateAllFrameScore(String gameResult){
        String [] framesAndBonusBalls = gameResult.split(BONUSBALLSEPARATOR, 2);
        String [] frames = framesAndBonusBalls[0].split(FRAMESEPARATOR);
        String bonusBalls = framesAndBonusBalls[1];

        int [] frameScores = new int [12];
        for(int i = 0; i < 10; i++){
            frameScores[i] = calculateFrameScore(frames[i]);
        }
        if(bonusBalls.length() > 0){
            frameScores[10] = calculateFrameScore(bonusBalls.substring(0,1));
        }
        if (bonusBalls.length() == 2){
            frameScores[11] = calculateFrameScore(bonusBalls.substring(1));
        }
        return frameScores;
    }

    /**
     * Takes an individual frame or ball and calculate how many pins
     * are knocked down by matching the frame with regular expressions
     * @param frame String that represents are single frame or bonus
     *    ball
     * @return 0 to 10 pins knocked down
     */
    private int calculateFrameScore(String frame){
        String STRIKE = "X";
        String HITANDMISS = "[1-9]-?";
        String MISSANDHIT = "-[1-9]";
        String SPARE = "[1-9]/|-/";
        String HITANDHIT = "[1-9]{2}";

        if(frame.equals(STRIKE)){
            return 10;
        }
        if(frame.matches(HITANDMISS)){
            return Character.getNumericValue(frame.charAt(0));
        }
        if(frame.matches(MISSANDHIT)){
            return Character.getNumericValue(frame.charAt(1));
        }
        if(frame.matches(SPARE)){
            return 10;
        }
        if(frame.matches(HITANDHIT)){
            return Character.getNumericValue(frame.charAt(0)) +
                    Character.getNumericValue(frame.charAt(1));
        }

        return 0;
    }

    /**
     * Check to see if a frame is a strike
     * @param frame String that represents a frame
     * @return true if the player rolled a strike
     *    false otherwise
     */
    private boolean isStrike(String frame){
        String STRIKE = "X";
        if(frame.equals(STRIKE)){
            return true;
        }
        return false;
    }

    /**
     * Check to see if the frame is a spare
     * @param frame String that represents a frame
     * @return true if the player rolled a spare
     *    false otherwise
     */
    private boolean isSpare(String frame){
        String SPARE = "[1-9]/|-/";
        if(frame.matches(SPARE)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Lab13 game = new Lab13();
        int result = game.scoreGame("18|X|54|9/|81|X|-8|7-|X|43||");
        System.out.println("Final Score: " + result);

        result = game.scoreGame("X|X|X|X|X|X|X|X|X|X||XX");
        System.out.println("Final Score: " + result);

    }
}