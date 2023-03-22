public class Card implements Comparable<Object>{

    private String name;
    private String suit;
    private int rank;
    
    public Card(String n, String s, int r)
    {
       name = n;
       suit = s;
       rank = r;
    }

    public Card()
    {
       name = "default";
       suit = "default";
       rank = 0;
    }

    public void setName(String n){
        name = n;
    }

    public void setSuit(String s){
        suit = s;
    }

    public void setRank(int r) {
        rank = r;
    }

    public String getName() {
        return name;
    }

    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public boolean equals(Object obj) {
        Card c = (Card) obj;
        return (c.getName().equals(name) && c.getSuit().equals(suit) && c.getRank() == rank);
    }

    public int compareTo(Object obj) {
        Card c = (Card) obj;
        if(equals(obj)){
            return 0;
        }

        String suitOrder = "clubs spades hearts diamonds";
        if(suitOrder.indexOf(suit) < suitOrder.indexOf(c.getSuit())){
            return 1;
        }

        else if(suitOrder.indexOf(suit) > suitOrder.indexOf(c.getSuit())){
            return -1;
        }

        else if(rank > c.getRank()){
            return 1;
        }

        return -1;
    }   

    public String toString(){
        return "" + suit.substring(0,1) + name + "(" + rank + ")";
    }
}