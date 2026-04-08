package SingletonPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

Descrição
O Singleton é uma abordagem de design de software que visa assegurar a existência de apenas uma instância de uma classe e fornecer um ponto centralizado para acessá-la. Isso é especialmente benéfico em contextos nos quais é desejável manter uma única ocorrência de uma classe responsável pelo controle de um recurso compartilhado, como configurações, conexões de banco de dados ou caches.

Neste desafio, você deve criar um sistema de gerenciamento de usuários que permita adicionar e listar usuários. Você tem a opção de implementar o padrão Singleton para garantir que haja apenas uma instância do gerenciador de usuários em toda a aplicação. No entanto, a implementação do padrão Singleton é opcional e você pode optar por seguir uma abordagem diferente para resolver o desafio, se preferir.
____________________________________________________

Especificações do Desafio:

Crie uma classe User com os seguintes atributos: id (inteiro) e name (string).
Implemente uma classe UserManager que siga o padrão Singleton. Esta classe deve possuir as seguintes funcionalidades:

a. Adicionar um novo usuário ao sistema, recebendo o nome como entrada.

b. Listar todos os usuários cadastrados.


No programa principal (main), siga as etapas abaixo:

a. Solicite ao usuário a quantidade de usuários que deseja cadastrar.

b. Peça ao usuário para informar os nomes dos usuários, um por linha.

c. Após receber os nomes e cadastrar os usuários, liste os usuários cadastrados.

____________________________________________________

Entrada:

Um número inteiro representando a quantidade de usuários que o usuário deseja cadastrar.

Para cada usuário a ser cadastrado, uma string contendo o nome do usuário.

______________________

Saída:

Uma lista com os nomes dos usuários cadastrados.

Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

*/


class User {
    private final int id;
    private final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class UserManager {
  
  // TODO: Implementar o padrão Singleton para garantir que haja apenas uma instância do gerenciador de usuários

  private static UserManager managingInstance;
  
  private UserManager(){
    super();  
    }
  
  public static UserManager getInstance(){
      if (managingInstance == null){
        managingInstance = new UserManager();
      }
      return managingInstance;
    }

  private static final List<User> users = new ArrayList<>();
  
  public void addUser(int id, String name) {
        
    // TODO("Implementar a lógica de adicionar um novo usuário na lista mutável $users.")
    
    User newUser = new User(id, name);
    users.add(newUser);
  }

  public void listUsers() {

    //TODO("Implementar a impressão dos $users, seguindo o padrão definido no enunciado.")

    for (User user: users){
      System.out.println(user.getId() + " - " + user.getName());
    }
    
  }
  
}


public class SingletonPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager manager = UserManager.getInstance();

        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha após a leitura do número

        for (int i = 1; i <= quantity; i++) {
            String name = scanner.nextLine();
            manager.addUser(i, name);
        }

        manager.listUsers();
    }
}
