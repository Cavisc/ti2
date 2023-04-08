const title = document.querySelector("h1");
const container = document.querySelector(".container");
const btnIn = document.querySelector(".in_btn");
const btnQuery = document.querySelector(".query_btn");
const reload = document.querySelector(".reload");

btnIn.addEventListener("click", () => {
  title.innerHTML = "Cadastro de Carros";
  container.innerHTML = `
  <form class="in_form">
  <input
    required
    placeholder="Código"
    type="text"
    id="codigo"
    name="codigo"
  /><br />

  <input
    required
    placeholder="Marca"
    type="text"
    id="marca"
    name="marca"
  /><br />

  <input
    required
    placeholder="Modelo"
    type="text"
    id="modelo"
    name="modelo"
  /><br />

  <input
    required
    placeholder="Ano"
    type="text"
    id="ano"
    name="ano"
  /><br />

  <button type="submit" value="Cadastrar">Cadastrar carro</button>
</form>
  `;
});

btnQuery.addEventListener("click", () => {
  title.innerHTML = "Ferramentas de Controle";
  container.innerHTML = `
  <div class="query_div">
  <button type="button" class="btn get">Consultar produto</button>
  <button type="button" class="btn up">Atualizar produto</button>
  <button type="button" class="btn del">Remover produto</button>
  <button type="button" class="btn list">Listar produtos</button>
</div>
  `;
});

reload.addEventListener("click", () => {
  window.location.reload();
});
