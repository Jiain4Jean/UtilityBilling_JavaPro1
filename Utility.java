//The Utility Class
 public class Utility extends Object{
  //instance field for Utility rate
  private double utilityRate;
  //instance field for Month usage
  private int monthUsage;
  //instance field for store year usage
  private int yearUsage;
  //instance field for month bill
  private double monthBill;
  //instance field for account balance
  private double balance;
  //instance field for amount paid for the montn
  private double amountPaid;
  //instance field for amount delinquent 
  private double amountDelinquent;
  //instance field for salse tax rate
  private double salesTaxRate;
  //instance field for interest rate
  private double interestRate;
  //instance field for aniversaryDate
  private Date anniversaryDate;
  /*constructor that takes the utility rate and the aniversary date as input  
   * and sets the fields of the utility appropriately.*/
  public Utility(double utilityRate, int day, int month, int year){
    this.anniversaryDate = new Date(day, month, year); 
    this.utilityRate = utilityRate;
  }
  //getter method for Utility Rate
  public double getUtilityRate(){
    return this.utilityRate;
  }
  //setter method for Utility rate
  public void setUtilityRate(double utilityRate){
    this.utilityRate = utilityRate;
  }
  //getter method for MonthUsage
  public int getMonthUsage(){
    return this.monthUsage;
  }
  //setter method for MonthUsage
  public void setMonthUsage(int monthUsage){
    this.monthUsage = monthUsage;
  }
  //gettter method for yearUsage
  public int getYearUsage(){
    return this.yearUsage;
  }
  //method that update the year usage 
  public void updateYearUsage(int yearUsageUpdate){
    this.yearUsage = this.getYearUsage() + yearUsageUpdate; 
  }
  //method that return month bill
  public double getMonthBill(){
    return this.monthBill;
  }
  //method that set the month bill
  public void setMonthBill(double monthBill){
    this.monthBill = monthBill;
  }
  
  //method that get the balance on the account
  public double getBalance(){
    return this.balance;
  }

  //method for update the balance, Increases the balance by the amount input. 
  public void updateBalance(double balanceUpdate){
    this.balance = getBalance() + balanceUpdate;
  }
  //method that get the amount paid for the month
  public double getAmountPaid(){
    return this.amountPaid;
  }
  //method that update the amount paid
  public void updateAmountPaid(double amountUpdate){
    this.amountPaid = getAmountPaid() + amountUpdate;
  }
  /*method for make payment, it decreases the balance by the input amount and 
   * increases the amount paid so far this month by the input amount.*/
  public void makePayment(double payment){
    this.updateBalance(payment * -1);
    this.updateAmountPaid(payment);
  }
  //method that get the Aniversary Date for the account
  public Date getAnniversaryDate(){
    return this.anniversaryDate;
  }
   //method that set the Aniversary Date for the account
  public void setAnniversaryDate(int day, int month, int year){
    this.anniversaryDate = new Date(day, month, year);
  }
  //method that get the amount delinquent of the account
  public double getAmountDelinquent(){
    return this.amountDelinquent;
    }
  //method that set amount delinquent 
  public void setAmountDelinquent(double amountDelinquent){
    this.amountDelinquent = amountDelinquent; 
  }
  //method that set sales tax rate
  public void setSalesTaxRate (double salesTaxRate){
    this.salesTaxRate = salesTaxRate;
  }
  //method that get Sales Tax Rate
  public double getSalesTaxRate(){
    return this.salesTaxRate;
  }
  //method that set interest rate
  public void setInterestRate(double interestRate){
    this.interestRate = interestRate;
  }
  //method that get Interest Rate
  public double getInterestRate(){
   return this.interestRate;
  }
  //method that get monthly charge: utility rate * month usage
  public double getMonthlyCharge(){
    return this.getUtilityRate() * this.getMonthUsage();
  }
  /*method end of month processing*/
  public void endOfMonthProcessing(){
    // Adds the monthly charge to the balance.
    this.updateBalance(this.getMonthlyCharge());
    // Adds the sales tax times the monthly charge to the balance.
    this.updateBalance(this.getSalesTaxRate() * this.getMonthlyCharge());
    /*If the amount paid this month < month bill, 
     * adds the difference between the month bill and the amount paid this month to
 the delinquent amount.*/
    if (this.getAmountPaid() < this.getMonthBill()){
      this.setAmountDelinquent((this.getMonthBill() - this.getAmountPaid()) + 
this.getAmountDelinquent());
    }
    /*If the amount paid this month is greater than the month bill, 
     * subtracts the difference between the amount paid this month and the month 
bill from the delinquent amount*/
    if (this.getAmountPaid() > this.getMonthBill()){
      this.setAmountDelinquent(this.getAmountDelinquent() - (this.getMonthBill() - 
this.getAmountPaid()));
    }
    /*If the delinquent amount is positive, 
     *multiply the delinquent amount by the interest rate and 
     *add that value to both the delinquent amount and the balance.*/
    if(this.getAmountDelinquent() > 0){
      this.setAmountDelinquent(this.getAmountDelinquent()*this.getInterestRate());
      this.updateBalance(this.getAmountDelinquent()*this.getInterestRate());
    }
    //Sets the month bill to the current balance.
    this.setMonthBill(this.getBalance());
    //Sets the amount paid this month to 0.
    this.updateAmountPaid(this.getAmountPaid() * -1);
  }
  //method that set the year usage equal zero
  public void endOfYearProcessing(){
    this.updateYearUsage(this.getYearUsage() * -1);
  }
}
