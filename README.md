📦 Módulo de Transporte - E-commerce

📌 Descrição
Este projeto simula o processo de entrega de pedidos em um sistema de e-commerce, incluindo:
- Cadastro de pedidos
- Cadastro de transportadoras
- Criação de entregas
- Escolha automática de transportadora com base no peso
- Atualização de status da entrega
  
---

🧠 Fluxo do Sistema
Pedido
→ Escolher Transportadora
→ Criar Entrega
→ Atualizar Status:
  AGUARDANDO_COLETA
  PEDIDO_COLETADO
  EM_TRANSPORTE
  EM_ROTA_DE_ENTREGA
  ENTREGUE
  
---
🏗️ Estrutura do Projeto
br.com.ecommerce.transporte

- model         # Entidades do sistema
-  dao           # Acesso ao banco de dados (interfaces + impl)
- service       # Regras de negócio
- exception     # Tratamento de erros
- util          # Conexão com banco (Singleton)
  
---

🗄️ Banco de Dados (Oracle)
Tabela: pedido
CREATE TABLE pedido (
   id INT PRIMARY KEY,
   peso DOUBLE,
   valor DOUBLE
);
Tabela: transportadora
CREATE TABLE transportadora (
   id INT PRIMARY KEY,
   nome VARCHAR(100),
   peso_min DOUBLE,
   peso_max DOUBLE,
   valor_base DOUBLE,
   prazo_dias INT
);
Tabela: entrega
CREATE TABLE entrega (
   id INT PRIMARY KEY,
   status VARCHAR(30),
   valor_frete DOUBLE,
   prazo_dias INT,
   pedido_id INT,
   transportadora_id INT
);

---

⚙️ Configuração do Banco
Edite a classe:
- ConnectionDB.java
E configure suas credenciais:
- String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
- String USER = "seu_usuario";
- String PASSWORD = "sua_senha";
  
---

▶️ Como Executar
1. Clonar o projeto
git clone <url-do-repositorio>

---

2. Abrir no IDE
Recomendado:
- IntelliJ IDEA
- Eclipse
- VS Code (com extensões Java)
- 
---

3. Configurar o Driver do Oracle
Adicione o driver JDBC do Oracle ao projeto:
- "ojdbc8.jar" ou superior
  
---

4. Criar as tabelas no banco
Execute os scripts SQL informados acima.

---

5. Executar a aplicação
Execute a classe:
Main.java

---

🧪 O que acontece ao rodar
O sistema irá:
1. Criar um pedido
2. Criar uma transportadora
3. Selecionar automaticamente a transportadora com base no peso
4. Criar uma entrega
5. Atualizar o status da entrega até "ENTREGUE"

---

👨‍💻 Autor:
1. Kauan Diogo
2. Matheus Machado
3. Lucas Villar
