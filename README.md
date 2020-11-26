# cyberTop
Repositório destinado para o trabalho de TP1

## Postgres
* Para criação da database e das tabelas, por favor, entrar na pasta Scripts e utilizar os comandos do arquivo CriarDbTb: [Link direto para arquivo](https://github.com/thamipontes/cyberTop/blob/desen/cyberTop/Scripts/CreateDbTb)

* Após a criação da database e das tabelas, criar a relação de chave estrangeira com a tabela aluno e a tabela turma. O comando também se encontra no [arquivo CreateDbTb](https://github.com/thamipontes/cyberTop/blob/desen/cyberTop/Scripts/CreateDbTb)

```sql
ALTER TABLE public.aluno ADD CONSTRAINT aluno_fk FOREIGN KEY (id_turma) REFERENCES public.turma(id);
```

* Após a criação da database e das tabelas, inserir os dados de login e senha na tabela diretor que está no final do [arquivo CreateDbTb](https://github.com/thamipontes/cyberTop/blob/desen/cyberTop/Scripts/CreateDbTb) para autenticação do programa. 

```SQL
INSERT INTO public.diretor (login,senha)
	VALUES ('<nome_usuario>','<senha_usuario>');
```

* Ir até o arquivo [Conexao.java](https://github.com/thamipontes/cyberTop/blob/desen/cyberTop/src/dao/Conexao.java) e mudar para o usuário e a senha da conexão do seu banco:

```java
public class Conexao {
    public Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cybertop", "<nome_usuário>", "<senha_usuário>");
        return conexao;
    }
}
```

* Último passo é conferir se seu netbeans está reconhecendo o drive do PostgreSQL. 

1) Conferir se na pasta lib há o arquivo postgresql-42.2.5.jar
2) Abrir seu netbeans e apertar com o botão direito em cima de Libraries ou Bibliotecas (vai depender da linguaguem que está sua IDE).
3) Clicar em Add JAR/Folder... 
4) Navegar até a pasta lib (mencionada no tópico 1) e selecionar o arquivo postgresql-42.2.5.jar e dar enter.

