class Zadatak36 extends Problem {
   public Zadatak36() {
      super("Napisati program kojim se izracunava: S = 1/1! + 1/2! + ... + 1/n!", 36);
   }

   int Factorial(int n) {
      return n > 1 ? n * Factorial(n-1) : 1;
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
            Problem.clearConsole();
            break;
         }
         catch(Exception e) {
            System.out.println("Neispravan unos, unesite ceo broj da nije nula");
         }
      }

      float sum = 0;
      // I ovo moze rekurzijom, ali sam je prikazao gore vec
      for(int i = 1; i <= number ; i++) {
         sum = sum + (float)1.0/Factorial(i);
      }
      System.out.println("Rezultat\n========== \n" + sum + "\n==========");
   }
}