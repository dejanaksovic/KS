class Zadatak25 extends Problem {
   public Zadatak25() {
      super("Ispisati 10 najvecih trocifrenih brojeva deljivih sa K", 25);
   }
   
   @Override
   void Algorith() {
      int number;

      while(true) {
         System.out.print("\nUnesite broj: ");
         String potentialNumber = System.console().readLine();
         try {
            number = Integer.parseInt(potentialNumber);
            if(number == 0)
               throw new Exception();

            break;
         }
         catch(Exception e) {
            System.out.println(Problem.colorText("Neispravan unos, unesite ceo broj da nije nula", "red"));
         }
      }
      // Nalazimo prvi broj n, gde 100 <= n*K <= 999, a zatim smanjujemo n za jedan dok ne nadjemo brojeve ili ne vazi uslov
      boolean isFirst = true;
      int higestFactor = (999/number);
      Problem.clearConsole();
      System.out.println("Rezultat\n==========");
      for(int i = 0; i < 10; i++) {
         int nextHighest = higestFactor*number - i*number;
         if( nextHighest < 100 )
         return;
         System.out.print((isFirst ? "" : ", ") + nextHighest);
         isFirst = false;
      }
      System.out.println("\n==========\n");
   }
}