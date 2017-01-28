import java.util.*;

public class StockPriceHurdle {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);

    System.out.println("This program calculates the Stock price at which the stock is equally " + 
	"or more attractive than the Ten Year Bond.");
    System.out.println("Enter the last eleven years of annual earnings: ");
    double[] earnings = new double[11];
    System.out.println(Arrays.toString(earnings)); // debugging print statement
    for (int i = 0; i < earnings.length; i++) {
      System.out.print("Enter Year " + (11 - i) + ": ");
      earnings[i] = console.nextDouble();
    }
    System.out.println();
    System.out.println(Arrays.toString(earnings)); // debugging print statement
    
    double avgPercentAnnualErngsIncrease;
    double sum = 0;
    for (int i = 0; i < earnings.length - 1; i++) {
      sum = sum + ((earnings[i] - earnings[i + 1])/earnings[i + 1]);
    }
    avgPercentAnnualErngsIncrease = (sum / (earnings.length - 1));
    System.out.println(avgPercentAnnualErngsIncrease * 100);

    double presentYrGain = earnings[0] * avgPercentAnnualErngsIncrease;
    double presentYrsProjectedErngs = earnings[0] + presentYrGain;
    System.out.println(presentYrsProjectedErngs);
    
    System.out.println("Enter the Ten Year Bond Rate (%): ");
    double tenYrBondRate = console.nextDouble()/100;
    double stockPriceFavorableToBond = presentYrsProjectedErngs / tenYrBondRate;
    System.out.println("Stock more attractive than bond at this price or less: " + 
	stockPriceFavorableToBond);

    double stockPriceAt15PercentDisc = presentYrsProjectedErngs / .15;
    System.out.println("Stock price for a minimum 15% return: " + stockPriceAt15PercentDisc);
  }
}
