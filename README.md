# cyberTop
Repositório destinado para o trabalho de TP1

## Postgres
* Para criação da database e das tabelas, por favor, entrar na pasta Scripts e utilizar os comandos do arquivo CriarDbETb: [Link direto para arquivo](https://github.com/thamipontes/cyberTop/blob/desen/cyberTop/Scripts/CriarDbETb)

* Após a criação da database e das tabelas, inserir os dados de login e senha na tabela diretor para autenticação do programa. [Link direto para arquivo](https://github.com/thamipontes/cyberTop/blob/desen/cyberTop/Scripts/InsertDiretor)

* Ir até o arquivo [Conexao.java](https://github.com/thamipontes/cyberTop/blob/desen/cyberTop/src/dao/Conexao.java) e mudar para o usuário e a senha da conexão do seu banco:

```java
public class Conexao {
    public Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cybertop", "nome_usuário", "senha_usuário");
        return conexao;
    }
}

```

