import server.Server;
import server.Arguments;
import entities.Person;
import interfaces.IEntity;
import java.util.Map;

public class BancoPessoas {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java BancoPessoas <command> [<args>]");
            System.out.printf("Commands:%n  - new <id> <name>%n  - delete <id> [id...]%n  - get <id>%n  - all%n");
            System.exit(1);
        }
        Server server = new Server();
        String cmd = args[0];

        try {
            Arguments arguments = null;
            switch (cmd) {
                case "new":
                    int idNew = Integer.parseInt(args[1]);
                    String name = args[2];
                    if (args.length == 4) // Nomes compostos
                        name += " " + args[3];
                    arguments = new Arguments(idNew, name);
                    break;
                case "delete":
                    Object[] idsDelete = new Object[args.length - 1];
                    for (int i = 1; i < args.length; i++)
                        idsDelete[i - 1] = Integer.parseInt(args[i]);
                    arguments = new Arguments(idsDelete);
                    break;

                case "get":
                    int idGet = Integer.parseInt(args[1]);
                    arguments = new Arguments(idGet);
                    break;

                case "all":
                    arguments = new Arguments(); // Passa vazio
                    break;

                default:
                    System.out.println("Unknow command: " + cmd);
                }
            Object result = server.service(cmd, arguments);

            if (cmd.equals("get")) {
                if (result != null) {
                    Person p = (Person) result; // Cast para Person para acessar getName()
                    System.out.println("Encontrado: ID " + p.getId() + " - Nome: " + p.getName());
                } else {
                    System.out.println("❌ Pessoa não encontrada.");
                }
            } else if (cmd.equals("all")) {
                Map<Integer, IEntity> map = (Map<Integer, IEntity>) result;
                if (map.isEmpty()) {
                    System.out.println("📂 O banco está vazio.");
                } else {
                    System.out.println("--- Lista de Pessoas ---");
                    for (IEntity entity : map.values()) {
                        Person p = (Person) entity;
                        System.out.println("ID: " + p.getId() + " | Nome: " + p.getName());
                    }
                    System.out.println("------------------------");
                }
            } else if (cmd.equals("new") || cmd.equals("delete"))
                server.save();

        } catch (NumberFormatException e) {
            System.out.println("⚠️ Erro: O campo <id> deve ser um número inteiro.");
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Erro de Sintaxe: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Erro inesperado: " + e.getMessage());
        }
    }
}