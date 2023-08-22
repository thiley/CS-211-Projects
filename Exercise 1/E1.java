class E1
{
    public static void main(String[] args)
    {
        // e.g. C:\> java E1 34 2 50
        
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        System.out.println(calculate(a,b,c));
            
    }
    public static int calculate(int card1, int card2, int card3)
    {
        // checks the suit of each card
        String c1suit = "";
        String c2suit = "";
        String c3suit = "";
        if (card1 >= 1 && card1 <= 13){
            c1suit = "clubs";
        }
        else if (card1 >= 14 && card1 <= 26){
            c1suit = "diamonds";
        }
        else if (card1 >= 27 && card1 <= 39){
            c1suit = "hearts";
        }
        else if (card1 >= 40 && card1 <= 52){
            c1suit = "spades";
        }
        else{
            c1suit = "invalid";
        }
        if (card2 >= 1 && card2 <= 13){
            c2suit = "clubs";
        }
        else if (card2 >= 14 && card2 <= 26){
            c2suit = "diamonds";
        }
        else if (card2 >= 27 && card2 <= 39){
            c2suit = "hearts";
        }
        else if (card2 >= 40 && card2 <= 52){
            c2suit = "spades";
        }
        else{
            c2suit = "invalid";
        }
        if (card3 >= 1 && card3 <= 13){
            c3suit = "clubs";
        }
        else if (card3 >= 14 && card3 <= 26){
            c3suit = "diamonds";
        }
        else if (card3 >= 27 && card3 <= 39){
            c3suit = "hearts";
        }
        else if (card3 >= 40 && card3 <= 52){
            c3suit = "spades";
        }
        else{
            c3suit = "invalid";
        }

        // gets the number of each card
        int c1;
        int c2;
        int c3;

        if (card1 >=1 && card1 <=13){
            c1 = card1;
        }
        else if (card1 > 13 && card1 <= 52){
            c1 = card1 % 13;
        }
        else{
            c1 = 0;
        }
        if (card2 >=1 && card2 <=13){
            c2 = card2;
        }
        else if (card2 > 13 && card2 <= 52){
            c2 = card2 % 13;
        }
        else{
            c2 = 0;
        }
        if (card3 >=1 && card3 <=13){
            c3 = card3;
        }
        else if (card3 > 13 && card3 <= 52){
            c3 = card3 % 13;
        }
        else{
            c3 = 0;
        }
        
        // orders the cards in ascending order
        if ((c1 > c2 && c1 > c3) && c2 > c3){
            card1 = c1;
            card2 = c2;
            card3 = c3;
        }
        else if ((c1 > c2 && c1 > c3) && c3 > c2){
            card1 = c1;
            card2 = c3;
            card3 = c2;
        }
        else if ((c2 > c1 && c2 > c3) && c1 > c3){
            card1 = c2;
            card2 = c1;
            card3 = c3;
        }
        else if ((c2 > c1 && c2 > c3) && c3 > c1){
            card1 = c2;
            card2 = c3;
            card3 = c1;
        }
        else if ((c3 > c1 && c3 > c2) && c1 > c2){
            card1 = c3;
            card2 = c1;
            card3 = c2;
        }
        else if ((c3 > c1 && c3 > c2) && c2 > c1){
            card1 = c3;
            card2 = c2;
            card3 = c1;
        }

        if (c1suit.equals("invalid") || c2suit.equals("invalid") || c3suit.equals("invalid") || card1 == 0 || card2 == 0 || card3 == 0){
            return 0;
        }
        else if((c1suit == c2suit) && (c1suit == c3suit) && (c2suit == c3suit)){
            if ((card1 - 1 == card2) && (card2 - 1 == card3)){ // straight flush
                return 10;
            }
            else{ // flush
                return 5;
            }
        }
        else if ((c1 == c2) && (c1 == c3) && (c2 == c3)){ // three of a kind
            return 8;
        }
        else if ((card1 - 1 == card2) && (card2 - 1 == card3)){ // straight
            return 7;
        }
        else if ((c1 == c2) || (c2 == c3) || (c1 == c3)){ // pair
            return 3;
        }
        else{ // high card
            return 1;
        }
    }
}