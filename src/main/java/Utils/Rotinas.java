package Utils;

public class Rotinas {
	
	public static String RetornaApenasNumeros(String Texto) {
		String Retorno = "";
		
		for(int i = 0; i < Texto.length(); i++) {
			if(Character.isDigit(Texto.charAt(i))) {
				Retorno += Texto.charAt(i);
			}
		}
		
		return Retorno;
	}

	public static boolean validaCNPJ(String CNPJ) {
		
		String Numeros = RetornaApenasNumeros(CNPJ);
		int soma;
		int peso;
		int resto;
		int dv;
		
		if(Numeros.length() != 14) {
			return false;
		}
		
		if(Numeros.equals("00000000000000") || Numeros.equals("11111111111111") || Numeros.equals("22222222222222") || 
		   Numeros.equals("33333333333333") || Numeros.equals("44444444444444") || Numeros.equals("55555555555555") ||
		   Numeros.equals("66666666666666") || Numeros.equals("77777777777777") || Numeros.equals("99999999999999")) {
			
			return false;
		}
		
		soma = 0;
		peso = 2; 
		
		for(int i = 11; i >= 0; i--) {
			if(peso > 9) {
				peso = 2;
			}
			soma += ((Numeros.charAt(i) - 48) * peso++);
			
		}
		resto = soma % 11;
		if((resto == 0 ) || (resto  == 1)){
			dv = 0;
		} else {
			dv = 11 - resto;
		}
		
		
		if(dv != Numeros.charAt(12) - 48) {
			return false;
		}
		
		soma = 0;
		peso = 2; 
		
		for(int i = 12; i >= 0; i--) {
			if(peso > 9) {
				peso = 2;
			}
			soma += ((Numeros.charAt(i) - 48) * peso++);
		}
		resto = soma % 11;
		if((resto == 0 ) || (resto  == 1)){
			dv = 0;
		} else {
			dv = 11 - resto;
		}
		
		
		if(dv != Numeros.charAt(13) - 48) {
			return false;
		}
		
		return true;
	}
	
	public static boolean verificaCPF(String cpf) {

		cpf = cpf.replaceAll("[^0-9]", "");



        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {

            return false;

        }

        int[] numeros = new int[11];

        for (int i = 0; i < 11; i++) {

            numeros[i] = Character.getNumericValue(cpf.charAt(i));

        }



        int soma = 0;

        for (int i = 0; i < 9; i++) {

            soma += numeros[i] * (10 - i);

        }

        int digito1 = 11 - (soma % 11);

        if (digito1 > 9) {

            digito1 = 0;

        }

        if (numeros[9] != digito1) {

            return false;

        }

        soma = 0;

        for (int i = 0; i < 10; i++) {

            soma += numeros[i] * (11 - i);

        }

        int digito2 = 11 - (soma % 11);

        if (digito2 > 9) {

            digito2 = 0;

        }

        return numeros[10] == digito2;

	}
}
