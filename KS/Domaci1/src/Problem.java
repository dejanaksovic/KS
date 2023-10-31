// SVE VEZBAM
abstract class Problem {
   String name;
   int number;

   // Zaneo sam se, iskreno
   private static String RESET = "\u001B[0m";
   private static String RED = "\u001B[31m";
   private static String GREEN = "\u001B[32m";

   static public String colorText(String text, String color) {
      if(color == "red")
         return Problem.RED + text + Problem.RESET;
      else if(color == "green")
         return Problem.GREEN + text + Problem.RESET;
      return text;
   }

   // Workaround, ali bolji nego da se zezam sa interakcijom sa os-om sad
   // A static je jer sam zeleo da isprobam i to kako radi : ^)
   static public void clearConsole(int... lineNumber ) { 
      // Testing varargs, cisto iz fore, hteo sam da vidim kako rade pa je moguce dati broj praznih mesta za brisanje konzole, ako ne default = 50
      // Potencijalno testiranje da lie je fullscreen ili ne radi optimizacije (TODO???)
      int lines = lineNumber.length > 1 ? lineNumber[0] : 50; 
      for(int i = 0; i < lines; i++) {
         System.out.println("\n");
      }
   }

   public Problem(String name, int number) {
      //Svaki zadatak imace redni broj i kako glasi
      this.name = name;
      this.number = number;
   }

   // Ono sto pravimo po zadatku
   // potencijalna potpuna abstrakcija sa necim poput "callbacks" u js-u, mozda istrazim ako mi ne bude mucno
   abstract void Algorith();

   public void Run() {
      boolean isFirstTimeRan = true;
      // Mogucnost ponovnog pokretanja zadatka bez da se refresha program
      // Cistije resenje rekurzija, ali sam ovo vec iskodirao i mucno mi opet :D (TODO)
      while(true) {
         if(!isFirstTimeRan){
            // Nema smisla da proverimo hocemo li da igramo ponovo ili cistimo konzolu ako prvi put ulazimo u program
            System.out.println("Zelite li da igrate ponovo? (0 za izlaz, bilo koje drugo dugme za da)");
            String option = System.console().readLine();
            Problem.clearConsole();
            try { 
               int num = Integer.parseInt(option);
               if(num == 0)
                  return;
            }
            catch(Exception e) {
               ;
            }
         }
         // Printujemo broj zadatka, pa zadatak i pokrece algoritam
         System.out.println(number + "." + "\n" + name);

         Algorith();
         isFirstTimeRan = false;
      }
   }
}

// Ovim tempom pravim engine xd