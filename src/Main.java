
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Giovani
 */
public class Main {
    public static void main(String[] args) {
        List<Gasto> listaGastos = new ArrayList<>();
        List<Ganho> listaGanhos = new ArrayList<>();
        Gasto novoGasto = null;
        Ganho novoGanho = null;
        System.out.println("Gestao Financeira");
        System.out.println("-----------------");
        System.out.println("1 - Adcionar gasto");
        System.out.println("2 - Adcionar ganho");
        System.out.println("3 - Relatorio de gastos");
        System.out.println("4 - Relatorio de ganhos");
        System.out.println("5 - Relatorio mensal");
        System.out.println("6 - Sair");
      
        Scanner enter = new Scanner(System.in);
        int opcao = enter.nextInt();
        enter.nextLine();
        switch (opcao){
            case 1:
                System.out.println("Adicionar Gasto");
                System.out.println("---------------");
                System.out.println("1 - Habitacao");
                System.out.println("2 - Entretenimento");
                System.out.println("3 - Alimentacao");
                System.out.println("4 - Transporte");
                System.out.println("5 - Outros gastos");
                System.out.println("6 - voltar");

                int t = enter.nextInt();
                enter.nextLine();
                if(t > 0 && t < 6 ){
                    System.out.println("Adicionar Gasto");
                    System.out.println("---------------");
                    System.out.print("Digite a data no formato ddMMyyyy: ");
                    int data = enter.nextInt();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
                    LocalDate d = LocalDate.parse(String.valueOf(data), formatter);
                    enter.nextLine();
             
                    System.out.print("Informe o valor: ");
                    double v = enter.nextDouble();
                    System.out.println("Selecione a forma de pagamento!");
                    System.out.println("-------------------------------");
                    System.out.println("1 - Cheque");
                    System.out.println("2 - Pix");
                    System.out.println("3 - Debito");
                    System.out.println("4 - Outras");
                    int f = enter.nextInt();
                    enter.nextLine();
                    
                    if (f <= 0 || f > 4){
                        limparConsole();
                        System.out.println("Digite uma das opções oferecidas!");
                        main(new String[]{"Voltar"});
                    }else{
                        System.out.println("Digite o nome do gasto(ex:Celesc): ");
                        String n = enter.nextLine();
                    
                        novoGasto = new Gasto(n,t,d,f,v);
                        listaGastos.add(novoGasto);
                        limparConsole();
                        main(new String[]{"Voltar"});
                    } 
                }
                if (t == 6){
                    limparConsole();
                    System.out.println("VOLTANDO..");
                    main(new String[]{"Voltar"});
                }
                else if (t > 6 || t <= 0){
                    limparConsole();
                    System.out.println("Digite uma opcao valida!");
                    System.out.println("VOLTANDO..");
                    main(new String[]{"Voltar"});
                }
                break;
            case 2:
                System.out.println("Adicionar Ganho");
                System.out.println("---------------");
                System.out.println("1 - salario");
                System.out.println("2 - freelancer");
                System.out.println("3 - Dividendos");
                System.out.println("4 - Outros");
                System.out.println("5 - voltar");
                
                int tGanho = enter.nextInt();
                enter.nextLine();
                if (tGanho > 0 && tGanho < 5){
                    System.out.println("Adicionar Ganho");
                    System.out.println("---------------");
                    System.out.print("Digite a data no formato ddMMyyyy: ");
                    
                    int data = enter.nextInt();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
                    LocalDate dGanho = LocalDate.parse(String.valueOf(data), formatter);
                    enter.nextLine();
                
                    System.out.print("Digite a origem(ex:ProjetoA): ");
                    String nGanho = enter.nextLine();
                    
                    System.out.println("Digite o valor do ganho:");
                    int vGanho = enter.nextInt();
                    enter.nextLine();
                    
                    novoGanho = new Ganho(nGanho, tGanho, vGanho,dGanho);
                    listaGanhos.add(novoGanho);
                    limparConsole();
                    main(new String[]{"Voltar"});
                }
                if (tGanho == 5){
                    limparConsole();
                    System.out.println("VOLTANDO..");
                    main(new String[]{"Voltar"});
                }
                else if (tGanho > 6 || tGanho <= 0){
                    limparConsole();
                    System.out.println("Digite uma opcao valida!");
                    System.out.println("VOLTANDO..");
                    main(new String[]{"Voltar"});
                }
                break;
            case 6:
                break;
            default:
                limparConsole();
                    System.out.println("Digite uma opcao valida!");
                    System.out.println("VOLTANDO..");
                    main(new String[]{"Voltar"});
        }
    }

    public static void limparConsole() {
    try {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_L);
    } 
    catch (Exception e) {
        main(new String[]{"Voltar"});
    }
}
}
