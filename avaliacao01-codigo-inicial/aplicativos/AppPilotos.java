package aplicativos;

import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Scanner;

import classes.Piloto;
import classes.Aeronave;


public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 10;
        int opcao, qtdCadastrados = 0;
        String CPF;
        Piloto[] pilotos = new Piloto[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);

        do {
            try {
                System.out.println("\n****\nMENU\n****\n");
                System.out.println("1 - Cadastrar piloto");
                System.out.println("2 - Listar pilotos cadastrados");
                System.out.println("3 - Localizar piloto pelo CPF");
                System.out.println("4 - Cadastrar aeronave");
                System.out.println("0 - Sair");
                System.out.print("Opção: ");
    
                opcao = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("As opções devem ser digitadas apenas em números.");
                System.out.println("Programa encerrado!");
                return;
            }  

                in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior
    
                if (opcao == 1) {
                    // Se não tem mais espaço no vetor, saio do cadastro
                    if (qtdCadastrados == MAX_ELEMENTOS) {
                        System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                        voltarMenu(in);
                        continue;
                    }
    
                    //Cadastre seu piloto aqui
                    else{
                        try{
                            Piloto piloto = new Piloto();
                            System.out.println("Escreva o nome do piloto:");
                            piloto.setNome(in.nextLine());
                            System.out.println("Digite o CPF do piloto");
                            piloto.setCpf(in.nextLine());
                            System.out.println("Digite o brevê do piloto");
                            piloto.setBreve(in.nextLine());
                            pilotos [qtdCadastrados] = piloto;
                            qtdCadastrados ++;
                            System.out.println("\nPiloto cadastrado com sucesso.");
                            voltarMenu(in);
                        } catch (InputMismatchException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Programa encerrado!");
                            continue;
                        }                           
                    }
     
                } else if (opcao == 2) {
                    // Se não tem ninguém cadastrado no vetor, caio fora
                    if (qtdCadastrados == 0) {
                        System.out.println("\nNão há pilotos cadastrados para exibir.");
                        voltarMenu(in);
                        continue; 
                    }
    
                    // Exiba os pilotos aqui
                    else if(pilotos[0] != null){
                        for (Piloto piloto : pilotos) {
                                if(piloto != null){
                                    System.out.println(piloto);
                                }
                            }
                            voltarMenu(in);
                        }  
                   
                 } else if (opcao == 3) {
                    Boolean encontrado = false;
    
                    if (qtdCadastrados == 0){
                        System.out.println("Não há pilotos cadastrados.");
                    }
                    else if (pilotos[0] != null){
                        System.out.println("Digite o CPF do piloto: ");
                        CPF = in.next();
                        for (Piloto piloto : pilotos) {
                            if(piloto != null && CPF .equals(piloto.getCpf())){
                                System.out.println(piloto);
                                encontrado = true;
                                System.out.println("Digite 0 para retornar ao MENU: ");
                                in.next();
                            }
                        }
                       
                    }
                       
                    else if(!encontrado){
                            System.out.println(" CPF não identificaado.");
                        }
                        voltarMenu(in);
    
                    }
    
                  else if (opcao == 4) {
                     // Se não tem ninguém cadastrado no vetor, caio fora
                     if (qtdCadastrados == 0) {
                        System.out.println("\nSem pilotos, não há como cadastrar uma aeronave");
                        voltarMenu(in);
                    }
    
                    else {
                        System.out.println("Informe o CPF do piloto:");
                        CPF = in.next();
                        for (Piloto piloto : pilotos) {
                            if(piloto != null && CPF .equals(piloto.getCpf())){
                                System.out.println("Informe o modelo da aeronave: ");
                                Aeronave aeronave = new Aeronave();
                                aeronave.setModelo(in.next());
                                System.out.println("Informe o número de série: ");
                                aeronave.setNumeroSerie(in.next());
                                piloto.setAeronave(aeronave);
                            }
                        }
                        voltarMenu(in);
                    }
    
                    //Solicite ao usuário o piloto
                    //Crie a aeronave vinculando-a ao piloto
                    System.out.println("\nAeronave cadastrada com sucesso.");
                    //Exiba os dados da aeronave
                    voltarMenu(in);
                }
                else if (opcao > 4) {
                    System.out.println("\nOpção inválida!");
                    voltarMenu(in);
                }        

            /*try {
            carro.setPlaca(null);
            
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            System.out.println("Programa encerrado!");
            return;*/
           
        } while (opcao != 0);
    }  

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}