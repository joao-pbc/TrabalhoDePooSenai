package Utils;

import java.util.Arrays;
import java.util.List;

public class Telefone {
	
	  private static final List<String> DDDS_VALIDOS = Arrays.asList(
		        "11", "12", "13", "14", "15", "16", "17", "18", "19",
		        "21", "22", "24", "27", "28", "31", "32", "33", "34", "35", "37", "38",
		        "41", "42", "43", "44", "45", "46", "47", "48", "49",
		        "51", "53", "54", "55", "61", "62", "64", "65", "66", "67", "68", "69",
		        "71", "73", "74", "75", "77", "79",
		        "81", "82", "83", "84", "85", "86", "87", "88", "89",
		        "91", "92", "93", "94", "95", "96", "97", "98", "99"
		    );
	  
		    private String numero;
		    private String ddd;
		    private boolean isMovel;

		    public Telefone(String ddd, String numero) throws IllegalArgumentException {
		        if (!DDDS_VALIDOS.contains(ddd)) {
		            throw new IllegalArgumentException("DDD inválido.");
		        }

		        if (!isNumeroValido(numero)) {
		            throw new IllegalArgumentException("Número de telefone inválido.");
		        }

		        this.ddd = ddd;
		        this.numero = numero;
		        this.isMovel = isTelefoneMovel(numero);
		    }

		    private boolean isNumeroValido(String numero) {
		        return (numero.length() == 9) ||
		               (numero.length() == 8 );
		    }

		    private boolean isTelefoneMovel(String numero) {
		        return (numero.length() == 9);
		    }

		    public String getNumeroFormatado() {
		        if (isMovel) {
		            return String.format("(%s) %s-%s", ddd, numero.substring(0, 5), numero.substring(5));
		        } else {
		            return String.format("(%s) %s-%s", ddd, numero.substring(0, 4), numero.substring(4));
		        }
		    }

		    @Override
		    public String toString() {
		        return getNumeroFormatado();
		    }
}

