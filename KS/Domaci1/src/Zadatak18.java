// Ideja za algoritam nalazi se na kraju fajla -->
class Zadatak18 extends Problem {
   Zadatak18() {
      super("Ispisati sve trocifrene brojeve cija je suma cifara jednaka ucitanom broju X.", 18);
   }

   @Override
   void Algorith() {      
      System.out.print("\nUnesite broj: ");
      // Morao sam da koristim float zbog mog eksvizitnog resenja
      int number = 0;
      // Error catching
      while (true) {
         try {
            String potentialNumber = System.console().readLine();
            number = Integer.parseInt(potentialNumber);
            // Jer maksimalan broj 9+9+9 = 27
            if(number > 27 || number < 0 || number%1 != 0 ) //provera frakcija na kraju 
               throw new Exception();
            break;
         }
         catch(Exception e) {
            System.out.println(Problem.colorText("Nevazeci unos, pokusajte ponovo (unesite pozitivan ceo broj manji od 27)", "red"));
         }
      }
      Problem.clearConsole();
      boolean firstFlag = true; //Radi ispisivanja da vidim da li treba da stavim zapetu
      System.out.println("Rezultat \n==========");
      for(int i = 100; i < 1000; i++) {
         int sumDecimals = i/100 + i%100/10 + i % 10;
         if(sumDecimals == number) {
            System.out.print( (firstFlag ? "" : ",") + i);
            firstFlag = false;
            }
         }
      System.out.println(" \n========== \n");
      }
   }