import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Recursao {
    public static Integer fatorial (Integer num) {

        if (num == 1) {
            return num;
        } else if (num == 0) {
            return 1;
        }

        return num * fatorial(num - 1);
    }

    private static Map<Integer, BigInteger> memo = new HashMap<>();

    public static BigInteger fatorialTopDown(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }

        // Verifica se já tem o valor
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Calcula o fatorial e armazena o resultado
        BigInteger resultado = BigInteger.valueOf(n).multiply(fatorialTopDown(n - 1));
        memo.put(n, resultado);

        return resultado;
    }

    public static int fatorialBottomUp(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        // Cria um array para armazenar os resultados
        int[] tabela = new int[n + 1];

        // Define os casos base
        tabela[0] = 1;
        tabela[1] = 1;

        // Calcula o fatorial de baixo para cima
        for (int i = 2; i <= n; i++) {
            tabela[i] = i * tabela[i - 1];
        }

        return tabela[n];
    }

    public static void main(String[] args) {
        // Não é possível calcular o fatorial de 100 com a recursão simples pois acaba ultrapassando o limite
        // de armazenamento de um inteiro
        System.out.println(fatorial(3));

        //Utilizando a abordagem Top-down Ainda não é possível calcular o fatorial de 100 mas tempo de reposta
        // diminui mais do que recursão normal (para resolver a recursão utilizei BigInteger)
        System.out.println(fatorialTopDown(100));

        //Utilizando a abordagem Bottom-up Ainda não é possível calcular o fatorial de 100 mas a diferença entre
        // a recursão normal para esta é que a complexidade de espaço da normal é O(n) e
        // Bottom-up é O(1) de tempo é igual O(n)
        System.out.println(fatorialBottomUp(5));

        //3. complexidade de tempo de recursão normal de uma seria de Fibonacci é O(2^n)
        // enquanto que utilizando programação dinamica é O(n) sendo a melhor abordagem
    }
}
