public class App {
    public static void main(String[] args) throws Exception {
        Problem zadaci[] = {new Zadatak18(), new Zadatak25(), new Zadatak36()};

        boolean didMiss = false;

        while(true) {
            Problem.clearConsole();
            if(didMiss) // U slucaju neispravnog unosa
                System.out.println(Problem.colorText("Neispravan unos, unesite redni broj zadatka", "red"));
            System.out.println("Izaberite zadatak za proveru");
            //Crtanje izbornog menija
            for(int i = 0 ; i < zadaci.length ; i++) {
                System.out.println("[" + (i+1) + "] " + zadaci[i].number + ". " + zadaci[i].name);
            }
            System.out.print("\nVas izbor: ");
            String potentialNum = System.console().readLine();
            int num;
            try {
                num = Integer.parseInt(potentialNum);
                System.out.println(num);
                if(num < 1 || num > zadaci.length)
                    throw new Exception("Neispravan unos");
                Problem.clearConsole();
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
                didMiss = true;
                continue;
            }
            didMiss = false;
            zadaci[num-1].Run();
        }
    }
}
