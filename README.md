"# meetRoom" 
Esse é um projeto para controle de reuniões, nele é possível registrar em um banco mysql e mostrar em uma página as informações da reunião, assim como atualizar, deletar e salvar, sendo as informações:<br>
<ul>
<li>name</li>
<li>starHour</li>
<li>endHour</li>
<li>Date</li>
<li>Responsible</li>
</ul><br>
<br>

Será necesserário criar um banco de dandos Mysql com nome meetroom, e um usuário Maria com as permissões de criar, alterar, deletar tabelas, assim como as permissões necessárias para manipular os dados da tabela, no mysql faça: <br> 
<ul>
<li>create user meetroom;</li>
<li>create database meetroom;</li>
<li>GRANT ALL PRIVILEGES ON meetroom. * TO 'maria'@'localhost';</li>
</ul><br>
Ou reconfigurar o aquivo ApplicationProperties de acordo com seu banco e nomes de preferência<br>

A página inicial do projeto é:<br>
http://localhost:4200/ListRoom<br>
Nela é possível ver a lista de reuniões, e deleta-las. E clicando em atualizar será redirecionado para página de atualizar e em clicando em "+" no topo da página, sera direcionado para página de criar<br>.