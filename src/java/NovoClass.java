
import bean.Veiculo;
import dao.VeiculoDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anderson
 */
public class NovoClass {

    public static void main(String[] args) {
//        testaInserir();
//        testaExcluir();
        testaListar();

    }

    public static void testaInserir() {
        VeiculoDao vDAO = new VeiculoDao();
        Veiculo v = new Veiculo();
        v.setMarca("reg-10");
        v.setModelo("reg-10");
        v.setPlaca("reg-10");
        v.setAno(10);

        if (vDAO.inserir(v)) {
            System.out.println("Registro inserido com sucesso!");
        }
    }

    public static void testaAlterar() {
        VeiculoDao pDao = new VeiculoDao();
        Veiculo p = new Veiculo();
        p.setIdveiculo(1);
        p.setMarca("ford");
        p.setPlaca("bvc-8073");
        p.setModelo("fusion");
        p.setAno(2017);

        if (pDao.alterar(p)) {
            System.out.println("Registro alterado com sucesso!");
        }
    }

    public static void testaExcluir() {
        VeiculoDao pDao = new VeiculoDao();
        Veiculo p = new Veiculo();
        p.setIdveiculo(2);

        if (pDao.excluir(p)) {
            System.out.println("Registro excluido com sucesso!");
        }
    }

    public static void testaConsultar() {
        VeiculoDao pDao = new VeiculoDao();
        Veiculo p = pDao.consultar(10);

        System.out.println(p.getModelo() + " - " + p.getModelo());

    }

    public static void testaListar() {
        VeiculoDao pDao = new VeiculoDao();
        for (Veiculo p : pDao.listar()) {
            System.out.println(p.getMarca()
                    + " - " + p.getPlaca()
                    + " - " + p.getModelo());
        }
    }

}
