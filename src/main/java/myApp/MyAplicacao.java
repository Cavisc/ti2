package myApp;

import static spark.Spark.*;

import service.CarroService;

public class MyAplicacao {
	
	private static CarroService carroService = new CarroService();
	
    public static void main(String[] args) {
        port(6789);

        post("/carro", (request, response) -> carroService.add(request, response));

        get("/carro/:codigo", (request, response) -> carroService.get(request, response));

        get("/carro/update/:codigo", (request, response) -> carroService.update(request, response));

        get("/carro/delete/:codigo", (request, response) -> carroService.remove(request, response));

        get("/carro", (request, response) -> carroService.getAll(request, response));
               
    }
}