<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Formulário de Criação</title>
        <style>
            .sDdd {
                width: 30px;
                text-align: center;
            }

            .sNumero {
                width: 100px;
                text-align: center;
            }

            .sTipo {
                width: 80px;
                text-align: center;
            }
        </style>
        <script>
            function adicionaLinha() {
                //Funcao adiciona uma nova linha na tabela
                var tabela = document.getElementById("tbl");
                var numeroLinhas = tabela.rows.length;
                var linha = tabela.insertRow(2);
                var celula1 = linha.insertCell(0);
                var celula2 = linha.insertCell(1);
                var celula3 = linha.insertCell(2);
                var celula4 = linha.insertCell(3);
                celula1.innerHTML = "<input class='sDdd' required='required' name='ddd'>";
                celula2.innerHTML = "<input class='sNumero' required='required' name='numero'>";
                celula3.innerHTML = "<input class='sTipo' required='required' name='tipo'>";
                celula4.innerHTML = "<button onclick='removeLinha(this)' required='required'> - </button>";
            }

            // funcao remove uma linha da tabela
            function removeLinha(linha) {
                var i = linha.parentNode.parentNode.rowIndex;
                document.getElementById('tbl').deleteRow(i);
            }
        </script>
    </head>

    <body>

        <h1>Formulário de Criação de Usuário</h1>
        <form action='PrimeiroServlet' method="post">
            <div>
                <h3>Dados Pessoais:</h3>
                <p>
                    Nome: <input required="required" type='text' name='nome'
                                 style="width: 300px" placeholder="Digite seu nome: Maria Alves">
                <p>
                    Email: <input required="required" type='text' name='email'
                                  style="width: 300px"
                                  placeholder="Digite seu email: maria@gmail.com">
                <p>
                    Senha: <input required="required" type='password' name='senha'
                                  style="width: 300px" placeholder="Digite sua senha">
                <p>
            </div>
            <h3>Telefones para Contato:</h3>
            <table border="1" id="tbl">
                <tr>
                    <td style="width: 30px; text-align: center">DDD</td>
                    <td style="width: 100px; text-align: center">Numero</td>
                    <td style="width: 80px; text-align: center">Tipo</td>
                    <td><button onclick="adicionaLinha()">+</button></td>
                </tr>
                <tr>
                    <td><input required="required" class="sDdd" name='ddd'></td>
                    <td><input required="required" class="sNumero" name='numero'></td>
                    <td><input required="required" class="sTipo" name='tipo'></td>
                    <td></td>
                </tr>
            </table>
            <br> <input type='submit' value='Salvar' name='pagina'>
            <button type="button"  onclick="parent.location.href='listUser.jsp'">Voltar</button>
        </form>
    </body>
</html>