package service;

import dao.CarroDAO;
import model.Carro;
import spark.Request;
import spark.Response;


public class CarroService {

	private CarroDAO carroDAO;

	public CarroService() {
		try {
			carroDAO = new CarroDAO();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Object add(Request request, Response response) {
		String marca = request.queryParams("marca");
		String modelo = request.queryParams("modelo");
		int ano = Integer.parseInt(request.queryParams("ano"));
		int codigo = Integer.parseInt(request.queryParams("codigo"));

		Carro carro = new Carro(codigo, marca, modelo, ano);

		carroDAO.insert(carro);

		response.status(201); // 201 Created
		return codigo;
	}

	public Object get(Request request, Response response) {
		int codigo = Integer.parseInt(request.params(":codigo"));
		
		Carro carro = (Carro) carroDAO.get(codigo);
		
		if (carro != null) {
    	    response.header("Content-Type", "application/json");
    	    response.header("Content-Encoding", "UTF-8");

            return "<carro>\n" + 
            		"\t<codigo>" + carro.getCodigo() + "</codigo>\n" +
            		"\t<marca>" + carro.getMarca() + "</marca>\n" +
            		"\t<modelo>" + carro.getModelo() + "</modelo>\n" +
            		"\t<ano>" + carro.getAno() + "</ano>\n" +
            		"</carro>\n";
        } else {
            response.status(404); // 404 Not found
            return "Carro " + codigo + " não encontrado.";
        }

	}

	public Object update(Request request, Response response) {
        int codigo = Integer.parseInt(request.params(":codigo"));
        
		Carro carro = (Carro) carroDAO.get(codigo);

        if (carro != null) {
        	carro.setCodigo(Integer.parseInt(request.queryParams("codigo")));
        	carro.setMarca(request.queryParams("marca"));
        	carro.setModelo(request.queryParams("modelo"));
        	carro.setAno(Integer.parseInt(request.queryParams("ano")));

        	carroDAO.update(carro);
        	
            return codigo;
        } else {
            response.status(404); // 404 Not found
            return "Carro não encontrado.";
        }

	}

	public Object remove(Request request, Response response) {
        int codigo = Integer.parseInt(request.params(":codigo"));

        Carro carro = (Carro) carroDAO.get(codigo);

        if (carro != null) {

            carroDAO.delete(codigo);

            response.status(200); // success
        	return codigo;
        } else {
            response.status(404); // 404 Not found
            return "Carro não encontrado.";
        }
	}

	public Object getAll(Request request, Response response) {
		StringBuffer returnValue = new StringBuffer("<carros type=\"array\">");
		for (Carro carro : carroDAO.get()) {
			returnValue.append("\n<carro>\n" + 
            		"\t<codigo>" + carro.getCodigo() + "</codigo>\n" +
            		"\t<marca>" + carro.getMarca() + "</marca>\n" +
            		"\t<modelo>" + carro.getModelo() + "</modelo>\n" +
            		"\t<ano>" + carro.getAno() + "</ano>\n" +
            		"</carro>\n");
		}
		returnValue.append("</carros>");
	    response.header("Content-Type", "application/json");
	    response.header("Content-Encoding", "UTF-8");
		return returnValue.toString();
	}
}