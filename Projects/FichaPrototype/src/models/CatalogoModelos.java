package models;
import java.util.HashMap;
import java.util.Map;

public class CatalogoModelos {
    private static CatalogoModelos instance;
    private Map<String, BaseFicha> modelos;

    private CatalogoModelos(){ this.modelos = new HashMap<>(); }

    public static CatalogoModelos getInstance(){
        if (instance == null) instance = new CatalogoModelos();
        return instance;
    }

    public void registrarModelo(String chave, BaseFicha modelo) { modelos.put(chave, modelo); }

    public BaseFicha criarFicha(String chave) {
        BaseFicha modelo = modelos.get(chave);
        if (modelo != null) return (BaseFicha) modelo.clone();
        throw new IllegalArgumentException("Modelo de ficha não encontrado.");
    }
}
