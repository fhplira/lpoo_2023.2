<h1 align="center">📚 SBI - Sistema Bibliotecário Inteligente 📚</h1>

<p align="center">
    <img loading="lazy" src="https://img.shields.io/github/stars/fhplira/lpoo_2023.2%20?style=social"/>
    <img loading="lazy" src="https://img.shields.io/badge/linguagem%20-%20java%20-%20red"/>
    <img loading="lazy" src="https://img.shields.io/badge/maven%20-%20v4.0.1%20-%20blue"/>
    <img loading="lazy" src="https://img.shields.io/badge/status%20-%20conclu%C3%ADdo%20-%20lilac"/>
</p>

<h2> 📝Descrição do Projeto</h2>
Sistema desktop desenvolvido na disciplina de LPOO do curso de Análise e Desenvolvimento de Sistemas.

O SBI foi feito para ser utilizado por um bibliotecário, em que possa de maneira automatizada cadastrar, visualizar e ter controle dos livros, leitores e empréstimos.

<h2> 🛠Funcionalidades</h2>

- CRUD do Livro
    - Cadastrar livro automaticamente pelo ISBN informado, utilizamos a api do [Google Books](https://developers.google.com/books/docs/overview?hl=pt-br) para registrar as seguintes informações do livro:
        - titulo
        - autor
        - data de publicação
        - editora
        - descrição 
        - imagem do livro
     - Caso ocorra de não haver o livro na api ou alguma incosistência no sistema, o usuário deverá cadastrar os dados do livro manualmente.

 - CRUD do Leitor
     - O leitor poderá realizar apenas 2 empréstimos simultâneos.
     - O leitor não poderá realizar 2 empréstimos do mesmo livro simultâneos.

  - CRUD do Empréstimo
      - Envio de email automático para os leitores com informações de cadastro, empréstimos e devoluções.
      - Caso o empréstimo ultrapasse o dia da devolução do livro, o sistema irá contar os dias atrasados.
      - fazer devolução
   
  <h2> ✔Tecnologias e Bibliotecas</h2>
  
    - Java 11
    - Jdbc
    - MySQL
    - Json
    - Gson
    - Javax.mail-api
    - Jakarta.mail
    - commons-email
    - Junit
    - Mockito

  <h2> 💻Execução do Projeto</h2>
  
    - Necessário ter o MySQL Workbench 8, com o usuário 'root' e senha '12345'
    - Necessário ter o java 11 instalado

  <h2> Autores</h2>
  
  | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/84330067?s=400&u=b0c6aec8ea764f4cb3d05c17ce4d96937796d5d4&v=4" width=115><br><sub>Bianka Ibrahim</sub>](https://github.com/BiankaIbrahim) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/117605766?v=4" width=115><br><sub>Davi Monteiro</sub>](https://github.com/DaviiMont) |  [<img loading="lazy" src="https://avatars.githubusercontent.com/u/127352433?v=4" width=115><br><sub>Fernanda Helen</sub>](https://github.com/fhplira) |  [<img loading="lazy" src="https://avatars.githubusercontent.com/u/138726084?v=4" width=115><br><sub>Italo Tavares</sub>](https://github.com/TavaresItalo) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/103347207?v=4" width=115><br><sub>Nayara Maria</sub>](https://github.com/NayaraMar) |
| :---: | :---: | :---: |  :---: |  :---: |
      
