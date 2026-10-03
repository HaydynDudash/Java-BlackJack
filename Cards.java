public class Cards {
    private int realValue;
    private String shownValue;
    private String suite;
//cards constructor
    public Cards (int realValue, String shownValue, String suite){
        this.realValue = realValue;
        this.shownValue = shownValue;
        this.suite  = suite;
    }
    //getters and setters
    public int getRealValue(){
        return realValue;
    }
    public void setRealValue(int realValue){
        this.realValue = realValue;
    }
    public String getShownValue(){
        return shownValue;
    }
    public void setShownValue(String shownValue){
        this.shownValue = shownValue;
    }
    public String getSuite(){
        return suite;
    }
    public void setSuite(String suite){
        this.suite = suite;
    }

}
