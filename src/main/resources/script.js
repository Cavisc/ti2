const title = document.querySelector("h1");
const container = document.querySelector(".container");
const btnIn = document.querySelector(".in_btn");
const btnQuery = document.querySelector(".query_btn");
let btnGet;
let btnUp;
let btnDel;
let btnList;
const reload = document.querySelector(".reload");

btnIn.addEventListener("click", () => {
  title.innerHTML = "Cadastro de Carros";
  container.innerHTML = `
  <form class="in_form" id="in_form" action="http://localhost:6789/carro" method="post">
  <input
    required
    placeholder="Código"
    type="number"
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
    type="number"
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
  <button type="button" class="btn get">Consultar carro</button>
  <button type="button" class="btn up">Atualizar carro</button>
  <button type="button" class="btn del">Remover carro</button>
  <form action="http://localhost:6789/carro"  method="get" id="all_form">
  	<button type="submit" class="btn list">Listar carros</button>
  </form>
</div>
  `;

  btnGet = document.querySelector(".get");
  btnUp = document.querySelector(".up");
  btnDel = document.querySelector(".del");
  btnList = document.querySelector(".list");

  btnGet.addEventListener("click", () => {
    title.innerHTML = "Cadastro de Carros";
    container.innerHTML = `
    <form class="get_form" id="get_form" onsubmit="addIdToPath('get_form', 'http://localhost:6789/carro/')" method="get">
    <input
      required
      placeholder="Código"
      type="text"
      id="codigo"
      name="codigo"
    /><br />
    <button type="submit" value="Consultar">Consultar carro</button>
  </form>
    `;
  });

  btnUp.addEventListener("click", () => {
    title.innerHTML = "Atualizar informações";
    container.innerHTML = `
    <form class="up_form" id="up_form" onsubmit="addIdToPath('up_form', 'http://localhost:6789/carro/update/')" method="get">
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
  
    <button type="submit" value="Atualizar">Atualizar carro</button>
  </form>
    `;
  });

  btnDel.addEventListener("click", () => {
    title.innerHTML = "Exclusão de Carros";
    container.innerHTML = `
    <form class="del_form" id="del_form" onsubmit="addIdToPath('del_form', 'http://localhost:6789/carro/delete/')" method="get">
    <input
      required
      placeholder="Código"
      type="text"
      id="codigo"
      name="codigo"
    /><br />
  
    <button type="submit" value="Deletar">Deletar carro</button>
  </form>
    `;
  });
});

reload.addEventListener("click", () => {
  window.location.reload();
});

function addIdToPath(form_name, base_url) {
  var your_form = document.getElementById(form_name);
  var codigo = your_form.elements.namedItem("codigo").value;
  action_src = base_url + codigo;
  your_form.action = action_src;
}
