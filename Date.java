// Class 1: The Date
public class Date extends Object{
    //instance field for month
    private int month;
    //instance field for day
    private int day;
    //instance field for year
    private int year;
    //constructor that takes three int values as input: a day, a month and a year,and it sets the date appropriately.
    public Date(int day, int month, int year){
    /*default seeting: the range of month is 1-12, the input of month that outside
    the range will be complie to the
    * closet month of the input*/
    if (daysPerMonth(month) == 0){
    if (month > 12){
    this.month = 12;
    }
    else{
    this.month = 1;
    }
    }
    else
    this.month = month;
    /*defaul setting, if the input day ouside the range of day in the month,
    compile to the closet day in the month*/
    if (day < 1){
    this.day = 1;
    }
    else if (day > daysPerMonth(this.month)){
    this.day = daysPerMonth(this.month);
    }
    else
    this.day = day;
    /*dedault setting: if the input year is surpast the range from 1800 to 2200,
    * complie to the closeest year in the range*/
    if (year < 1800){
    this.year = 1800;
    }
    else if (year > 2200){
    this.year = 2200;
    }
    else
    this.year = year;
    }
    // a class method that takes the month as input and return the maximum days of that month as output
    public static int daysPerMonth (int month){
    if ((month >= 1 ) && (month <= 12)){
    if(((month <= 7) && (month % 2 == 1)) || ((month >= 8) && (month % 2 == 0))){
    return 31;
    }
    else if ( month == 2){
    return 28;
    }
    else {
    return 30;
    }
    }
    else
    return 0;
    }
    /*method that compare the input date and this date, return true if the input date
    is greater than the this date
    * and this Date's day is the last day of the month.
    * return ture if the date are the same. */
    public boolean sameEffectiveDayAs (Date newDate){
    if (this.getDay() < newDate.getDay() && this.getDay() ==
    daysPerMonth(this.getMonth())){
    return true;
    }
    else if ((this.getYear() == newDate.getYear() && this.getMonth() ==
    newDate.getMonth()) && (this.getDay() == newDate.getDay())){
    return true;
    }
    else
    return false;
    }
    //method that sets this Date to be the next day of the year
    public void incrementDate(){
    if(this.getDay() == daysPerMonth(this.getMonth())){
    this.month = this.getMonth() + 1;
    this.day = 1;
    }
    else
    this.day = this.getDay() + 1;
    }
    /*override the method "equals()" that compare this date and input date
    * return true if two date had same month and same day nomatter what year*/
    @Override
    public boolean equals(Object object){
    // use instanceof (special command belongs to Java) to check whether we can do type cast of two type.
    if (object instanceof Date){
    Date d = (Date) object;
    return ((this.getMonth() == d.getMonth())&& this.getDay() == d.getDay());
    }
    else
    return false;
    }
    //override the method "ToString" to convert the date into string
    public String toString(){
    String month = "";
    if(this.getMonth() == 1){
    month = "January";
    }
    else if(this.getMonth() == 2){
    month = "February";
    }
    else if(this.getMonth() == 3){
    month = "March";
    }
    else if(this.getMonth() == 4){
    month = "April";
    }
    else if(this.getMonth() == 5){
    month = "May";
    }
    else if(this.getMonth() == 6){
    month = "June";
    }
    else if(this.getMonth() == 7){
    month = "July";
    }
    else if(this.getMonth() == 9){
    month = "September";
    }
    else if(this.getMonth() == 10){
    month = "October";
    }
    else if(this.getMonth() == 11){
    month = "November";
    }
    else{
    month = "December";
    }
    return "" + month + " " + this.getDay() + ", " + this.getYear();
    }
    //method that take no input and return the integer that represent month(rangebetween 1-12)
    public int getMonth(){
    return this.month;
    }
    //method that take no input and return the integer that represent day ofmonth(range between 1-31)
    public int getDay(){
    return this.day;
    }
    //method that no input and return the years of the date, years range between 1800to 2000
    public int getYear(){
    return this.year;
    }
    }
